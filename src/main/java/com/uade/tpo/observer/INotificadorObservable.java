package com.uade.tpo.observer;

public interface INotificadorObservable {
    public void agregarObservador(INotificadorObserver observer);

    public void eliminarObservador(INotificadorObserver observer);

    public void notificar(String mensaje);
    
}
