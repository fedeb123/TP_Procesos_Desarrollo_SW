package com.uade.tpo.emparejamiento;

import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;

public interface IEmparejamiento {
    boolean puedeUnirse(Usuario usuario, Partido partido);
}
