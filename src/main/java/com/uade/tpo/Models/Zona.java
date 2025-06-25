package com.uade.tpo.Models;
import com.uade.tpo.EstadoPartido.IEstadoPartido;
import com.uade.tpo.EstadoPartido.Armado;
import com.uade.tpo.EstadoPartido.NecesitaJugadores;
public class Zona {
    private final Long id;
    private final Ubicacion centro;
    private final IEstadoPartido estadoInicial;
    public Zona(Long id, Ubicacion centro) {
        this.id = id;
        this.centro = centro;
        this.estadoInicial = new Armado();
    }
    public Long getId() { return id; }
    public Ubicacion getCentro() { return centro; }
    public IEstadoPartido estadoInicial() { return estadoInicial; }
    // logic to determine next state based on participantes count
    public IEstadoPartido proximoEstado(int participantesCount) {
        if (participantesCount < 2) {
            return new NecesitaJugadores();
        }
        return new Confirmado();
    }
}



