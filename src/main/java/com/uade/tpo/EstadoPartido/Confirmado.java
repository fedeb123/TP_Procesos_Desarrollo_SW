package com.uade.tpo.estadopartido;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;

public class Confirmado implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido) {
        partido.setEstado(new EnJuego());

        partido.notificar("Partido en juego");



        System.out.println("El partido ha comenzado.");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario jugador) {
        System.out.println("El partido ya fue confirmado. No se pueden agregar jugadores.");
    }

    @Override
    public void finalizar(Partido partido) {
        System.out.println("El partido aún no comenzó. No se puede finalizar.");
    }

    @Override
    public void cancelar(Partido partido) {
        partido.setEstado(new Cancelado());

        partido.notificar("Partido cancelado");


        for (Usuario u: partido.getJugadores()){
            partido.eliminarObservador(u);
        }

        System.out.println("El partido fue cancelado antes de comenzar.");
    }

    @Override
    public String toString() {
        return Enums.TipoEstadoPartido.CONFIRMADO.toString();

    }
}

