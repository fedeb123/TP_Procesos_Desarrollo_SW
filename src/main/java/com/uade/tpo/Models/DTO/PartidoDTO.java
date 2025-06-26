package com.uade.tpo.models.dto;

import java.util.*;

import com.uade.tpo.emparejamiento.IEmparejamiento;
import com.uade.tpo.models.Enums;

public class PartidoDTO {
    private final Enums.TipoDeporte tipoDeporte;
    private final ZonaDTO ubicacion;
    private final Date horario;
    private final String direccion;
    private final UsuarioDTO organizadorPartido;
    private final IEmparejamiento metodoEmparejamiento;
    private final int cantidadJugadoresRequerida;
    private final float duracionEncuentro;
    private final Enums.TipoNivelDeJuego MinimoNivel;
    private final ArrayList<UsuarioDTO> jugadores;

    public PartidoDTO(Enums.TipoDeporte tipoDeporte, ZonaDTO ubicacion, Date horario, String direccion, UsuarioDTO organizadorPartido, IEmparejamiento metodoEmparejamiento, int cantidadJugadoresRequerida, float duracionEncuentro, Enums.TipoNivelDeJuego MinimoNivel, ArrayList<UsuarioDTO> jugadores) {

        this.tipoDeporte = tipoDeporte;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.direccion = direccion;
        this.organizadorPartido = organizadorPartido;
        this.metodoEmparejamiento = metodoEmparejamiento;
        this.cantidadJugadoresRequerida = cantidadJugadoresRequerida;
        this.duracionEncuentro = duracionEncuentro;
        this.MinimoNivel = MinimoNivel;
        this.jugadores = jugadores;
    }

    public Enums.TipoDeporte getTipoDeporte() {
        return this.tipoDeporte;
    }


    public ZonaDTO getUbicacion() {
        return this.ubicacion;
    }


    public Date getHorario() {
        return this.horario;
    }


    public String getDireccion() {
        return this.direccion;
    }


    public UsuarioDTO getOrganizadorPartido() {
        return this.organizadorPartido;
    }

    public IEmparejamiento getMetodoEmparejamiento() {
        return this.metodoEmparejamiento;
    }

    public int getCantidadJugadoresRequerida() {
        return this.cantidadJugadoresRequerida;
    }

    public float getDuracionEncuentro() {
        return this.duracionEncuentro;
    }

    public Enums.TipoNivelDeJuego getMinimoNivel() {
        return this.MinimoNivel;
    }

    public ArrayList<UsuarioDTO> getJugadores() {
        return this.jugadores;
    }


}
