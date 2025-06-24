package com.uade.tpo.controllers;

import com.uade.tpo.Models.DTO.UsuarioDTO;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Services.IUsuarioService;
import com.uade.tpo.Services.UsuarioService;

public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void registrarUsuario(UsuarioDTO usuario) {
        usuarioService.crearUsuario(usuario);
        System.out.println("Usuario creado");
    }
}

