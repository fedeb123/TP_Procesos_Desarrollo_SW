package com.uade.tpo.services.interfaces;

import com.uade.tpo.models.Usuario;

public interface IFirebasePushAdapter {
    public void mostrarNotificacionEnPantalla(String mensaje, Usuario usuario);    
}
