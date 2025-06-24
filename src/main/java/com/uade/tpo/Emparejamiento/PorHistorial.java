package com.uade.tpo.Emparejamiento;

import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Services.IPartidoService;
import com.uade.tpo.Services.IUsuarioService;

import java.util.List;

public class PorHistorial implements IEmparejamiento {

    private final IPartidoService partidoService;

    public PorHistorial(IPartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @Override
    public boolean puedeUnirse(Usuario usuario, Partido partido) {
        Usuario organizador = partido.getOrganizadorPartido();

        var historial = this.partidoService.getHistorial(usuario);

        return historial.stream()
                .anyMatch(p -> p.getOrganizadorPartido().equals(organizador));
    }
}
