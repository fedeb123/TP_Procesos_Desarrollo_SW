package com.uade.tpo.Services;

import com.uade.tpo.Models.DTO.PartidoDTO;
import com.uade.tpo.Models.DTO.UsuarioDTO;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;

import java.util.ArrayList;
import java.util.List;

public interface IPartidoService {
    void crearPartido(PartidoDTO partido);
    void agregarJugador(Partido partido, Usuario usuario);
    List<Partido> buscarPartidos(Zona zona, Enums.TipoDeporte tipoDeporte);
}
