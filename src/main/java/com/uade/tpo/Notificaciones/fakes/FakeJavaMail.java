package com.uade.tpo.Notificaciones.fakes;

public class FakeJavaMail {
    private static final FakeJavaMail instancia = new FakeJavaMail();

    private FakeJavaMail() {
    }

    public static FakeJavaMail getInstancia() {
        return instancia;
    }

    public void enviarCorreo(String destino, String asunto, String cuerpo) {
        System.out.println("📧 [Email enviado] A: " + destino + " - Asunto: " + asunto + " - Cuerpo: " + cuerpo);
    }
}

