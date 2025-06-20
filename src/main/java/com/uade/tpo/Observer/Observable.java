package com.uade.tpo.Observer;

import com.uade.tpo.Services.INotificacionService;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();
    private final INotificacionService notificacionService;

    public Observable(INotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    public void agregarObservador(Observer o) {
        observers.add(o);
    }

    public void eliminarObservador(Observer o) {
        observers.remove(o);
    }

    public void notificarObservadores(String mensaje) {
        for (Observer o : observers) {
            this.notificacionService.notificar(o,mensaje);
        }
    }

    public List<Observer> getObservadores() {
        return observers;
    }
}


