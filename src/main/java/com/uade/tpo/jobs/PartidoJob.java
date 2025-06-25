package com.uade.tpo.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.uade.tpo.models.Partido;
import com.uade.tpo.repositories.PartidoRepository;


public class PartidoJob {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void start() {
        Runnable task = () -> {
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

        // Ejecuta la tarea cada minuto
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }

    public void stop() {
        scheduler.shutdown();
    }
}

