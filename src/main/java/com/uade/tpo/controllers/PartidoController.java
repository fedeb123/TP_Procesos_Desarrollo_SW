package com.uade.tpo.controllers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.services.PartidoService;
import com.uade.tpo.storage.Storage;

public class PartidoController {

    private static PartidoController instance; 

    public static PartidoController getInstance() {
        if (instance == null) {
            instance = new PartidoController();
        }
        return instance;
    }

    private PartidoController() {
        super();
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
        Partido partidoCreado = PartidoService.getInstance().crearPartido(partido);
    }

    public void agregarJugador(PartidoDTO partido, UsuarioDTO usuario) {
        PartidoService.getInstance().agregarJugador(partido, usuario);
        //validar si salio bien
    }

    public ArrayList<PartidoDTO> getHistorialPartidos(Usuario usuarioDTO){
        
        return this.partidos.stream().filter(p -> p.getJugadores().contains(usuario)).toList();
    }
}

