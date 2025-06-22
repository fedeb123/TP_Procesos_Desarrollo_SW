package com.uade.tpo.Notificaciones.fakes;

public class FakeJavaMail {
    private static final FakeJavaMail instancia = new FakeJavaMail();

    private FakeJavaMail() {
    }

    public static FakeJavaMail getInstancia() {
        return instancia;
    }

    public void enviarCorreo(String destino, String asunto, String texto) {
        System.out.println("mail a: " + destino + " - asunto: " + asunto + " - texto: " + texto);
    }
}

