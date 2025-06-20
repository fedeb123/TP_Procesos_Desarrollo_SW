package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Partido;

public class NecesitaJugadores implements IEstadoPartido {

    @Override
    public void iniciarPartido(Partido partido) {
        // No se puede iniciar aún, faltan jugadores
        System.out.println("No se puede iniciar el partido, aún faltan jugadores.");
    }

    @Override
    public void agregarJugador(Partido partido, Usuario usuario) {
        partido.getJugadores().add(usuario);
        partido.agregarObservador(usuario);

        System.out.printf("%s agregado al partido %n ", usuario.getNombre());

        if (partido.getJugadores().size() == partido.getCantidadJugadoresRequerida()){
            partido.setEstado(new Armado());
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

        for (Usuario u: partido.getJugadores()){
            partido.eliminarObservador(u);
        }

        System.out.println("Partido cancelado.");
    }

    @Override
    public String toString() {
        return Enums.TipoEstadoPartido.NECESITA_JUGADORES.toString();
    }
}

