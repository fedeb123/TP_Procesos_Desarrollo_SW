package com.uade.tpo.estadopartido;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Comentario;



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
    public void comentarPartido(Comentario comentario, Partido partido){
        System.out.println("No se puede comentar un partido no finalizado");
    }

    @Override
    public String toString() {
        return Enums.TipoEstadoPartido.CANCELADO.toString();
    }
}

