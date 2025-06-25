package com.uade.tpo.services.interfaces;

import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.UsuarioDTO;

public interface IUsuarioService {
    public Usuario crearUsuario(UsuarioDTO usuario);
}
