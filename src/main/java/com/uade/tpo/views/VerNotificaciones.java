package com.uade.tpo.views;

import javax.swing.*;

import com.uade.tpo.models.Usuario;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.repositories.UsuarioRepository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VerNotificaciones extends JFrame {

    private DefaultListModel<String> modeloLista;
    private JList<String> listaNotificaciones;
    private static final ArrayList<String> notificacionesGlobales = new ArrayList<>();

    public VerNotificaciones(UsuarioDTO usuarioDTO) {
        setTitle("Notificaciones de " + usuarioDTO.getNombre());
        setSize(300, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        modeloLista = new DefaultListModel<>();
        Usuario usuario = UsuarioRepository.getInstance().buscarUsuario(usuarioDTO.getDni());
        for (String notificacion : usuario.getNotificaciones()) {
            modeloLista.addElement(notificacion);
        }

        listaNotificaciones = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaNotificaciones);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void agregarNotificacionGlobal(String mensaje) {
        notificacionesGlobales.add(mensaje);
    }

    public void agregarNotificacion(String mensaje) {
        modeloLista.addElement(mensaje);
    }

    public static List<String> getNotificacionesGlobales() {
        return new ArrayList<>(notificacionesGlobales);
    }
} 
