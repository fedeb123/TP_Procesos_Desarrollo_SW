package com.uade.tpo.Emparejamiento;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;

public class PorNivelMaximo implements IEmparejamiento {

    @Override
    public boolean puedeUnirse(Usuario usuario, Partido partido) {
        return usuario.getNivelJuego().ordinal() <= partido.getMaximoNivel().ordinal();
    }
}
