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
import com.uade.tpo.emparejamiento.IEmparejamiento;
import com.uade.tpo.emparejamiento.PorCercania;
import com.uade.tpo.emparejamiento.PorHistorial;
import com.uade.tpo.emparejamiento.PorNivelMinimo;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.models.dto.ZonaDTO;

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

        JLabel duracionLabel = new JLabel("Duración (minutos):");
        JTextField duracionField = new JTextField();

        JLabel cantidadLabel = new JLabel("Cantidad de Jugadores:");
        JTextField cantidadJugadoresField = new JTextField();

        JLabel emparejamientoLabel = new JLabel("Tipo emparejamiento:");
        JComboBox<Enums.TipoEmparejamiento> emparejamientoCombo = new JComboBox<>(Enums.TipoEmparejamiento.values());
        JLabel parametroLabel = new JLabel("Cantidad de partidos a considerar:");
        JTextField parametroField = new JTextField();
        parametroLabel.setVisible(false);
        parametroField.setVisible(false);



        // Agregás un ActionListener al combo
        emparejamientoCombo.addActionListener(e -> {
            Enums.TipoEmparejamiento seleccionado = (Enums.TipoEmparejamiento) emparejamientoCombo.getSelectedItem();

            // Solo mostramos el campo si es POR_HISTORIAL
            boolean mostrarCampo = seleccionado == Enums.TipoEmparejamiento.POR_HISTORIAL;
            parametroLabel.setVisible(mostrarCampo);
            parametroField.setVisible(mostrarCampo);

            // Obligatorio para que se actualice visualmente
            panel.revalidate();
            panel.repaint();
        });

        JButton crearBtn = new JButton("Crear Partido");
        crearBtn.setBackground(new Color(0, 123, 255));
        crearBtn.setForeground(Color.WHITE);

        JButton volverBtn = new JButton("Volver");
        volverBtn.addActionListener(e -> {
            //new Home(usuarioLogueado).setVisible(true);
            dispose();
        });

        crearBtn.addActionListener(e -> {
            try {
              Enums.TipoEmparejamiento tipo = (Enums.TipoEmparejamiento) emparejamientoCombo.getSelectedItem();
              IEmparejamiento metodoEmparejamiento;

              PartidoDTO partido;  

            switch (tipo) {
                case POR_CERCANIA: {
                    partido = new PartidoDTO(
                        (Enums.TipoDeporte) deporteCombo.getSelectedItem(),
                        new ZonaDTO(
                            usuarioLogueado.getUbicacion().getProvincia(),
                            usuarioLogueado.getUbicacion().getMunicipio()
                        ),
                        (Date) fechaSpinner.getValue(),
                        direccionField.getText(),
                        usuarioLogueado,
                        new PorCercania(),
                        Integer.parseInt(cantidadJugadoresField.getText()),
                        Float.parseFloat(duracionField.getText()),
                        usuarioLogueado.getNivelJuego(),null
                    );
                    break;
                }

                case POR_HISTORIAL: {
                    partido = new PartidoDTO(
                        (Enums.TipoDeporte) deporteCombo.getSelectedItem(),
                        new ZonaDTO(
                            usuarioLogueado.getUbicacion().getProvincia(),
                            usuarioLogueado.getUbicacion().getMunicipio()
                        ),
                        (Date) fechaSpinner.getValue(),
                        direccionField.getText(),
                        usuarioLogueado,
                        new PorHistorial(Integer.parseInt(parametroField.getText())),  // Asumimos que acepta un int
                        Integer.parseInt(cantidadJugadoresField.getText()),
                        Float.parseFloat(duracionField.getText()),
                        usuarioLogueado.getNivelJuego(),null
                    );
                    break;
                }

                case POR_NIVEL_MINIMO: {
                    partido = new PartidoDTO(
                        (Enums.TipoDeporte) deporteCombo.getSelectedItem(),
                        new ZonaDTO(
                            usuarioLogueado.getUbicacion().getProvincia(),
                            usuarioLogueado.getUbicacion().getMunicipio()
                        ),
                        (Date) fechaSpinner.getValue(),
                        direccionField.getText(),
                        usuarioLogueado,
                        new PorNivelMinimo(),
                        Integer.parseInt(cantidadJugadoresField.getText()),
                        Float.parseFloat(duracionField.getText()),
                        usuarioLogueado.getNivelJuego(),null
                    );
                    break;
                }

                default:
                    throw new IllegalStateException("Tipo de emparejamiento no reconocido.");
            }
                              
                

                PartidoController.getInstance().crearPartido(partido);
                JOptionPane.showMessageDialog(this, "Partido creado con éxito");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

                // Dirección
        gbc.gridx = 0; gbc.gridy = 0; panel.add(direccionLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(direccionField, gbc);

        // Fecha y Hora
        gbc.gridx = 0; gbc.gridy = 1; panel.add(fechaLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(fechaSpinner, gbc);

        // Deporte
        gbc.gridx = 0; gbc.gridy = 2; panel.add(deporteLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(deporteCombo, gbc);

        // Duración
        gbc.gridx = 0; gbc.gridy = 3; panel.add(duracionLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(duracionField, gbc);

        // Cantidad de Jugadores
        gbc.gridx = 0; gbc.gridy = 4; panel.add(cantidadLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; panel.add(cantidadJugadoresField, gbc);

        // Tipo de Emparejamiento
        gbc.gridx = 0; gbc.gridy = 5; panel.add(emparejamientoLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5; panel.add(emparejamientoCombo, gbc);

        // Parámetro adicional (solo visible en POR_HISTORIAL)
        gbc.gridx = 0; gbc.gridy = 6; panel.add(parametroLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6; panel.add(parametroField, gbc);

        // Botón Crear Partido
        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(crearBtn, gbc);

        // Botón Volver
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(volverBtn, gbc);

        add(panel);
    }
}
