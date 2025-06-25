package com.uade.tpo.controllers;

import java.util.ArrayList;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.repositories.UsuarioRepository;
import com.uade.tpo.services.UsuarioService;

public class UsuarioController {

    private static UsuarioController instance;
    private final UsuarioService usuarioService;

    private UsuarioController() {
        this.usuarioService = UsuarioService.getInstance();
    }

    public static UsuarioController getInstance() {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }        

    public void crearUsuario(UsuarioDTO usuario) {
        Usuario nuevoUsuario = this.usuarioService.crearUsuario(usuario);
    }

    public UsuarioDTO buscarUsuario(String dni){
        Usuario usuarioEncontrado = UsuarioRepository.getInstance().buscarUsuario(dni);
        return usuarioEncontrado.toDTO();
    }

    public ArrayList<UsuarioDTO> buscarUsuariosCoincidentesEnDeporte(Enums.TipoDeporte deporte){
        ArrayList<Usuario> usuariosCoincidentes = UsuarioRepository.getInstance().buscarUsuariosCoincidentesEnDeporte(deporte);
        ArrayList<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuario usuario : usuariosCoincidentes){
            usuariosDTO.add(usuario.toDTO());
        }

        return usuariosDTO;
    }
     
}


