package com.uade.tpo.Notificaciones;

import com.uade.tpo.Models.Usuario;

public interface INotificador {
    void notificar(Usuario usuario, String mensaje);
}
