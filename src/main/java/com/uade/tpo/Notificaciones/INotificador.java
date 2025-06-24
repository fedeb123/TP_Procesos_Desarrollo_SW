package com.uade.tpo.Notificaciones;

import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Observer.Observer;

public interface INotificador {
    void notificar(Observer observer, String mensaje);
}
