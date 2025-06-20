package com.uade.tpo.Services;

import com.uade.tpo.Emparejamiento.IEmparejamiento;
import com.uade.tpo.EstadoPartido.IEstadoPartido;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.Restriccion.IRestriccion;
import com.uade.tpo.storage.IStorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartidoService {

    private final IStorage storage;
    private final INotificacionService notificacionService;

    public PartidoService(IStorage s, INotificacionService ns) {
        this.storage = s;
        this.notificacionService = ns;
    }

    public Partido crearPartido(Enums.TipoDeporte tipoDeporte, Zona ubicacion, Date horario,
                                String direccion, Usuario organizadorPartido,
                                ArrayList<IRestriccion> restricciones,
                                IEmparejamiento metodoEmparejamiento) {

        // hacer clase estatica que devuelva esta info
        int cantidadJugadoresRequerida = 0;
        float duracionEncuentro = 0;


        Partido partido = new Partido(tipoDeporte, ubicacion, horario, direccion, organizadorPartido, restricciones, metodoEmparejamiento,cantidadJugadoresRequerida, duracionEncuentro);

        storage.guardarPartido(partido);

        return partido;
    }
}
