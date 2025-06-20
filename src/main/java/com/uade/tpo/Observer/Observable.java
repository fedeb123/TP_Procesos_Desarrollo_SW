package com.uade.tpo.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void agregarObservador(Observer o) {
        observers.add(o);
    }

    public void eliminarObservador(Observer o) {
        observers.remove(o);
    }

    public void notificarObservadores(String mensaje) {
        for (Observer o : observers) {
            o.notificar(mensaje);
        }
    }

    public List<Observer> getObservadores() {
        return observers;
    }
}


