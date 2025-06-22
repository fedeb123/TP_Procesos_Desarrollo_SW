package com.uade.tpo.EstadoPartido;

import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Services.INotificacionService;

public interface IEstadoPartido {
    void iniciarPartido(Partido partido);

    void agregarJugador(Partido partido, Usuario usuario);

    void finalizar(Partido partido);


    void cancelar(Partido partido);
}
