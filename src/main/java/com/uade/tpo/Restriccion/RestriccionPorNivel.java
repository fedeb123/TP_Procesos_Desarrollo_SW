package com.uade.tpo.Restriccion;

public class RestriccionPorNivel implements IRestriccion {
    private Enums.TipoNivelDeJuego nivelRequerido;

    public RestriccionPorNivel(Enums.TipoNivelDeJuego nivelRequerido) {
        this.nivelRequerido = nivelRequerido;
    }

    public Enums.TipoNivelDeJuego getNivelRequerido() {
        return nivelRequerido;
    }

    public void setNivelRequerido(Enums.TipoNivelDeJuego nivelRequerido) {
        this.nivelRequerido = nivelRequerido;
    }

    @Override
    public boolean cumple() {
        return false;
    }

}