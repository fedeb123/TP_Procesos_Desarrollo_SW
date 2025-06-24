package com.uade.tpo.Notificaciones.adapters;

import com.uade.tpo.Notificaciones.INotificador;
import com.uade.tpo.Notificaciones.fakes.FakeJavaMail;
import com.uade.tpo.Observer.Observer;

public class EmailAdapter implements INotificador {

    private final FakeJavaMail mailService = FakeJavaMail.getInstancia();

    @Override
    public void notificar(Observer observer, String mensaje) {
        String correo = observer.getCorreo();

        this.mailService.enviarCorreo(correo,"Aviso",mensaje);
    }
}

