package com.uade.tpo.services;

import com.uade.tpo.services.interfaces.IUsuarioService;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.UsuarioDTO;

public class UsuarioService implements IUsuarioService {
    
    private static UsuarioService instance;

    public static UsuarioService getInstance(){
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    @Override
    public Usuario crearUsuario(UsuarioDTO usuario) {
        // Validar cosas aca, me da fiaca ahora

        Usuario nuevoUsuario = new Usuario(usuario.getNombre(), usuario.getApellido(), usuario.getSexo(), usuario.getDni(), usuario.getCorreo(), usuario.getContraseña(), usuario.getDeporteFavorito(), usuario.getNivelJuego(), usuario.getUbicacion());
        
        System.out.println("Usuario creado");
        
        return nuevoUsuario;
    }    


    
}
