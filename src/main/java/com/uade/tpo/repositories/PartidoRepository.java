package com.uade.tpo.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Zona;

public class PartidoRepository {

    private static PartidoRepository instance;
    private final ArrayList<Partido> partidos;

    public static PartidoRepository getInstance(){
        if (instance == null){
            instance = new PartidoRepository();
        }
        return instance;
    }

    private PartidoRepository(){
        this.partidos = new ArrayList<>();
    }

    public ArrayList<Partido> buscarPartidos(Zona zona, Enums.TipoDeporte tipoDeporte) {
        return new ArrayList<>(this.partidos.stream().filter(p -> p.getUbicacion().equals(zona) && p.getTipoDeporte() == tipoDeporte && Objects.equals(p.getEstado().toString(), Enums.TipoEstadoPartido.NECESITA_JUGADORES.toString())).toList());
    }

    public Partido buscarPartido(String direccion, Date fecha){
        return this.partidos.stream().filter(p -> p.getDireccion().equals(direccion) && p.getHorario().equals(fecha)).findFirst().orElse(null);
    }


    public void guardarPartido(Partido partido){
        partidos.add(partido);
    }

    public ArrayList<Partido> getPartidos(){
        return this.partidos;
    }
    
}
