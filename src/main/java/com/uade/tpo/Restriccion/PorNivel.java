package com.uade.tpo.Restriccion;
import com.uade.tpo.Models.Usuario;
public class PorNivel implements IRestriccion {
    private final int nivelMin;
    public PorNivel(int nivelMin) { this.nivelMin = nivelMin; }
    @Override
    public boolean aplica(Usuario usuario) {
        return usuario.getNivel() >= nivelMin;
    }
}