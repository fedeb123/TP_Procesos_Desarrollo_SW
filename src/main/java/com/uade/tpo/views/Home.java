package com.uade.tpo.views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.uade.tpo.models.dto.UsuarioDTO;

class Home extends JFrame {
    private final UsuarioDTO usuarioLogueado;

    public Home(UsuarioDTO usuario) {
        this.usuarioLogueado = usuario;

        setTitle("Home");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnCrear = new JButton("Crear Partido");
        JButton btnBuscar = new JButton("Buscar Partido");
        JButton btnNotificaciones = new JButton("Ver Notificaciones");
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");

        btnCrear.addActionListener(e -> new CrearPartido(usuarioLogueado).setVisible(true));
        btnBuscar.addActionListener(e -> new BuscarPartido(usuarioLogueado).setVisible(true));
        btnNotificaciones.addActionListener(e -> new VerNotificaciones(null).setVisible(true));
        btnCerrarSesion.addActionListener(e -> {
            new Registro().setVisible(true);
            dispose();
        });

        setLayout(new GridLayout(4, 1));
        add(btnCrear);
        add(btnBuscar);
        add(btnNotificaciones);
        add(btnCerrarSesion);
    }
}


