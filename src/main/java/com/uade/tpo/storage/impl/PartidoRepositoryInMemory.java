package com.uade.tpo.storage.impl;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.storage.IPartidoRepository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PartidoRepositoryInMemory implements IPartidoRepository {
    private final Map<Long, Partido> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    @Override
    public Optional<Partido> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }
    @Override
    public void save(Partido partido) {
        if (partido.getId() == null) {
            Long newId = idGenerator.getAndIncrement();
            // create new Partido with generated ID, preserve others
            Partido p = new Partido(newId, partido.getZona(), partido.getEstado());
            p.getParticipantes().addAll(partido.getParticipantes());
            p.cambiarEstado(partido.getEstado());
            storage.put(newId, p);
        } else {
            storage.put(partido.getId(), partido);
        }
    }
}
