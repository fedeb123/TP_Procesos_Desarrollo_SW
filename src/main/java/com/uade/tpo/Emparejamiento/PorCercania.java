package com.uade.tpo.Emparejamiento;


import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;

public class PorCercania implements IEmparejamiento {

    @Override
    public boolean puedeUnirse(Usuario usuario, Partido partido) {
        Zona zonaUsuario = usuario.getUbicacion();
        Zona zonaPartido = partido.getUbicacion();

        return zonaUsuario.getProvincia().equalsIgnoreCase(zonaPartido.getProvincia())
                && zonaUsuario.getMunicipio().equalsIgnoreCase(zonaPartido.getMunicipio());
    }
}
