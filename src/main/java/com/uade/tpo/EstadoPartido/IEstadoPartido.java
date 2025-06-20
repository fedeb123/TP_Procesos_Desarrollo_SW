package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Services.INotificacionService;

public interface IEstadoPartido {
    void iniciarPartido(Partido partido, INotificacionService notificacionService);

    void agregarJugador(Partido partido, Usuario usuario, INotificacionService notificacionService);

    void finalizar(Partido partido, INotificacionService notificacionService);

    void cancelar(Partido partido, INotificacionService notificacionService);
}
