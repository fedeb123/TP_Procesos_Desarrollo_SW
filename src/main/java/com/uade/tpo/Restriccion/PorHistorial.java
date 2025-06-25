package com.uade.tpo.Restriccion;
import com.uade.tpo.Models.Usuario;
public class PorHistorial implements IRestriccion {
    private final int minVictorias;
    public PorHistorial(int minVictorias) { this.minVictorias = minVictorias; }
    @Override
    public boolean aplica(Usuario usuario) {
        return usuario.getHistorialVictorias() >= minVictorias;
    }
}
