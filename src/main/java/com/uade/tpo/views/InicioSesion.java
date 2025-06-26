package com.uade.tpo.views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.uade.tpo.controllers.UsuarioController;
import com.uade.tpo.models.dto.UsuarioDTO;

class InicioSesion extends JFrame {
    public InicioSesion() {
        setTitle("Inicio Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField dniField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();
        JButton confirmar = new JButton("Confirmar");
        JButton volverBtn = new JButton("Volver");

        confirmar.addActionListener(e -> {
            UsuarioDTO usuario = UsuarioController.getInstance().buscarUsuario(dniField.getText());
            if (usuario != null && usuario.getContraseña().equals(new String(contraseñaField.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                new Home(usuario).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Intente nuevamente.");
            }
        });

        volverBtn.addActionListener(e -> {
            new Menu().setVisible(true);
            dispose();
        });

        panel.add(new JLabel("DNI del Usuario"));
        panel.add(dniField);
        panel.add(new JLabel("Contraseña"));
        panel.add(contraseñaField);
        panel.add(confirmar);
        panel.add(volverBtn);

        add(panel);
    }
}
