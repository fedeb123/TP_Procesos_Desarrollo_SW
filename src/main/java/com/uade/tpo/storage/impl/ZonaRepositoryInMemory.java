package com.uade.tpo.storage.impl;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.storage.IZonaRepository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ZonaRepositoryInMemory implements IZonaRepository {
    private final Map<Long, Zona> storage = new ConcurrentHashMap<>();
    public ZonaRepositoryInMemory() {
        // Preload zonas if needed
    }
    @Override
    public Optional<Zona> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }
}