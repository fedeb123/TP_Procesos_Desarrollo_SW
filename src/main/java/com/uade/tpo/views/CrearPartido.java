package com.uade.tpo.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;

public class CrearPartido extends JFrame {
    public CrearPartido(UsuarioDTO usuarioLogueado) {
        setTitle("Crear Partido");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel direccionLabel = new JLabel("Dirección:");
        JTextField direccionField = new JTextField();

        JLabel fechaLabel = new JLabel("Fecha y Hora:");
        JSpinner fechaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaSpinner, "dd/MM/yyyy HH:mm");
        fechaSpinner.setEditor(editor);

        JLabel deporteLabel = new JLabel("Deporte:");
        JComboBox<Enums.TipoDeporte> deporteCombo = new JComboBox<>(Enums.TipoDeporte.values());

        JLabel duracionLabel = new JLabel("Duración (horas):");
        JTextField duracionField = new JTextField();

        JLabel cantidadLabel = new JLabel("Cantidad de Jugadores:");
        JTextField cantidadJugadoresField = new JTextField();

        JButton crearBtn = new JButton("Crear Partido");
        crearBtn.setBackground(new Color(0, 123, 255));
        crearBtn.setForeground(Color.WHITE);

        JButton volverBtn = new JButton("Volver");
        volverBtn.addActionListener(e -> {
            new Home(usuarioLogueado).setVisible(true);
            dispose();
        });

        crearBtn.addActionListener(e -> {
            try {
                PartidoDTO partido = new PartidoDTO(
                    (Enums.TipoDeporte) deporteCombo.getSelectedItem(),
                    new Zona(
                        usuarioLogueado.getUbicacion().getProvincia(),
                        usuarioLogueado.getUbicacion().getMunicipio()
                    ),
                    (Date) fechaSpinner.getValue(),
                    direccionField.getText(),
                    usuarioLogueado,
                    null, // Método de emparejamiento aún no disponible desde la vista
                    Integer.parseInt(cantidadJugadoresField.getText()),
                    Float.parseFloat(duracionField.getText()),
                    usuarioLogueado.getNivelJuego()
                );

                PartidoController.getInstance().crearPartido(partido);
                JOptionPane.showMessageDialog(this, "Partido creado con éxito");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridx = 0; gbc.gridy = 0; panel.add(direccionLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(direccionField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(fechaLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(fechaSpinner, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(deporteLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(deporteCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(duracionLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(duracionField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(cantidadLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(cantidadJugadoresField, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(crearBtn, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(volverBtn, gbc);

        add(panel);
    }
}
