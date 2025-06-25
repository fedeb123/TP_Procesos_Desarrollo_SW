package com.uade.tpo.repositories;

import java.util.ArrayList;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Zona;

public class UsuarioRepository {
    private static UsuarioRepository instance;
    private final ArrayList<Usuario> usuarios;

    public static UsuarioRepository getInstance() {
        if (instance == null){
            instance = new UsuarioRepository();
        }
        return instance;
    }

    private UsuarioRepository() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario buscarUsuario(String dni){
        return this.usuarios.stream().filter(u -> u.getDni().contains(dni)).findFirst().orElse(null);
    }

    public ArrayList<Usuario> buscarUsuariosCoincidentes(Zona ubicacion, Enums.TipoDeporte deporte){
        return new ArrayList<>(this.usuarios.stream().filter(u -> u.getUbicacion().equals(ubicacion) && u.getDeporteFav().equals(deporte)).toList());
    }

    public void guardarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }   
    
}
