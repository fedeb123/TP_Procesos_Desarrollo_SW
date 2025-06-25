package com.uade.tpo.emparejamiento;

import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;

public class PorNivelMinimo implements IEmparejamiento {

    @Override
    public boolean puedeUnirse(Usuario usuario, Partido partido) {
        return usuario.getNivelJuego().ordinal() >= partido.getMinimoNivel().ordinal();
    }
}
