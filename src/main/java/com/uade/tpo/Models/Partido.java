package com.uade.tpo.Models;

import java.util.ArrayList;
import java.util.Date;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.EstadoPartido.IEstadoPartido;
import com.uade.tpo.Observer.Observable;
import com.uade.tpo.Restriccion.IRestriccion;

public class Partido extends Observable {
    private Enums.TipoDeporte tipoDeporte;
    private int cantidadJugadoresRequerida;
    private float duracionEncuentro;
    private Zona ubicacion;
    private Date horario;
    private IEstadoPartido estado;
    private String direccion;
    private Usuario organizadorPartido;
    private ArrayList<Usuario> jugadores;
    private ArrayList<IRestriccion> restricciones;
    private IEmparejamiento metodoEmparejamiento;

    public Partido() {
        this.jugadores = new ArrayList<>();
        this.restricciones = new ArrayList<>();
    }

    void agregarJugador(Usuario usuario) {
        this.estado.agregarJugador(this, usuario);
    }

    public void iniciar() {
        this.estado.iniciarPartido(this);
    }

    public void finalizar() {
        this.estado.finalizar(this);
    }

    public void cancelar() {
        this.estado.cancelar(this);
    }

    public void cambiarEstado(IEstadoPartido nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores("El partido cambió a: " + nuevoEstado.toString());
    }

    public void buscarPartido() {
    }

    public void crearEmparejamiento(Usuario usuario) {
    }

    public Enums.TipoDeporte getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(Enums.TipoDeporte tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public int getCantidadJugadoresRequerida() {
        return cantidadJugadoresRequerida;
    }

    public void setCantidadJugadoresRequerida(int cantidadJugadoresRequerida) {
        this.cantidadJugadoresRequerida = cantidadJugadoresRequerida;
    }

    public float getDuracionEncuentro() {
        return duracionEncuentro;
    }

    public void setDuracionEncuentro(float duracionEncuentro) {
        this.duracionEncuentro = duracionEncuentro;
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

    public IEstadoPartido getEstado() {
        return estado;
    }

    public void setEstado(IEstadoPartido estado) {
        this.estado = estado;
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

    public ArrayList<Usuario> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Usuario> jugadores) {
        this.jugadores = jugadores;
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


}
