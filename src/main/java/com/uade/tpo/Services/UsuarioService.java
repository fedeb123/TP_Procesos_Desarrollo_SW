package com.uade.tpo.Services;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.Models.DTO.UsuarioDTO;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.Restriccion.IRestriccion;
import com.uade.tpo.storage.IStorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioService implements IUsuarioService {

    private final IStorage storage;

    public UsuarioService(IStorage s) {
        this.storage = s;
    }

    public Usuario crearUsuario(UsuarioDTO usuario) {
        // Validar cosas aca, me da fiaca ahora

        var nuevoUsuario = usuario.toUsuario();

        this.storage.crearUsuario(nuevoUsuario);

        System.out.println("Usuario creado");

        return nuevoUsuario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return storage.getUsuarios();
    }
}
