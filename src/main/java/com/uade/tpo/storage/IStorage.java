package com.uade.tpo.storage;

import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;

public interface IStorage {
    public void crearUsuario(Usuario usuario);

    public void guardarPartido(Partido partido);

    public void buscarPartido(Zona zona, Enums.TipoDeporte tipoDeporte);
}
