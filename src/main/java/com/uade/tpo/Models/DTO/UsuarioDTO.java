package com.uade.tpo.models.dto;

import java.util.ArrayList;

import com.uade.tpo.models.Enums.TipoDeporte;
import com.uade.tpo.models.Enums.TipoNivelDeJuego;

public class UsuarioDTO {
    private final String nombre;
    private final String apellido;
    private final String correo;
    private final String contraseña;
    private final char sexo;
    private final String dni;
    private final TipoNivelDeJuego nivelJuego;
    private final TipoDeporte deporteFavorito;
    private final ZonaDTO ubicacion;
    private ArrayList<String> notificaciones = new ArrayList<>();


    public UsuarioDTO(String nombre, String apellido, String correo, String contraseña, char sexo, String dni, TipoNivelDeJuego nivelJuego, TipoDeporte deporteFavorito, ZonaDTO ubicacion, ArrayList<String> notificaciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.sexo = sexo;
        this.dni = dni;
        this.nivelJuego = nivelJuego;
        this.deporteFavorito = deporteFavorito;
        this.ubicacion = ubicacion;
        this.notificaciones = notificaciones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public char getSexo() {
        return this.sexo;
    }

    public String getDni() {
        return this.dni;
    }

    public TipoNivelDeJuego getNivelJuego() {
        return this.nivelJuego;
    }

    public TipoDeporte getDeporteFavorito() {
        return this.deporteFavorito;
    }

    public ZonaDTO getUbicacion() {
        return this.ubicacion;
    }

    public ArrayList<String> getNotificaciones() {
        return this.notificaciones;
    }

} 

