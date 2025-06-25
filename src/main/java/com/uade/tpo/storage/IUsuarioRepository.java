package com.uade.tpo.storage;
import com.uade.tpo.Models.Usuario;
import java.util.Optional;
public interface IUsuarioRepository {
    Optional<Usuario> findById(Long id);
    void save(Usuario usuario);
}

