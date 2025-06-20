package com.uade.tpo.storage;

import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.storage.fake.FakeSQL;

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

    @Override
    public void buscarPartido(Zona zona, Enums.TipoDeporte tipoDeporte) {
        this.sql.execute("");
    }
}
