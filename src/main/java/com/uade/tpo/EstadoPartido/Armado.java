package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Services.INotificacionService;

public class Armado implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido, INotificacionService notificacionService) {
        partido.setEstado(new Confirmado());
        System.out.println("Confirmando partido");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario jugador, INotificacionService notificacionService) {
        System.out.println("El partido ya está armado, no se pueden agregar más jugadores.");
    }

    @Override
    public void finalizar(Partido partido, INotificacionService notificacionService) {
        System.out.println("No se puede finalizar el partido antes de que inicie.");
    }

    @Override
    public void cancelar(Partido partido, INotificacionService notificacionService) {
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

