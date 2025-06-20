package com.uade.tpo.Services;

import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Notificaciones.INotificador;
import com.uade.tpo.Notificaciones.adapters.EmailAdapter;
import com.uade.tpo.Notificaciones.adapters.PushAdapter;

import java.util.List;


public class NotificacionService {

    private final INotificador pushAdapter;
    private final INotificador emailAdapter;

    public NotificacionService() {
        this.pushAdapter = new PushAdapter();
        this.emailAdapter = new EmailAdapter();
    }

    public void notificarATodos(List<Usuario> usuarios, String mensaje) {
        for (Usuario u : usuarios) {
            this.pushAdapter.notificar(u, mensaje);
            this.emailAdapter.notificar(u, mensaje);
        }
    }
}
