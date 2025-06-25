package com.uade.tpo.Models;
import java.time.LocalDate;
public class Usuario {
    private final Long id;
    private String nombre;
    private String email;
    private LocalDate fechaRegistro;
    private int nivel;
    private int historialVictorias;
    private Ubicacion ubicacion;

    public Usuario(Long id, String nombre, String email, LocalDate fechaRegistro,
                   int nivel, int historialVictorias, Ubicacion ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.nivel = nivel;
        this.historialVictorias = historialVictorias;
        this.ubicacion = ubicacion;
    }
    // getters y setters...
    public int getHistorialVictorias() { return historialVictorias; }
    public Ubicacion getUbicacion() { return ubicacion; }
}

