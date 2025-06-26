package com.uade.tpo.models;

import java.util.Objects;

import com.uade.tpo.models.dto.ZonaDTO;

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

    public ZonaDTO toDTO() {
        return new ZonaDTO(this.provincia, this.municipio);
    }

    public static Zona fromDTO(ZonaDTO dto) {
        return new Zona(dto.getProvincia(), dto.getMunicipio());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zona)) return false;
        Zona zona = (Zona) o;
        return provincia.equalsIgnoreCase(zona.provincia) &&
               municipio.equalsIgnoreCase(zona.municipio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provincia.toLowerCase(), municipio.toLowerCase());
    }
}
