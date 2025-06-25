package com.uade.tpo.services;

import java.util.ArrayList;
import java.util.Objects;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.services.interfaces.IPartidoService;
import com.uade.tpo.storage.Storage;

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

        var usuarioCreador = Storage.getInstance().buscarUsuario(partido.getOrganizadorPartido().getDni());

        //validar si el usuario no existe

        var nuevoPartido = new Partido(partido.getTipoDeporte(), partido.getUbicacion(), partido.getHorario(), partido.getDireccion(), usuarioCreador,partido.getRestricciones(), partido.getMetodoEmparejamiento(), partido.getCantidadJugadoresRequerida(), partido.getDuracionEncuentro(), partido.getMaximoNivel());

        nuevoPartido.setCantidadJugadoresRequerida(cantidadJugadoresRequerida);
        nuevoPartido.setDuracionEncuentro(duracionEncuentro);

        ArrayList<Usuario> usuariosANotificar = Storage.getInstance().buscarUsuariosCoincidentes(partido.getUbicacion(), partido.getTipoDeporte());
        usuariosANotificar.remove(usuarioCreador);

        nuevoPartido.agregarObservador(usuarioCreador);

        for (Usuario usuario : usuariosANotificar){
            usuario.update("Se creo un nuevo partido de: " + nuevoPartido.getTipoDeporte().toString() + "en tu zona: " + nuevoPartido.getUbicacion().toString()); 
        }

        usuarioCreador.update("Partido Creado con Exito!");

        Storage.getInstance().guardarPartido(nuevoPartido);

        return nuevoPartido;
    }

    @Override
    public void agregarJugador(PartidoDTO partido, UsuarioDTO usuario) {
        Partido partidoEncontrado = Storage.getInstance().buscarPartido(partido.getDireccion(), partido.getHorario());
        Usuario usuarioEncontrado = Storage.getInstance().buscarUsuario(usuario.getDni());

        //poner validaciones si el partido o el usuario son null

        partidoEncontrado.agregarJugador(usuarioEncontrado);

        if (Objects.equals(partidoEncontrado.getEstado().toString(), Enums.TipoEstadoPartido.PARTIDO_ARMADO.toString())) {
            partidoEncontrado.notificar("Partido armado");
        }
    }
    
    public ArrayList<PartidoDTO> getHistorialPartidos(UsuarioDTO usuario){
        ArrayList<Partido> partidos = Storage.getInstance().getPartidos(); 

        var usuarioEncontrado = Storage.getInstance().buscarUsuario(usuario.getDni());

        //validar si el usuario existe

        partidos.stream().filter(p -> p.getJugadores().contains(usuarioEncontrado));

        ArrayList<PartidoDTO> partidosDTO = new ArrayList<>();
        for (Partido partido : partidos){
            partidosDTO.add(partido.toDTO());
        }

        return partidosDTO;
    }
}
