package com.uade.tpo.models.dto;

import com.uade.tpo.models.Enums.TipoDeporte;
import com.uade.tpo.models.Enums.TipoNivelDeJuego;
import com.uade.tpo.models.Zona;

public class UsuarioDTO {
    private final String nombre;
    private final String apellido;
    private final String correo;
    private final String contraseña;
    private final char sexo;
    private final String dni;
    private final TipoNivelDeJuego nivelJuego;
    private final TipoDeporte deporteFavorito;
    private final Zona ubicacion;

    public UsuarioDTO(String nombre, String apellido, String correo, String contraseña, char sexo, String dni, TipoNivelDeJuego nivelJuego, TipoDeporte deporteFavorito, Zona ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.sexo = sexo;
        this.dni = dni;
        this.nivelJuego = nivelJuego;
        this.deporteFavorito = deporteFavorito;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public String getCorreo() {
        return correo;
    }


    public String getContraseña() {
        return contraseña;
    }


    public char getSexo() {
        return sexo;
    }


    public String getDni() {
        return dni;
    }


    public TipoNivelDeJuego getNivelJuego() {
        return nivelJuego;
    }


    public TipoDeporte getDeporteFavorito() {
        return deporteFavorito;
    }


    public Zona getUbicacion() {
        return ubicacion;
    }

}
