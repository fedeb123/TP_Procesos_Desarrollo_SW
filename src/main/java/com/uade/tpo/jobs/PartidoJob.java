package com.uade.tpo.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.repositories.PartidoRepository;


public class PartidoJob {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    public void start() {
        Runnable iniciarPartidoConfirmado = () -> {
            ArrayList<Partido> partidos = PartidoRepository.getInstance().getPartidos();
            Date now = new Date();
            System.out.printf("Revisando hora actual: %s %n", now);
            for (Partido partido : partidos) {
                // Se asume que para un partido CONFIRMADO la representación textual del estado es "CONFIRMADO"
                if (partido.getEstado().toString().equals("CONFIRMADO") && !now.before(partido.getHorario())) {
                    System.out.println("Transicionando partido a En Juego: " + partido.getDireccion());
                    partido.iniciar();
                }
            }
        };

        Runnable terminarPartidoEnJuego = () -> {
            ArrayList<Partido> partidos = PartidoRepository.getInstance().getPartidos();
            Date now = new Date();
            for (Partido partido : partidos) {
                if (partido.getEstado().toString() == null ? Enums.TipoEstadoPartido.EN_JUEGO.toString() == null : partido.getEstado().toString().equals(Enums.TipoEstadoPartido.EN_JUEGO.toString())) {
                    Date fin = new Date(partido.getHorario().getTime() + TimeUnit.MINUTES.toMillis((long) partido.getDuracionEncuentro()));
                    if (!now.before(fin)) {
                        System.out.println("Transicionando partido a TERMINADO: " + partido.getDireccion());
                        partido.finalizar(); // que cambie el estado a TERMINADO
                    }
                }
            }
        };

        // Ejecuta la tarea cada minuto
        scheduler.scheduleAtFixedRate(iniciarPartidoConfirmado, 0, 1, TimeUnit.MINUTES);
        scheduler.scheduleAtFixedRate(terminarPartidoEnJuego, 0, 1, TimeUnit.MINUTES);

    }

    public void stop() {
        scheduler.shutdown();
    }
}

