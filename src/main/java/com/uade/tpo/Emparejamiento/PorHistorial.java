package com.uade.tpo.emparejamiento;

import java.util.ArrayList;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.PartidoDTO;

public class PorHistorial implements IEmparejamiento {
    private final int cantidadMinima;

    public PorHistorial(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    @Override
    public boolean puedeUnirse(Usuario usuario, Partido partido) {
        Usuario organizador = partido.getOrganizadorPartido();

        ArrayList<PartidoDTO> historial = PartidoController.getInstance().getHistorialPartidos(usuario.toDTO());

        int cantidadPartidosJugados = (int) historial.stream().filter(p -> p.getOrganizadorPartido().equals(organizador.toDTO())).count();

        return cantidadMinima <= cantidadPartidosJugados;
    }
}
