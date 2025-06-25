package com.uade.tpo.Services.impl;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.storage.IUsuarioRepository;
import com.uade.tpo.Services.IUsuarioService;
import java.time.LocalDate;
import java.util.Optional;

public class UsuarioService implements IUsuarioService {
    private final IUsuarioRepository repo;
    private static final int NIVEL_MAXIMO = 100;
    public UsuarioService(IUsuarioRepository repo) { this.repo = repo; }
    @Override
    public Usuario crearUsuario(String nombre, String email) {
        Usuario u = new Usuario(null, nombre, email, LocalDate.now(), 1);
        repo.save(u);
        return u;
    }
    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return repo.findById(id);
    }
    @Override
    public void actualizarNivel(Long id, int nuevoNivel) {
        if (nuevoNivel < 1 || nuevoNivel > NIVEL_MAXIMO) throw new IllegalArgumentException("Nivel fuera de rango");
        Usuario u = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        u.setNivel(nuevoNivel);
        repo.save(u);
    }
}

