package com.uade.tpo.models;

import java.util.ArrayList;

import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.observer.INotificadorObserver;
import com.uade.tpo.services.NotificacionService;
import com.uade.tpo.views.VerNotificaciones;

public class Usuario implements INotificadorObserver {

    private String nombre;
    private String apellido;
    private char sexo;
    private String dni;
    private String correo;
    private String contraseña;
    private Enums.TipoDeporte deporteFav;
    private Enums.TipoNivelDeJuego nivelJuego;
    private Zona ubicacion;
    private ArrayList<String> notificaciones = new ArrayList<>();

    public Usuario(String nombre, String apellido, char sexo, String dni, String correo, String contraseña, Enums.TipoDeporte deporteFav, Enums.TipoNivelDeJuego nivelJuego, Zona ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dni = dni;
        this.correo = correo;
        this.contraseña = contraseña;
        this.deporteFav = deporteFav;
        this.nivelJuego = nivelJuego;
        this.ubicacion = ubicacion;
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

    @Override
    public void update(String notificacion){
        NotificacionService.getInstance().enviarNotificacion(notificacion, this);
    //    System.out.printf("Usuario: %s ha recibido la notificacion: %s %n", this.nombre, notificacion);
        System.out.printf("Usuario: %s ha recibido la notificacion: %s %n", this.nombre, notificacion);
        notificaciones.add(notificacion);
        //VerNotificaciones.agregarNotificacionGlobal(notificacion);
    }
    
    public UsuarioDTO toDTO(){
        return new UsuarioDTO(this.nombre, this.apellido, this.correo, this.contraseña, this.sexo, this.dni, this.nivelJuego, this.deporteFav, this.ubicacion.toDTO());
    }

    public ArrayList<String> getNotificaciones() {
    return new ArrayList<>(notificaciones);
}
    

}

