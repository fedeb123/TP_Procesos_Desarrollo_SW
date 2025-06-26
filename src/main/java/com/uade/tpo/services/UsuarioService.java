package com.uade.tpo.services;

import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.repositories.UsuarioRepository;

public class UsuarioService {

    private static UsuarioService instance;

    private UsuarioService() {}

    public static UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        Zona zona = new Zona(
            usuarioDTO.getUbicacion().getProvincia(),
            usuarioDTO.getUbicacion().getMunicipio()
        );

        Usuario usuario = new Usuario(
            usuarioDTO.getNombre(),
            usuarioDTO.getApellido(),
            usuarioDTO.getSexo(),
            usuarioDTO.getDni(),
            usuarioDTO.getCorreo(),
            usuarioDTO.getContraseña(),
            usuarioDTO.getDeporteFavorito(),
            usuarioDTO.getNivelJuego(),
            zona
        );

        UsuarioRepository.getInstance().guardarUsuario(usuario);

        return usuario;
    }
}

