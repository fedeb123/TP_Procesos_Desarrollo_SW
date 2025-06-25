package com.uade.tpo.estadopartido;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;


public class EnJuego implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido) {
        System.out.println("El partido ya está en curso.");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario jugador) {
        System.out.println("No se pueden agregar jugadores mientras el partido está en juego.");
    }

    @Override
    public void confirmarParticipacion(Partido partido, Usuario usuario){
        System.out.println("El partido está en curso. No se pueden confirmar jugadores.");
    }

    @Override
    public void finalizar(Partido partido) {
        partido.setEstado(new Finalizado());

        partido.notificar("Partido finalizado");


        for (Usuario u : partido.getJugadores()) {
            partido.eliminarObservador(u);
        }

        System.out.println("El partido ha finalizado.");
    }

    @Override
    public void cancelar(Partido partido) {
        System.out.println("No se puede cancelar un partido que ya está en juego.");
    }

    @Override
    public String toString() {
        return Enums.TipoEstadoPartido.EN_JUEGO.toString();

    }
}

