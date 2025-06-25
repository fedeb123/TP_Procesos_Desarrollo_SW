package com.uade.tpo.storage;
import com.uade.tpo.Models.Partido;
import java.util.Optional;
public interface IPartidoRepository {
    Optional<Partido> findById(Long id);
    void save(Partido partido);
}