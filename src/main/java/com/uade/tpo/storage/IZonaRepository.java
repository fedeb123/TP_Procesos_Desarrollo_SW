package com.uade.tpo.storage;
import com.uade.tpo.Models.Zona;
import java.util.Optional;
public interface IZonaRepository {
    Optional<Zona> findById(Long id);
}
