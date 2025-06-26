package com.uade.tpo.services;

import java.util.ArrayList;

import com.uade.tpo.estadopartido.NecesitaJugadores;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.models.dto.ComentarioDTO;
import com.uade.tpo.models.Comentario;
import com.uade.tpo.repositories.PartidoRepository;
import com.uade.tpo.repositories.UsuarioRepository;
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

        var usuarioCreador = UsuarioRepository.getInstance().buscarUsuario(partido.getOrganizadorPartido().getDni());
        //validar si el usuario no existe

        var nuevoPartido = new Partido(partido.getTipoDeporte(), usuarioCreador.getUbicacion(), partido.getHorario(), partido.getDireccion(), usuarioCreador, partido.getMetodoEmparejamiento(), partido.getCantidadJugadoresRequerida(), partido.getDuracionEncuentro(), partido.getMinimoNivel());
        nuevoPartido.setEstado(new NecesitaJugadores()); 

        nuevoPartido.setCantidadJugadoresRequerida(partido.getCantidadJugadoresRequerida());
        nuevoPartido.setDuracionEncuentro(partido.getDuracionEncuentro());

        ArrayList<Usuario> usuariosANotificar = UsuarioRepository.getInstance().buscarUsuariosCoincidentesEnDeporte(partido.getTipoDeporte());
        usuariosANotificar.remove(usuarioCreador);

        nuevoPartido.agregarObservador(usuarioCreador);

        for (Usuario usuario : usuariosANotificar){
            usuario.update("Se creo un nuevo partido de: " + nuevoPartido.getTipoDeporte().toString() + " en tu zona: " + nuevoPartido.getUbicacion().getProvincia() + " , " + nuevoPartido.getUbicacion().getMunicipio()); 
        }

        usuarioCreador.update("Partido Creado con Exito!");

        nuevoPartido.getJugadoresConfirmados().add(usuarioCreador);

        PartidoRepository.getInstance().guardarPartido(nuevoPartido);

        return nuevoPartido;
    }

    @Override
    public void agregarJugador(PartidoDTO partido, UsuarioDTO usuario) {
        Partido partidoEncontrado = PartidoRepository.getInstance().buscarPartido(partido.getDireccion(), partido.getHorario());
        Usuario usuarioEncontrado = UsuarioRepository.getInstance().buscarUsuario(usuario.getDni());

        partidoEncontrado.agregarJugador(usuarioEncontrado);
    }
    
    public ArrayList<Partido> getHistorialPartidos(UsuarioDTO usuario){
        ArrayList<Partido> partidos = PartidoRepository.getInstance().getPartidos(); 

        var usuarioEncontrado = UsuarioRepository.getInstance().buscarUsuario(usuario.getDni());

        partidos.stream().filter(p -> p.getJugadores().contains(usuarioEncontrado));

        return partidos;
    }

    public void confirmarPartido(PartidoDTO partido, UsuarioDTO usuario){
        var partidoEncontrado = PartidoRepository.getInstance().buscarPartido(partido.getDireccion(), partido.getHorario());
        var usuarioEncontrado = UsuarioRepository.getInstance().buscarUsuario(usuario.getDni());

        partidoEncontrado.confirmarJugador(usuarioEncontrado);
    }

    public void comentarPartido(ComentarioDTO comentario, PartidoDTO partido){
        var partidoEncontrado = PartidoRepository.getInstance().buscarPartido(partido.getDireccion(), partido.getHorario());
        var usuarioEncontrado = UsuarioRepository.getInstance().buscarUsuario(comentario.getAutor().getDni());

        Comentario comentarioModel = new Comentario (comentario.getComentario(), usuarioEncontrado);

        partidoEncontrado.comentarPartido(comentarioModel); 
    }
}
