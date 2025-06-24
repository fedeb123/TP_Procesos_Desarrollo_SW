package com.uade.tpo.Services;

import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Notificaciones.INotificador;
import com.uade.tpo.Notificaciones.adapters.EmailAdapter;
import com.uade.tpo.Notificaciones.adapters.PushAdapter;
import com.uade.tpo.Observer.Observer;

import java.util.List;


public class NotificacionService implements INotificacionService {

    private final INotificador pushAdapter;
    private final INotificador emailAdapter;

    public NotificacionService() {
        this.pushAdapter = new PushAdapter();
        this.emailAdapter = new EmailAdapter();
    }

    public void notificar(Observer o, String mensaje) {
        this.pushAdapter.notificar(o, mensaje);
        this.emailAdapter.notificar(o, mensaje);

    }

    public void notificarATodos(List<Observer> observers, String mensaje) {
        for (Observer o : observers) {
            this.pushAdapter.notificar(o, mensaje);
            this.emailAdapter.notificar(o, mensaje);
        }
    }
}
