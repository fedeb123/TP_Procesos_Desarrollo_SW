package com.uade.tpo.factories;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.EstadoPartido.NecesitaJugadores;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;

public class PartidoFactory {
    public static Partido crearPartido(Enums.TipoDeporte deporte, Usuario usuario, Zona zona, IEmparejamiento estrategia) {
        Partido partido = new Partido();
        partido.setTipoDeporte(deporte);
        partido.setOrganizadorPartido(usuario);
        partido.setUbicacion(zona);
        partido.setMetodoEmparejamiento(estrategia);
        partido.setEstado(new NecesitaJugadores());
        return partido;
    }
}

