package com.uade.tpo.views;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.*;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.models.dto.ZonaDTO;

public class CrearPartido extends JFrame {
    public CrearPartido(UsuarioDTO usuarioLogueado) {
        setTitle("Crear Partido");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField direccionField = new JTextField();
        JSpinner fechaSpinner = new JSpinner(new SpinnerDateModel());
        JComboBox<Enums.TipoDeporte> deporteCombo = new JComboBox<>(Enums.TipoDeporte.values());
        JTextField duracionField = new JTextField();
        JTextField cantidadJugadoresField = new JTextField();

        JButton crearBtn = new JButton("Crear");
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
                    null, // Método de emparejamiento no definido desde la vista por ahora
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

        panel.add(new JLabel("Dirección:"));
        panel.add(direccionField);

        panel.add(new JLabel("Fecha y Hora:"));
        panel.add(fechaSpinner);

        panel.add(new JLabel("Deporte:"));
        panel.add(deporteCombo);

        panel.add(new JLabel("Duración (horas):"));
        panel.add(duracionField);

        panel.add(new JLabel("Cantidad de Jugadores:"));
        panel.add(cantidadJugadoresField);

        panel.add(crearBtn);

        add(panel);
    }
}
