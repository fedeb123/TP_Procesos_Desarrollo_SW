package com.uade.tpo.Restriccion;

public class RestriccionPorCercania implements IRestriccion {
    private int radioKm;

    public RestriccionPorCercania(int radioKm) {
        this.radioKm = radioKm;
    }

    public int getRadioKm() {
        return radioKm;
    }

    public void setRadioKm(int radioKm) {
        this.radioKm = radioKm;
    }

    @Override
    public boolean cumple() {
        return false;
    }
}
