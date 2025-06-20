package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Services.INotificacionService;

public class Cancelado implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido, INotificacionService notificacionService) {
        System.out.println("El partido está cancelado. No se puede iniciar.");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario jugador, INotificacionService notificacionService) {
        System.out.println("El partido está cancelado. No se pueden agregar jugadores.");
    }

    @Override
    public void finalizar(Partido partido, INotificacionService notificacionService) {
        System.out.println("El partido está cancelado. No se puede finalizar.");
    }

    @Override
    public void cancelar(Partido partido, INotificacionService notificacionService) {
        System.out.println("El partido ya está cancelado.");
    }

    @Override
    public String toString() {
        return "Cancelado";
    }
}

