package com.uade.tpo.Restriccion;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
public class PorCercania implements IRestriccion {
    private final Zona zona;
    private final double distanciaMax;
    public PorCercania(Zona zona, double distanciaMax) {
        this.zona = zona;
        this.distanciaMax = distanciaMax;
    }
    @Override
    public boolean aplica(Usuario usuario) {
        double latU = usuario.getUbicacion().getLatitud();
        double lonU = usuario.getUbicacion().getLongitud();
        double latZ = zona.getCentro().getLatitud();
        double lonZ = zona.getCentro().getLongitud();
        double dist = Math.hypot(latU - latZ, lonU - lonZ);
        return dist <= distanciaMax;
    }
}
