package com.uade.tpo.storage;

import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.storage.fake.FakeSQL;

import java.util.ArrayList;
import java.util.List;

public class StorageAdapter implements IStorage {
    private final FakeSQL sql ;

    public StorageAdapter(FakeSQL sql) {
        this.sql = sql;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        this.sql.agregarUsuario(usuario);
    }

    @Override
    public void guardarPartido(Partido partido) {
        this.sql.agregarPartido(partido);
    }

    @Override
    public List<Partido> buscarPartidos(Zona zona, Enums.TipoDeporte tipoDeporte) {
       return this.sql.buscarPartidos(zona, tipoDeporte);
    }

    @Override
    public ArrayList<Usuario> getUsuarios(){
        return this.sql.buscarUsuarios();
    }
}
