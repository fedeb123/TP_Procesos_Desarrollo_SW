package com.uade.tpo.emparejamiento;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;

public class PorHistorial implements IEmparejamiento {

    PartidoController partidoController = PartidoController.getInstance();

    public PorHistorial() {
        // logica de emparejamiento por historial
    }

    @Override
    public boolean puedeUnirse(Usuario usuario, Partido partido) {
        Usuario organizador = partido.getOrganizadorPartido();

        var historial = this.partidoController.getHistorial(usuario);

        return historial.stream().anyMatch(p -> p.getOrganizadorPartido().equals(organizador));
    }
}
