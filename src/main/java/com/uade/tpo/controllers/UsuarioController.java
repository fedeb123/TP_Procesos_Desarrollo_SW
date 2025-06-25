package com.uade.tpo.controllers;

import java.util.ArrayList;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.services.UsuarioService;

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

    public void crearUsuario(UsuarioDTO usuario) {
        Usuario nuevoUsuario = UsuarioService.getInstance().crearUsuario(usuario);
        usuarios.add(nuevoUsuario);
    }

    protected ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    protected Usuario buscarUsuario(String dni){
        return this.usuarios.stream().filter(u -> u.getDni().contains(dni)).findFirst().orElse(null);
    }

    protected ArrayList<Usuario> buscarUsuariosCoincidentes(Zona ubicacion, Enums.TipoDeporte deporte){
        return new ArrayList<>(this.usuarios.stream().filter(u -> u.getUbicacion().equals(ubicacion) && u.getDeporteFav().equals(deporte)).toList());
    }
     
}


