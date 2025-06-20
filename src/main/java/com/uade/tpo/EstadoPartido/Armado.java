package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;

public class Armado implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido) {
        partido.setEstado(new Confirmado());
        System.out.println("Confirmando partido");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario jugador) {
        System.out.println("El partido ya está armado, no se pueden agregar más jugadores.");
    }

    @Override
    public void finalizar(Partido partido) {
        System.out.println("No se puede finalizar el partido antes de que inicie.");
    }

    @Override
    public void cancelar(Partido partido) {
        partido.setEstado(new Cancelado());

        for (Usuario u: partido.getJugadores()){
            partido.eliminarObservador(u);
        }

        System.out.println("El partido fue cancelado.");
    }

    @Override
    public String toString() {
        return "Partido armado";
    }
}

