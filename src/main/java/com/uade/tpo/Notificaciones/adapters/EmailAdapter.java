package com.uade.tpo.Notificaciones.adapters;

import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Notificaciones.INotificador;
import com.uade.tpo.Notificaciones.fakes.FakeJavaMail;

public class EmailAdapter implements INotificador {

    private final FakeJavaMail mailService = FakeJavaMail.getInstancia();

    @Override
    public void notificar(Usuario usuario, String mensaje) {
        mailService.enviarCorreo(usuario.getCorreo(), "Notificación de partido", mensaje);
    }
}

