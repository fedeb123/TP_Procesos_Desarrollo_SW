package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;

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
    public void finalizar(Partido partido) {
        partido.setEstado(new Finalizado());
        System.out.println("El partido ha finalizado.");
    }

    @Override
    public void cancelar(Partido partido) {
        System.out.println("No se puede cancelar un partido que ya está en juego.");
    }

    @Override
    public String toString() {
        return "En juego";
    }
}

