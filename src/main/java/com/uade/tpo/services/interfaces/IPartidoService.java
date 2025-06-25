package com.uade.tpo.services.interfaces;

import com.uade.tpo.models.Partido;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;

public interface IPartidoService {

    public Partido crearPartido(PartidoDTO partido);
    public void agregarJugador(PartidoDTO partido, UsuarioDTO usuario);
    
}
