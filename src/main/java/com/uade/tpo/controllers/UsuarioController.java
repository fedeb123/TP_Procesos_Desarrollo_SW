package com.uade.tpo.controllers;

import java.util.ArrayList;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.services.UsuarioService;
import com.uade.tpo.storage.Storage;

public class UsuarioController {

    private static UsuarioController instance;

    private UsuarioController() {
        super();
    }

    public static UsuarioController getInstance() {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }        

    public void crearUsuario(UsuarioDTO usuario) {
        Usuario nuevoUsuario = UsuarioService.getInstance().crearUsuario(usuario);
    }

    public UsuarioDTO buscarUsuario(String dni){
        Usuario usuarioEncontrado = Storage.getInstance().buscarUsuario(dni);
        return usuarioEncontrado.toDTO();
    }

    public ArrayList<UsuarioDTO> buscarUsuariosCoincidentes(Zona ubicacion, Enums.TipoDeporte deporte){
        ArrayList<Usuario> usuariosCoincidentes = Storage.getInstance().buscarUsuariosCoincidentes(ubicacion, deporte);
        ArrayList<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuario usuario : usuariosCoincidentes){
            usuariosDTO.add(usuario.toDTO());
        }

        return usuariosDTO;
    }
     
}


