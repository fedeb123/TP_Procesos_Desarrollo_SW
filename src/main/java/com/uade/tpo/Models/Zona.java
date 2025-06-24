package com.uade.tpo.models;

public class Zona {
    private String provincia;
    private String municipio;

    public Zona(String provincia, String municipio) {
        this.provincia = provincia;
        this.municipio = municipio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}

