package com.uade.tpo.controllers;

import java.util.ArrayList;

import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.UsuarioDTO;

public class UsuarioController {

    private final ArrayList<Usuario> usuarios;

    private static UsuarioController instance;

    private UsuarioController() {
        this.usuarios = new ArrayList<>();
    }

    public static UsuarioController getInstance() {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }        

    public Usuario crearUsuario(UsuarioDTO usuario) {
        // Validar cosas aca, me da fiaca ahora

        var nuevoUsuario = usuario.toUsuario();

        System.out.println("Usuario creado");

        usuarios.add(nuevoUsuario);

        return nuevoUsuario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(String dni){
        return this.usuarios.stream().filter(u -> u.getDni().contains(dni)).findFirst().orElse(null);
    }
}


