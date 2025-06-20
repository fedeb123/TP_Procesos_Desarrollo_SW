package com.uade.tpo.controllers;

import com.uade.tpo.Models.DTO.PartidoDTO;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.Services.IPartidoService;

import java.util.List;

public class PartidoController {

    private final IPartidoService partidoService;

    public PartidoController(IPartidoService partidoService) {
        this.partidoService = partidoService;
    }

    public void crearPartido(PartidoDTO partido) {
        partidoService.crearPartido(partido);
        System.out.println("Partido creado");
    }

    public void agregarJugador(Partido partido, Usuario usuario) {
        partidoService.agregarJugador(partido, usuario);
    }

   public List<Partido> buscarPartidosIncompletos(Zona zona, Enums.TipoDeporte tipoDeporte){
        return partidoService.buscarPartidos(zona,tipoDeporte);
   }
}
