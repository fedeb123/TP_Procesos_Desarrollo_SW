package com.uade.tpo.models;

import java.util.ArrayList;
import java.util.Date;

import com.uade.tpo.emparejamiento.IEmparejamiento;
import com.uade.tpo.estadopartido.IEstadoPartido;
import com.uade.tpo.estadopartido.NecesitaJugadores;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.observer.NotificadorObservable;

public class Partido extends NotificadorObservable {
    private Enums.TipoDeporte tipoDeporte;
    private int cantidadJugadoresRequerida;
    private float duracionEncuentro;
    private Zona ubicacion;
    private Date horario;
    private IEstadoPartido estado;
    private String direccion;
    private Usuario organizadorPartido;
    private ArrayList<Usuario> jugadores;
    private ArrayList<Usuario> jugadoresConfirmados;
    private IEmparejamiento metodoEmparejamiento;
    private final Enums.TipoNivelDeJuego MinimoNivel;

    public Partido(Enums.TipoDeporte tipoDeporte, Zona ubicacion, Date horario, String direccion, Usuario organizadorPartido, IEmparejamiento metodoEmparejamiento, int cantidadJugadoresRequerida, float duracionEncuentro, Enums.TipoNivelDeJuego MinimoNivel) {
        this.jugadores = new ArrayList<>();
        this.jugadoresConfirmados = new ArrayList<>();
        this.tipoDeporte = tipoDeporte;
        this.ubicacion = ubicacion;
        this.horario = horario;
        this.direccion = direccion;
        this.organizadorPartido = organizadorPartido;
        this.metodoEmparejamiento = metodoEmparejamiento;
        this.estado = new NecesitaJugadores();
        this.cantidadJugadoresRequerida = cantidadJugadoresRequerida;
        this.duracionEncuentro = duracionEncuentro;
        this.MinimoNivel = MinimoNivel;
    }

    public void agregarJugador(Usuario usuario) {

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
        notificar("El partido cambió a: " + nuevoEstado.toString());
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

    public void confirmarJugador(Usuario jugador){
        this.estado.confirmarParticipacion(this, jugador);
    }

    public ArrayList<Usuario> getJugadoresConfirmados(){
        return this.jugadoresConfirmados;
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

    public Enums.TipoNivelDeJuego getMinimoNivel() {
        return MinimoNivel;
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

    public IEmparejamiento getMetodoEmparejamiento() {
        return metodoEmparejamiento;
    }

    public void setMetodoEmparejamiento(IEmparejamiento metodoEmparejamiento) {
        this.metodoEmparejamiento = metodoEmparejamiento;
    }

    public PartidoDTO toDTO(){
        return new PartidoDTO(this.tipoDeporte, this.ubicacion.toDTO(), this.horario, this.direccion, this.organizadorPartido.toDTO(), this.metodoEmparejamiento, this.cantidadJugadoresRequerida, this.duracionEncuentro, this.MinimoNivel);
    }


}
