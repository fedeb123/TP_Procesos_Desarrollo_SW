package com.uade.tpo.Models.DTO;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.Models.Enums.TipoDeporte;
import com.uade.tpo.Models.Enums.TipoNivelDeJuego;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;

public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private char sexo;
    private String dni;
    private TipoNivelDeJuego nivelJuego;
    private TipoDeporte deporteFavorito;
    private Zona ubicacion;
    private IEmparejamiento metodoEmparejamiento;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public TipoNivelDeJuego getNivelJuego() {
        return nivelJuego;
    }

    public void setNivelJuego(TipoNivelDeJuego nivelJuego) {
        this.nivelJuego = nivelJuego;
    }

    public TipoDeporte getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(TipoDeporte deporteFavorito) {
        this.deporteFavorito = deporteFavorito;
    }

    public Zona getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Zona ubicacion) {
        this.ubicacion = ubicacion;
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
