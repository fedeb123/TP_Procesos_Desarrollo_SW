package com.uade.tpo.estadopartido;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;


public class NecesitaJugadores implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido) {
        // No se puede iniciar aún, faltan jugadores
        System.out.println("No se puede iniciar el partido, aún faltan jugadores.");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario usuario) {

        if (!partido.getMetodoEmparejamiento().puedeUnirse(usuario, partido)){
            System.out.printf("%s: No puede unirse, no cumple con las restricciones de emparejamiento del partido %n", usuario.getNombre());
            return;
        }

        partido.getJugadores().add(usuario);
        partido.agregarObservador(usuario);

        System.out.printf("%s agregado al partido %n ", usuario.getNombre());

        if (partido.getJugadores().size() == partido.getCantidadJugadoresRequerida()) {
            partido.setEstado(new Armado());

            partido.notificar("Partido armado");

            System.out.println("Partido armado automáticamente.");
        }
    }

    @Override
    public void finalizar(Partido partido) {
        System.out.println("No se puede finalizar el partido. Todavía no comenzó.");
    }

    @Override
    public void cancelar(Partido partido) {
        partido.setEstado(new Cancelado());

        partido.notificar("Partido cancelado");

        for (Usuario u : partido.getJugadores()) {

            partido.eliminarObservador(u);
        }

        System.out.println("Partido cancelado.");
    }

    @Override
    public String toString() {
        return Enums.TipoEstadoPartido.NECESITA_JUGADORES.toString();
    }
}

