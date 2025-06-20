package com.uade.tpo.Services;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.EstadoPartido.Armado;
import com.uade.tpo.EstadoPartido.IEstadoPartido;
import com.uade.tpo.Models.DTO.PartidoDTO;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.Observer.Observer;
import com.uade.tpo.Restriccion.IRestriccion;
import com.uade.tpo.storage.IStorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PartidoService {

    private final IStorage storage;
    private final INotificacionService notificacionService;
    private final IUsuarioService usuarioService;

    public PartidoService(IStorage s, INotificacionService ns, IUsuarioService us) {
        this.storage = s;
        this.notificacionService = ns;
        this.usuarioService = us;
    }

    public Partido crearPartido(PartidoDTO partido) {
        // validar cosas aca, me da fiaca

        // hacer clase estatica que devuelva esta info
        int cantidadJugadoresRequerida = 0;
        float duracionEncuentro = 0;

        var nuevoPartido = partido.toPartido();

        nuevoPartido.setCantidadJugadoresRequerida(cantidadJugadoresRequerida);
        nuevoPartido.setDuracionEncuentro(duracionEncuentro);


        storage.guardarPartido(nuevoPartido);


        var usuarios = this.usuarioService.getUsuarios();

        List<Observer> notificarUsuarios = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getDeporteFav() == partido.getTipoDeporte()) {
                notificarUsuarios.add(u);
            }
        }

        this.notificacionService.notificarATodos(notificarUsuarios, "Se creo un partido de tu deporte favorito");

        return nuevoPartido;
    }

    public void agregarJugador(Partido partido, Usuario usuario) {
        partido.agregarJugador(usuario);

        if (Objects.equals(partido.getEstado().toString(), Enums.TipoEstadoPartido.PARTIDO_ARMADO.toString())) {
            partido.notificarObservadores("Partido armado");
        }
    }
}
