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

public class UsuarioService {

    private final IStorage storage;
    private final INotificacionService notificacionService;

    public UsuarioService(IStorage s, INotificacionService ns) {
        this.storage = s;
        this.notificacionService = ns;
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
