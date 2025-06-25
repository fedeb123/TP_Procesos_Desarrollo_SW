package com.uade.tpo.estadopartido;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;


public class Finalizado implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido) {
        System.out.println("El partido ya finalizó. No se puede iniciar nuevamente.");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario jugador) {
        System.out.println("El partido ya finalizó. No se pueden agregar jugadores.");
    }

    @Override
    public void confirmarParticipacion(Partido partido, Usuario usuario){
        System.out.println("El partido está finalizado. No se pueden confirmar jugadores.");
    }

    @Override
    public void finalizar(Partido partido) {
        System.out.println("El partido ya se encuentra finalizado.");
    }

    @Override
    public void cancelar(Partido partido) {
        System.out.println("No se puede cancelar un partido que ya fue jugado.");
    }

    @Override
    public String toString() {
        return Enums.TipoEstadoPartido.FINALIZADO.toString();

    }
}

