package com.uade.tpo.estadopartido;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;

public class Armado implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido) {
        System.out.println("No se puede iniciar un partido no confirmado!");
    }

    @Override
    public void confirmarParticipacion(Partido partido, Usuario usuario){
        var cantidadActual = partido.getJugadores().size();
        var cantidadConfirmada = partido.getJugadoresConfirmados().size();

        if (partido.getJugadoresConfirmados().contains(usuario)) {
            System.err.printf("El jugador: %s ya fue confirmado %n", usuario.getNombre());
            return;
        }

        if (cantidadConfirmada < cantidadActual) {
            partido.getJugadoresConfirmados().add(usuario);
            cantidadConfirmada = partido.getJugadoresConfirmados().size();
            System.out.printf("Recibida confirmacion de: %s %n", usuario.getNombre());
        }

        if (cantidadActual == cantidadConfirmada){
            partido.setEstado(new Confirmado());
            partido.notificar("Partido confirmado automaticamente!");
            System.out.println("Confirmando partido");
        }

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

        partido.notificar("Partido cancelado");


        for (Usuario u: partido.getJugadores()){
            partido.eliminarObservador(u);
        }

        System.out.println("El partido fue cancelado.");
    }

    @Override
    public String toString() {
        return Enums.TipoEstadoPartido.PARTIDO_ARMADO.toString();

    }
}

