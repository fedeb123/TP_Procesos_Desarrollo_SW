package com.uade.tpo.Notificaciones.fakes;

public class FakeFirebase {
    private static final FakeFirebase instancia = new FakeFirebase();

    private FakeFirebase() {
    }

    public static FakeFirebase getInstancia() {
        return instancia;
    }

    public void enviarPush(String mensaje) {
        System.out.println(mensaje);
    }
}

