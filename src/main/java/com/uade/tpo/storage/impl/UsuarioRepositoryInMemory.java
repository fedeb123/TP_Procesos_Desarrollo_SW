package com.uade.tpo.storage.impl;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.storage.IUsuarioRepository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UsuarioRepositoryInMemory implements IUsuarioRepository {
    private final Map<Long, Usuario> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    @Override
    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }
    @Override
    public void save(Usuario usuario) {
        if (usuario.getId() == null) {
            Long newId = idGenerator.getAndIncrement();
            Usuario u = new Usuario(newId, usuario.getNombre(), usuario.getEmail(), usuario.getFechaRegistro(), usuario.getNivel());
            storage.put(newId, u);
        } else {
            storage.put(usuario.getId(), usuario);
        }
    }
}
