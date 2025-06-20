package com.uade.tpo.Notificaciones.adapters;

import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Notificaciones.INotificador;
import com.uade.tpo.Notificaciones.fakes.FakeFirebase;
import com.uade.tpo.Observer.Observer;

public class PushAdapter implements INotificador {

    private final FakeFirebase pushService = FakeFirebase.getInstancia();

    @Override
    public void notificar(Observer observer, String mensaje) {
        // Todo fake
        this.pushService.enviarPush(mensaje);
    }
}
