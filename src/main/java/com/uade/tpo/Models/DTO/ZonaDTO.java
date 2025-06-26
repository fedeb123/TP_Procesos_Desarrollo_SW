package com.uade.tpo.models.dto;

public class ZonaDTO {
    private final String provincia;
    private final String municipio;

    public ZonaDTO(String provincia, String municipio) {
        this.provincia = provincia;
        this.municipio = municipio;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getMunicipio() {
        return municipio;
    }
}

