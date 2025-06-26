package com.uade.tpo.views;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.uade.tpo.jobs.PartidoJob;

public class Menu extends JFrame {

    public Menu() {
        setTitle("Bienvenido");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crear botones
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");

        // Eventos
        btnRegistrar.addActionListener(e -> {
            new Registro().setVisible(true);
            dispose(); // Cierra la pantalla actual
        });

        btnIniciarSesion.addActionListener(e -> {
            new InicioSesion().setVisible(true);
            dispose(); // Cierra la pantalla actual
        });

        // Layout
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panel.add(btnRegistrar);
        panel.add(btnIniciarSesion);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
        PartidoJob partidoJob = new PartidoJob();
        partidoJob.start();
    }
}
