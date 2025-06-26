package com.uade.tpo.adapter;

import com.uade.tpo.models.Usuario;
import com.uade.tpo.services.interfaces.IFirebasePushAdapter;

public class FirebasePushAdapter implements IFirebasePushAdapter {
    
    public FirebasePushAdapter(){
        super();
    }

    @Override
    public void mostrarNotificacionEnPantalla(String mensaje, Usuario usuario){
        //aca iria la funcion concreta de Firebase con sus parametros
        // y demas cosas
        System.out.printf(" Al usuario: %s le aparecio la notificacion Push: %s %n ", usuario.getNombre(), mensaje);
    }   
    
}
