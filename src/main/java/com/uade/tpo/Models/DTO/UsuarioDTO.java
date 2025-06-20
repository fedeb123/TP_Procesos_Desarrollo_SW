package com.uade.tpo.Models.DTO;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.Models.Enums.TipoDeporte;
import com.uade.tpo.Models.Enums.TipoNivelDeJuego;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;

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
    private final IEmparejamiento metodoEmparejamiento;

    public UsuarioDTO(String nombre, String apellido, String correo, String contraseña, char sexo,
                      String dni, TipoNivelDeJuego nivelJuego, TipoDeporte deporteFavorito, Zona ubicacion, IEmparejamiento emparejamiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.sexo = sexo;
        this.dni = dni;
        this.nivelJuego = nivelJuego;
        this.deporteFavorito = deporteFavorito;
        this.ubicacion = ubicacion;
        this.metodoEmparejamiento = emparejamiento;
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


    public Usuario toUsuario() {
        return new Usuario(
                this.nombre,
                this.apellido,
                this.sexo,
                this.dni,
                this.correo,
                this.contraseña,
                this.deporteFavorito,
                this.nivelJuego,
                this.ubicacion,
                this.metodoEmparejamiento
        );
    }
}
