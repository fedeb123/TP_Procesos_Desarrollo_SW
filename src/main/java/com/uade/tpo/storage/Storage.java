package com.uade.tpo.storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.Zona;

public class Storage {
    private ArrayList<Partido> partidos;
    private ArrayList<Usuario> usuarios;
    private static Storage instance;

    public static Storage getInstance() {
        if (instance == null){
            instance = new Storage();
        }
        return instance;
    }

    public Storage() {
        super();
    }

    public ArrayList<Partido> buscarPartidos(Zona zona, Enums.TipoDeporte tipoDeporte) {
        return new ArrayList<>(this.partidos.stream().filter(p -> p.getUbicacion().equals(zona) && p.getTipoDeporte() == tipoDeporte && Objects.equals(p.getEstado().toString(), Enums.TipoEstadoPartido.NECESITA_JUGADORES.toString())).toList());
    }

    public Partido buscarPartido(String direccion, Date fecha){
        return this.partidos.stream().filter(p -> p.getDireccion().equals(direccion) && p.getHorario().equals(fecha)).findFirst().orElse(null);
    }

    public Usuario buscarUsuario(String dni){
        return this.usuarios.stream().filter(u -> u.getDni().contains(dni)).findFirst().orElse(null);
    }

    public ArrayList<Usuario> buscarUsuariosCoincidentes(Zona ubicacion, Enums.TipoDeporte deporte){
        return new ArrayList<>(this.usuarios.stream().filter(u -> u.getUbicacion().equals(ubicacion) && u.getDeporteFav().equals(deporte)).toList());
    }

    public void guardarPartido(Partido partido){
        partidos.add(partido);
    }

    public void guardarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public ArrayList<Partido> getPartidos(){
        return this.partidos;
    }

    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }

}
