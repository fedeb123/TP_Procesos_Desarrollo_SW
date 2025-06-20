package com.uade.tpo.Models.DTO;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.Restriccion.IRestriccion;

import java.util.ArrayList;
import java.util.Date;

public class PartidoDTO {
    private Enums.TipoDeporte tipoDeporte;
    private Zona ubicacion;
    private Date horario;
    private String direccion;
    private Usuario organizadorPartido;
    private ArrayList<IRestriccion> restricciones;
    private IEmparejamiento metodoEmparejamiento;

    public PartidoDTO(Enums.TipoDeporte tipoDeporte, Zona ubicacion, Date horario,
                      String direccion, Usuario organizadorPartido,
                      ArrayList<IRestriccion> restricciones,
                      IEmparejamiento metodoEmparejamiento) {
        this.tipoDeporte = tipoDeporte;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.direccion = direccion;
        this.organizadorPartido = organizadorPartido;
        this.restricciones = restricciones;
        this.metodoEmparejamiento = metodoEmparejamiento;
    }

    // Getters y setters...

    public Enums.TipoDeporte getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(Enums.TipoDeporte tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public Zona getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Zona ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getOrganizadorPartido() {
        return organizadorPartido;
    }

    public void setOrganizadorPartido(Usuario organizadorPartido) {
        this.organizadorPartido = organizadorPartido;
    }

    public ArrayList<IRestriccion> getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(ArrayList<IRestriccion> restricciones) {
        this.restricciones = restricciones;
    }

    public IEmparejamiento getMetodoEmparejamiento() {
        return metodoEmparejamiento;
    }

    public void setMetodoEmparejamiento(IEmparejamiento metodoEmparejamiento) {
        this.metodoEmparejamiento = metodoEmparejamiento;
    }

    public Partido toPartido() {
        return new Partido(
                this.tipoDeporte,
                this.ubicacion,
                this.horario,
                this.direccion,
                this.organizadorPartido,
                this.restricciones,
                this.metodoEmparejamiento
        );
    }
}
