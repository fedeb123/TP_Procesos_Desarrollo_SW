package com.uade.tpo.storage.fake;

import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;

import java.util.*;

public class FakeSQL {
    private static final FakeSQL instance = new FakeSQL();

    private final Map<String, Usuario> usuarios = new HashMap<>();
    private final ArrayList<Partido> partidos = new ArrayList<>();

    private FakeSQL() {}

    public static FakeSQL getInstance() {
        return instance;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getCorreo(), usuario);
    }

    public Usuario buscarUsuario(String correo) {
        return usuarios.get(correo);
    }

    public ArrayList<Usuario> buscarUsuarios() {
        return new ArrayList<>(usuarios.values());
    }


    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    public List<Partido> buscarPartido(Zona zona, Enums.TipoDeporte tipoDeporte) {
        return partidos.stream()
                .filter(p -> p.getUbicacion().equals(zona) && p.getTipoDeporte() == tipoDeporte &&
                        Objects.equals(p.getEstado().toString(), Enums.TipoEstadoPartido.NECESITA_JUGADORES.toString()))
                .toList();
    }
}

