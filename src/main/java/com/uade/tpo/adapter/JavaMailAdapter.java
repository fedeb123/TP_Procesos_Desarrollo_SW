package com.uade.tpo.adapter;

import com.uade.tpo.services.interfaces.IEmailAdapter;
import com.uade.tpo.views.VerNotificaciones;

public class JavaMailAdapter implements IEmailAdapter {

    public JavaMailAdapter(){
        super();
    }

    @Override
    public void enviarMail(String mensaje, String correo){
        // Simular envio de email
        String log = String.format(" Enviando notificacion: %s al correo: %s %n ", mensaje, correo);
        System.out.print(log);

        // Agregar a la vista de notificaciones
        VerNotificaciones.agregarNotificacionGlobal("Email a " + correo + ": " + mensaje);
    }
}
