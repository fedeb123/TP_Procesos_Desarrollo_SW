package com.uade.tpo.services;

import java.util.Objects;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.controllers.UsuarioController;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.services.interfaces.IPartidoService;

public class PartidoService implements IPartidoService {

    private static PartidoService instance;

    public static PartidoService getInstance(){
        if (instance == null) {
            instance = new PartidoService();
        }
        return instance;
    }

    @Override
    public Partido crearPartido(PartidoDTO partido) {

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

        return nuevoPartido;

    }

    @Override
    public void agregarJugador(PartidoDTO partido, UsuarioDTO usuario) {
        Partido partidoEncontrado = PartidoController.getInstance().buscarPartido(partido.getDireccion(), partido.getHorario());
        Usuario usuarioEncontrado = UsuarioController.getInstance().buscarUsuario(usuario.getDni());

        //poner validaciones si el partido o el usuario son null

        partidoEncontrado.agregarJugador(usuarioEncontrado);

        if (Objects.equals(partidoEncontrado.getEstado().toString(), Enums.TipoEstadoPartido.PARTIDO_ARMADO.toString())) {
            partidoEncontrado.notificar("Partido armado");
        }
    }        
}
