package com.uade.tpo.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VerNotificaciones extends JFrame {

    private DefaultListModel<String> modeloLista;
    private JList<String> listaNotificaciones;

    public VerNotificaciones(ArrayList<String> notificaciones) {
        setTitle("Notificaciones");
        setSize(300, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        modeloLista = new DefaultListModel<>();
        for (String notificacion : notificaciones) {
            modeloLista.addElement(notificacion);
        }

        listaNotificaciones = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaNotificaciones);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void agregarNotificacion(String mensaje) {
        modeloLista.addElement(mensaje);
    }
}