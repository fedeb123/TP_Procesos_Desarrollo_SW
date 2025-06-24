package com.uade.tpo.Services;

import com.uade.tpo.Models.DTO.UsuarioDTO;
import com.uade.tpo.Models.Usuario;

import java.util.ArrayList;
import java.util.List;

public interface IUsuarioService {
    ArrayList<Usuario> getUsuarios();
    Usuario crearUsuario(UsuarioDTO usuario);
}
