package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;

public class Cancelado implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido) {
        System.out.println("El partido está cancelado. No se puede iniciar.");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario jugador) {
        System.out.println("El partido está cancelado. No se pueden agregar jugadores.");
    }

    @Override
    public void finalizar(Partido partido) {
        System.out.println("El partido está cancelado. No se puede finalizar.");
    }

    @Override
    public void cancelar(Partido partido) {
        System.out.println("El partido ya está cancelado.");
    }

    @Override
    public String toString() {
        return "Cancelado";
    }
}

