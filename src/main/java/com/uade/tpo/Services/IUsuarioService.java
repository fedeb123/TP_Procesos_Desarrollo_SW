package com.uade.tpo.Services;
import com.uade.tpo.Models.Usuario;
import java.util.Optional;
public interface IUsuarioService {
    Usuario crearUsuario(String nombre, String email);
    Optional<Usuario> buscarPorId(Long id);
    void actualizarNivel(Long id, int nuevoNivel);
}
