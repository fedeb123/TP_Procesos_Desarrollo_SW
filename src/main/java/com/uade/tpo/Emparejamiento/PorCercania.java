package com.uade.tpo.emparejamiento;


import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Zona;

public class PorCercania implements IEmparejamiento {

    @Override
    public boolean puedeUnirse(Usuario usuario, Partido partido) {
        Zona zonaUsuario = usuario.getUbicacion();
        Zona zonaPartido = partido.getUbicacion();

        return zonaUsuario.getProvincia().equalsIgnoreCase(zonaPartido.getProvincia())
                && zonaUsuario.getMunicipio().equalsIgnoreCase(zonaPartido.getMunicipio());
    }
}
