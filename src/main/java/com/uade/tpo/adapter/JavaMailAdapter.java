package com.uade.tpo.adapter;

import com.uade.tpo.services.interfaces.IEmailAdapter;

public class JavaMailAdapter implements IEmailAdapter {

    public JavaMailAdapter(){
        super();
    }

    @Override
    public void enviarMail(String mensaje, String correo){
        //aca iria la funcion concreta de JavaMail con sus parametros
        // y demas cosas

        System.out.printf(" Enviando notificacion: %s al correo: %s %n ", mensaje, correo);
    }
    
}
