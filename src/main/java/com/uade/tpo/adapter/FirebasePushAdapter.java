package com.uade.tpo.adapter;

import com.uade.tpo.models.Usuario;
import com.uade.tpo.services.interfaces.IFirebasePushAdapter;
import com.uade.tpo.views.VerNotificaciones;

public class FirebasePushAdapter implements IFirebasePushAdapter {

    public FirebasePushAdapter(){
        super();
    }

    @Override
    public void mostrarNotificacionEnPantalla(String mensaje, Usuario usuario){
        String log = String.format(" Al usuario: %s le aparecio la notificacion Push: %s %n ", usuario.getNombre(), mensaje);
        System.out.print(log);

        // Agregar a la vista de notificaciones
        VerNotificaciones.agregarNotificacionGlobal("Push a " + usuario.getNombre() + ": " + mensaje);
    }   
} 

