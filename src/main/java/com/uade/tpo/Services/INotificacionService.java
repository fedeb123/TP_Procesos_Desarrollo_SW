package com.uade.tpo.Services;

import com.uade.tpo.Models.Usuario;

import java.util.List;

public interface INotificacionService {
    void notificarATodos(List<Usuario> usuarios, String mensaje);
}