package com.uade.tpo.estadopartido;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;


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
    public void confirmarParticipacion(Partido partido, Usuario usuario){
        System.out.println("El partido está cancelado. No se pueden confirmar jugadores.");
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
        return Enums.TipoEstadoPartido.CANCELADO.toString();
    }
}

