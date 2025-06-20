package com.uade.tpo.Services;

import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Observer.Observer;

import java.util.List;

public interface INotificacionService {
    void notificar(Observer observer, String mensaje);

    void notificarATodos(List<Observer> observers, String mensaje);
}