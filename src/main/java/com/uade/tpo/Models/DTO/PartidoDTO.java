package com.uade.tpo.models.dto;

import java.util.Date;

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

    public PartidoDTO(Enums.TipoDeporte tipoDeporte, ZonaDTO ubicacion, Date horario, String direccion, UsuarioDTO organizadorPartido, IEmparejamiento metodoEmparejamiento, int cantidadJugadoresRequerida, float duracionEncuentro, Enums.TipoNivelDeJuego MinimoNivel) {

        this.tipoDeporte = tipoDeporte;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.direccion = direccion;
        this.organizadorPartido = organizadorPartido;
        this.metodoEmparejamiento = metodoEmparejamiento;
        this.cantidadJugadoresRequerida = cantidadJugadoresRequerida;
        this.duracionEncuentro = duracionEncuentro;
        this.MinimoNivel = MinimoNivel;
    }

    public Enums.TipoDeporte getTipoDeporte() {
        return tipoDeporte;
    }


    public ZonaDTO getUbicacion() {
        return ubicacion;
    }


    public Date getHorario() {
        return horario;
    }


    public String getDireccion() {
        return direccion;
    }


    public UsuarioDTO getOrganizadorPartido() {
        return organizadorPartido;
    }

    public IEmparejamiento getMetodoEmparejamiento() {
        return metodoEmparejamiento;
    }

    public int getCantidadJugadoresRequerida() {
        return cantidadJugadoresRequerida;
    }

    public float getDuracionEncuentro() {
        return duracionEncuentro;
    }

    public Enums.TipoNivelDeJuego getMinimoNivel() {
        return MinimoNivel;
    }

}
