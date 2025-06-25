package com.uade.tpo.controllers;

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

    public List<Partido> buscarPartidos(Zona zona, Enums.TipoDeporte tipoDeporte) {
        return this.partidos.stream().filter(p -> p.getUbicacion().equals(zona) && p.getTipoDeporte() == tipoDeporte && Objects.equals(p.getEstado().toString(), Enums.TipoEstadoPartido.NECESITA_JUGADORES.toString())).toList();
    }

    public Partido buscarPartido(String direccion, Date fecha){
        return this.partidos.stream().filter(p -> p.getDireccion().equals(direccion) && p.getHorario().equals(fecha)).findFirst().orElse(null);
    }

    public void crearPartido(PartidoDTO partido) {

        // validar cosas aca, me da fiaca

        // hacer clase estatica que devuelva esta info
        int cantidadJugadoresRequerida = 0;
        float duracionEncuentro = 0;

        // buscar si existe el organizador del partido
        // devolver el modelo si existe, sino fallar
        // crear el nuevo partido

        var usuarioCreador = UsuarioController.getInstance().buscarUsuario(partido.getOrganizadorPartido().getDni());

        //validar si el usuario no existe

        var nuevoPartido = new Partido(partido.getTipoDeporte(), partido.getUbicacion(), partido.getHorario(), partido.getDireccion(), usuarioCreador,partido.getRestricciones(), partido.getMetodoEmparejamiento(), partido.getCantidadJugadoresRequerida(), partido.getDuracionEncuentro(), partido.getMaximoNivel());

        nuevoPartido.setCantidadJugadoresRequerida(cantidadJugadoresRequerida);
        nuevoPartido.setDuracionEncuentro(duracionEncuentro);

        var usuarios = UsuarioController.getInstance().getUsuarios();

        this.partidos.add(nuevoPartido);
    }

    public void agregarJugador(PartidoDTO partido, UsuarioDTO usuario) {
        Partido partidoEncontrado = this.buscarPartido(partido.getDireccion(), partido.getHorario());
        Usuario usuarioEncontrado = UsuarioController.getInstance().buscarUsuario(usuario.getDni());

        //poner validaciones si el partido o el usuario son null

        partidoEncontrado.agregarJugador(usuarioEncontrado);

        if (Objects.equals(partidoEncontrado.getEstado().toString(), Enums.TipoEstadoPartido.PARTIDO_ARMADO.toString())) {
            partidoEncontrado.notificar("Partido armado");
        }
    }

    public List<Partido> getHistorial(Usuario usuario){
        return this.partidos.stream().filter(p -> p.getJugadores().contains(usuario)).toList();
    }
}

