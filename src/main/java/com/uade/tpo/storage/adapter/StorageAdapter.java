package com.uade.tpo.storage.adapter;

import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.storage.IStorage;

import java.util.List;
import java.util.ArrayList;

public class StorageAdapter implements IStorage {
    private final FakeSQL sql ;
    
    public StorageAdapter(FakeSQL sql) {
        this.sql = sql;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        this.sql.execute("");
    }

    @Override
    public void guardarPartido(Partido partido) {
        this.sql.execute("");
    }

    public ArrayList<Usuario> getUsuarios(){
        return new ArrayList();
    }


    //@Override
    public List<Partido> buscarPartido(Zona zona, Enums.TipoDeporte tipoDeporte) {
        return new ArrayList<>();
    }
}
