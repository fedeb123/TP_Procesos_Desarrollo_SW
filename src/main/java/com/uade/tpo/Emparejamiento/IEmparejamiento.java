package com.uade.tpo.Emparejamiento;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;

public interface IEmparejamiento {
    boolean puedeUnirse(Usuario usuario, Partido partido);
}
