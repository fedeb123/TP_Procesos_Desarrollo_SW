package com.uade.tpo.DTO;
import java.time.LocalDate;
public class UsuarioDTO {
    public Long id;
    public String nombre;
    public String email;
    public LocalDate fechaRegistro;
    public int nivel;
    // Mappers
    public static UsuarioDTO fromModel(Usuario u) {
        UsuarioDTO d = new UsuarioDTO();
        d.id = u.getId(); d.nombre = u.getNombre(); d.email = u.getEmail();
        d.fechaRegistro = u.getFechaRegistro(); d.nivel = u.getNivel();
        return d;
    }
}
