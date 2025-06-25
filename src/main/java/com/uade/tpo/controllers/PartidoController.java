package com.uade.tpo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;

public class PartidoController {

    private ArrayList<Partido> partidos;

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

    public List<Partido> buscarPartido(Zona zona, Enums.TipoDeporte tipoDeporte) {
        return this.partidos.stream().filter(p -> p.getUbicacion().equals(zona) && p.getTipoDeporte() == tipoDeporte && Objects.equals(p.getEstado().toString(), Enums.TipoEstadoPartido.NECESITA_JUGADORES.toString())).toList();
    }

    public void crearPartido(PartidoDTO partido) {

        UsuarioController usuarioController = UsuarioController.getInstance();

        // validar cosas aca, me da fiaca

        // hacer clase estatica que devuelva esta info
        int cantidadJugadoresRequerida = 0;
        float duracionEncuentro = 0;

        var nuevoPartido = new Partido(partido.getTipoDeporte(), partido.getUbicacion(), partido.getHorario(), partido.getDireccion(), partido.getOrganizadorPartido(), partido.getRestricciones(), partido.getMetodoEmparejamiento(), partido.getCantidadJugadoresRequerida(), partido.getDuracionEncuentro(), partido.getMaximoNivel());

        nuevoPartido.setCantidadJugadoresRequerida(cantidadJugadoresRequerida);
        nuevoPartido.setDuracionEncuentro(duracionEncuentro);

        var usuarios = usuarioController.getUsuarios();

        this.partidos.add(nuevoPartido);
    }

    public void agregarJugador(Partido partido, Usuario usuario) {
        partido.agregarJugador(usuario);

        if (Objects.equals(partido.getEstado().toString(), Enums.TipoEstadoPartido.PARTIDO_ARMADO.toString())) {
            partido.notificar("Partido armado");
        }
    }

    public List<Partido> getHistorial(Usuario usuario){
        return this.partidos.stream().filter(p -> p.getJugadores().contains(usuario)).toList();
    }
}

