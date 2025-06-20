package com.uade.tpo.storage;

import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;

import java.util.ArrayList;
import java.util.List;

public interface IStorage {
    public void crearUsuario(Usuario usuario);

    public ArrayList<Usuario> getUsuarios();

    public void guardarPartido(Partido partido);

    public List<Partido> buscarPartidos(Zona zona, Enums.TipoDeporte tipoDeporte);
}
