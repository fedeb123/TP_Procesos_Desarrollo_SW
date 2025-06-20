package com.uade.tpo.Models;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.Observer.Observer;
import com.uade.tpo.Services.INotificacionService;

public class Usuario implements Observer {

    private String nombre;
    private String apellido;
    private char sexo;
    private String dni;
    private String correo;
    private String contraseña;
    private Enums.TipoDeporte deporteFav;
    private Enums.TipoNivelDeJuego nivelJuego;
    private Zona ubicacion;
    private IEmparejamiento metodoEmparejamiento;

    public Usuario(String nombre, String apellido, char sexo, String dni, String correo, String contraseña,
                   Enums.TipoDeporte deporteFav, Enums.TipoNivelDeJuego nivelJuego, Zona ubicacion,
                   IEmparejamiento metodoEmparejamiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.correo = correo;
        this.contraseña = contraseña;
        this.deporteFav = deporteFav;
        this.nivelJuego = nivelJuego;
        this.ubicacion = ubicacion;
        this.metodoEmparejamiento = metodoEmparejamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Enums.TipoDeporte getDeporteFav() {
        return deporteFav;
    }

    public void setDeporteFav(Enums.TipoDeporte deporteFav) {
        this.deporteFav = deporteFav;
    }

    public Enums.TipoNivelDeJuego getNivelJuego() {
        return nivelJuego;
    }

    public void setNivelJuego(Enums.TipoNivelDeJuego nivelJuego) {
        this.nivelJuego = nivelJuego;
    }

    public Zona getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Zona ubicacion) {
        this.ubicacion = ubicacion;
    }

    public IEmparejamiento getMetodoEmparejamiento() {
        return metodoEmparejamiento;
    }

    public void setMetodoEmparejamiento(IEmparejamiento metodoEmparejamiento) {
        this.metodoEmparejamiento = metodoEmparejamiento;
    }

    public void cambiarMetodoEmparejamiento(IEmparejamiento nuevoMetodo) {
        this.metodoEmparejamiento = nuevoMetodo;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("[" + nombre + "] recibió notificación: " + mensaje);
    }
}

