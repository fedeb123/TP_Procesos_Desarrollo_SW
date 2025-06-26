package com.uade.tpo.views;

import javax.print.MultiDocPrintService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.uade.tpo.controllers.UsuarioController;
import com.uade.tpo.models.Enums.TipoDeporte;
import com.uade.tpo.models.Enums.TipoNivelDeJuego;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.models.dto.ZonaDTO;

public class Registro extends JFrame {

    private final JTextField nombreField = new JTextField(15);
    private final JTextField apellidoField = new JTextField(15);
    private final JTextField correoField = new JTextField(15);
    private final JPasswordField contraseñaField = new JPasswordField(15);
    private final JTextField sexoField = new JTextField(1);
    private final JTextField dniField = new JTextField(10);
    private final JComboBox<TipoNivelDeJuego> nivelCombo = new JComboBox<>(TipoNivelDeJuego.values());
    private final JComboBox<TipoDeporte> deporteCombo = new JComboBox<>(TipoDeporte.values());
    private final JTextField provinciaField = new JTextField(5);
    private final JTextField municipioField = new JTextField(5);
    

    public Registro() {
        setTitle("Registro de Usuario");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(11, 2));
        JButton volverBtn = new JButton("Volver");

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);

        panel.add(new JLabel("Apellido:"));
        panel.add(apellidoField);

        panel.add(new JLabel("Correo electrónico:"));
        panel.add(correoField);

        panel.add(new JLabel("Contraseña:"));
        panel.add(contraseñaField);

        panel.add(new JLabel("Sexo (M/F):"));
        panel.add(sexoField);

        panel.add(new JLabel("DNI:"));
        panel.add(dniField);

        panel.add(new JLabel("Nivel de juego:"));
        panel.add(nivelCombo);

        panel.add(new JLabel("Deporte favorito:"));
        panel.add(deporteCombo);

        panel.add(new JLabel("Provincia:"));
        panel.add(provinciaField);

        panel.add(new JLabel("Municipio:"));
        panel.add(municipioField);

        JButton registrarBtn = new JButton("Registrar");
        registrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        volverBtn.addActionListener(e -> {
            new Menu().setVisible(true);
            dispose();
        });

        panel.add(new JLabel()); // espacio vacío
        panel.add(registrarBtn);
        panel.add(volverBtn);
        add(panel);
    }

    private void registrarUsuario() {
        try {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String correo = correoField.getText();
            String contraseña = new String(contraseñaField.getPassword());
            char sexo = sexoField.getText().toUpperCase().charAt(0);
            String dni = dniField.getText();
            TipoNivelDeJuego nivel = (TipoNivelDeJuego) nivelCombo.getSelectedItem();
            TipoDeporte deporte = (TipoDeporte) deporteCombo.getSelectedItem();
            String provincia = provinciaField.getText();
            String municipio = municipioField.getText();


            // Por simplicidad, se crea una Zona dummy. En implementación real, se debe buscar por ID.
            ZonaDTO zona = new ZonaDTO(provincia, municipio);

            UsuarioDTO nuevoUsuario = new UsuarioDTO(nombre, apellido, correo, contraseña, sexo, dni, nivel, deporte, zona);
            UsuarioController.getInstance().crearUsuario(nuevoUsuario);

            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nombreField.setText("");
        apellidoField.setText("");
        correoField.setText("");
        contraseñaField.setText("");
        sexoField.setText("");
        dniField.setText("");
        provinciaField.setText("");
        municipioField.setText("");
        nivelCombo.setSelectedIndex(0);
        deporteCombo.setSelectedIndex(0);
        
    }

    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}
