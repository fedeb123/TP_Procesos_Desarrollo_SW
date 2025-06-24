package com.uade.tpo.Models.DTO;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.Restriccion.IRestriccion;
import com.uade.tpo.Services.INotificacionService;

import java.util.ArrayList;
import java.util.Date;

public class PartidoDTO {
    private final Enums.TipoDeporte tipoDeporte;
    private final Zona ubicacion;
    private final Date horario;
    private final String direccion;
    private final Usuario organizadorPartido;
    private final ArrayList<IRestriccion> restricciones;
    private final IEmparejamiento metodoEmparejamiento;
    private final int cantidadJugadoresRequerida;
    private final float duracionEncuentro;
    private Enums.TipoNivelDeJuego maximoNivel;

    public PartidoDTO(Enums.TipoDeporte tipoDeporte, Zona ubicacion, Date horario,
                      String direccion, Usuario organizadorPartido,
                      ArrayList<IRestriccion> restricciones,
                      IEmparejamiento metodoEmparejamiento, int cantidadJugadoresRequerida, float duracionEncuentro) {

        this.tipoDeporte = tipoDeporte;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.direccion = direccion;
        this.organizadorPartido = organizadorPartido;
        this.restricciones = restricciones;
        this.metodoEmparejamiento = metodoEmparejamiento;
        this.cantidadJugadoresRequerida = cantidadJugadoresRequerida;
        this.duracionEncuentro = duracionEncuentro;
    }

    public Enums.TipoDeporte getTipoDeporte() {
        return tipoDeporte;
    }


    public Zona getUbicacion() {
        return ubicacion;
    }


    public Date getHorario() {
        return horario;
    }


    public String getDireccion() {
        return direccion;
    }


    public Usuario getOrganizadorPartido() {
        return organizadorPartido;
    }


    public ArrayList<IRestriccion> getRestricciones() {
        return restricciones;
    }


    public IEmparejamiento getMetodoEmparejamiento() {
        return metodoEmparejamiento;
    }


    public Partido toPartido(INotificacionService notificacionService) {
        return new Partido(
                this.tipoDeporte,
                this.ubicacion,
                this.horario,
                this.direccion,
                this.organizadorPartido,
                this.restricciones,
                this.metodoEmparejamiento,
                this.cantidadJugadoresRequerida,
                this.duracionEncuentro,
                notificacionService,
                this.maximoNivel
        );
    }
}
