package com.uade.tpo.services;


import com.uade.tpo.adapter.FirebasePushAdapter;
import com.uade.tpo.adapter.JavaMailAdapter;
import com.uade.tpo.models.Usuario;
import com.uade.tpo.services.interfaces.IEmailAdapter;
import com.uade.tpo.services.interfaces.IFirebasePushAdapter;


public class NotificacionService {

    private final IEmailAdapter emailAdapter;
    private final IFirebasePushAdapter firebaseAdapter;
    private static NotificacionService instance;

    public static NotificacionService getInstance() {
        if (instance == null){
            instance = new NotificacionService();
        }
        return instance;
    }
    
    private NotificacionService(){
        this.emailAdapter = new JavaMailAdapter();
        this.firebaseAdapter = new FirebasePushAdapter();
    }

    public void enviarNotificacion(String mensaje, Usuario usuario){
        this.emailAdapter.enviarMail(mensaje, usuario.getCorreo());
        this.firebaseAdapter.mostrarNotificacionEnPantalla(mensaje, usuario);
    }
}
    
