package com.uade.tpo.observer;

import java.util.ArrayList;

public class NotificadorObservable implements INotificadorObservable {
    private final ArrayList<INotificadorObserver> listaObservadores;

    public NotificadorObservable(){
        this.listaObservadores = new ArrayList<>();
    }

    @Override
    public void agregarObservador(INotificadorObserver observer){
        this.listaObservadores.add(observer);
    }

    @Override
    public void eliminarObservador(INotificadorObserver observer){
        this.listaObservadores.remove(observer);
    }

    @Override
    public void notificar(String notificacion){
        for (INotificadorObserver observer : this.listaObservadores){
            observer.update(notificacion);
        }
    }
}
