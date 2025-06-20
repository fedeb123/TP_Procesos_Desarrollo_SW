package com.uade.tpo.Restriccion;

import com.uade.tpo.Models.Enums;


public class PorNivel implements IRestriccion {
    private Enums.TipoNivelDeJuego nivelRequerido;

    public PorNivel(Enums.TipoNivelDeJuego nivelRequerido) {
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