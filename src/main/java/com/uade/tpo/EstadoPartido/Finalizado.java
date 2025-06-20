package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Services.INotificacionService;

public class Finalizado implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido, INotificacionService notificacionService) {
        System.out.println("El partido ya finalizó. No se puede iniciar nuevamente.");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario jugador, INotificacionService notificacionService) {
        System.out.println("El partido ya finalizó. No se pueden agregar jugadores.");
    }

    @Override
    public void finalizar(Partido partido, INotificacionService notificacionService) {
        System.out.println("El partido ya se encuentra finalizado.");
    }

    @Override
    public void cancelar(Partido partido, INotificacionService notificacionService) {
        System.out.println("No se puede cancelar un partido que ya fue jugado.");
    }

    @Override
    public String toString() {
        return "Finalizado";
    }
}

