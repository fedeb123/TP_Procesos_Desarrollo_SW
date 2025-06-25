package com.uade.tpo.controllers;

import java.util.ArrayList;
import java.util.Date;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.services.PartidoService;
import com.uade.tpo.storage.Storage;

public class PartidoController {

    private static PartidoController instance;
    private final PartidoService partidoService; 

    public static PartidoController getInstance() {
        if (instance == null) {
            instance = new PartidoController();
        }
        return instance;
    }

    private PartidoController() {
        this.partidoService = PartidoService.getInstance();
    }

    //public List<Partido> buscarPartidosIncompletos(Zona zona, Enums.TipoDeporte tipoDeporte);

    public ArrayList<PartidoDTO> buscarPartidos(Zona zona, Enums.TipoDeporte tipoDeporte) {
        ArrayList<Partido> partidosCoincidentes = Storage.getInstance().buscarPartidos(zona, tipoDeporte);
        ArrayList<PartidoDTO> partidosDTO = new ArrayList<>();
        
        for (Partido partido : partidosCoincidentes){
            partidosDTO.add(partido.toDTO());
        }

        return partidosDTO;
    }

    public PartidoDTO buscarPartido(String direccion, Date fecha){
        Partido partidoCoincidente = Storage.getInstance().buscarPartido(direccion, fecha);
        return partidoCoincidente.toDTO();
    }

    public void crearPartido(PartidoDTO partido){        
        Partido partidoCreado = this.partidoService.crearPartido(partido);
    }

    public void agregarJugador(PartidoDTO partido, UsuarioDTO usuario) {
        PartidoService.getInstance().agregarJugador(partido, usuario);
        //validar si salio bien
    }

    public ArrayList<PartidoDTO> getHistorialPartidos(UsuarioDTO usuarioDTO){
        ArrayList<Partido> partidos = this.partidoService.getHistorialPartidos(usuarioDTO);
        ArrayList<PartidoDTO> partidosDTO = new ArrayList<>();
        for (Partido partido : partidos){
            partidosDTO.add(partido.toDTO());
        }        
        return partidosDTO;
    }
}

