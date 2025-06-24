package com.uade.tpo.estadopartido;

import com.uade.tpo.models.Partido;
import com.uade.tpo.models.Usuario;

public interface IEstadoPartido {
    void iniciarPartido(Partido partido);

    void agregarJugador(Partido partido, Usuario usuario);

    void finalizar(Partido partido);


    void cancelar(Partido partido);
}
