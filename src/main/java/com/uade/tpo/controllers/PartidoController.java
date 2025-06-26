package com.uade.tpo.controllers;

import java.util.ArrayList;
import java.util.Date;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.dto.ZonaDTO;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.models.dto.ComentarioDTO;
import com.uade.tpo.repositories.PartidoRepository;
import com.uade.tpo.services.PartidoService;

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

    public ArrayList<PartidoDTO> buscarPartidos(ZonaDTO zona, Enums.TipoDeporte tipoDeporte) {
        Zona zonaModel = new Zona(zona.getProvincia(), zona.getMunicipio());
        ArrayList<Partido> partidosCoincidentes = PartidoRepository.getInstance().buscarPartidos(zonaModel, tipoDeporte);
        ArrayList<PartidoDTO> partidosDTO = new ArrayList<>();
        
        for (Partido partido : partidosCoincidentes){
            partidosDTO.add(partido.toDTO());
        }

        return partidosDTO;
    }

    public PartidoDTO buscarPartido(String direccion, Date fecha){
        Partido partidoCoincidente = PartidoRepository.getInstance().buscarPartido(direccion, fecha);
        return partidoCoincidente.toDTO();
    }

    public void crearPartido(PartidoDTO partido){        
        Partido partidoCreado = this.partidoService.crearPartido(partido);
    }

    public void agregarJugador(PartidoDTO partido, UsuarioDTO usuario) {
        this.partidoService.agregarJugador(partido, usuario);
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

    public void confirmarPartipacion(PartidoDTO partido, UsuarioDTO usuario){
        this.partidoService.confirmarPartido(partido, usuario);
    }

    public void comentarPartido(ComentarioDTO comentario, PartidoDTO partido){
        this.partidoService.comentarPartido(comentario, partido);
    }

    public ArrayList<PartidoDTO> getAllPartidos(){
        ArrayList<Partido> partidos = PartidoRepository.getInstance().getPartidos();
        ArrayList<PartidoDTO> partidosDTO = new ArrayList<>();
        for (Partido partido : partidos){
            partidosDTO.add(partido.toDTO());
        }
        return partidosDTO;
    }
}

