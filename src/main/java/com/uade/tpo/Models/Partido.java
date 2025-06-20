package com.uade.tpo.Models;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.EstadoPartido.IEstadoPartido;
import com.uade.tpo.EstadoPartido.NecesitaJugadores;
import com.uade.tpo.Observer.Observable;
import com.uade.tpo.Restriccion.IRestriccion;
import com.uade.tpo.Services.INotificacionService;

import java.util.ArrayList;
import java.util.Date;

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

    private Partido() {
    }

    public Partido(Enums.TipoDeporte tipoDeporte, Zona ubicacion, Date horario,
                   String direccion, Usuario organizadorPartido,
                   ArrayList<IRestriccion> restricciones,
                   IEmparejamiento metodoEmparejamiento, int cantidadJugadoresRequerida, float duracionEncuentro) {

        this.jugadores = new ArrayList<>();
        this.restricciones = restricciones;
        this.tipoDeporte = tipoDeporte;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.direccion = direccion;
        this.organizadorPartido = organizadorPartido;
        this.metodoEmparejamiento = metodoEmparejamiento;
        this.cantidadJugadoresRequerida = cantidadJugadoresRequerida;
        this.duracionEncuentro = duracionEncuentro;
        this.estado = new NecesitaJugadores();
    }

    public Partido(Enums.TipoDeporte tipoDeporte, Zona ubicacion, Date horario,
                   String direccion, Usuario organizadorPartido,
                   ArrayList<IRestriccion> restricciones,
                   IEmparejamiento metodoEmparejamiento) {

        this.jugadores = new ArrayList<>();
        this.restricciones = restricciones;
        this.tipoDeporte = tipoDeporte;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.direccion = direccion;
        this.organizadorPartido = organizadorPartido;
        this.metodoEmparejamiento = metodoEmparejamiento;
        this.estado = new NecesitaJugadores();
    }

    public void agregarJugador(Usuario usuario, INotificacionService notificacionService) {
        this.estado.agregarJugador(this, usuario, notificacionService);
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
