package com.uade.tpo.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;

public class BuscarPartido extends JFrame {

    public BuscarPartido(UsuarioDTO usuarioLogueado) {
        setTitle("Buscar Partidos");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel deporteLabel = new JLabel("Seleccione Deporte:");
        JComboBox<Enums.TipoDeporte> deporteCombo = new JComboBox<>(Enums.TipoDeporte.values());
        JButton buscarBtn = new JButton("Buscar Partidos");
        buscarBtn.setBackground(new Color(0, 123, 255));
        buscarBtn.setForeground(Color.WHITE);

        JTextArea resultadosArea = new JTextArea(10, 40);
        resultadosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadosArea);

        JButton volverBtn = new JButton("Volver");
        volverBtn.addActionListener(e -> {
            new Home(usuarioLogueado).setVisible(true);
            dispose();
        });

        buscarBtn.addActionListener(e -> {
            Enums.TipoDeporte deporte = (Enums.TipoDeporte) deporteCombo.getSelectedItem();
            Zona zona = new Zona(
                usuarioLogueado.getUbicacion().getProvincia(),
                usuarioLogueado.getUbicacion().getMunicipio()
            );
            ArrayList<PartidoDTO> partidos = PartidoController.getInstance().buscarPartidos(zona, deporte);

            resultadosArea.setText("");
            if (partidos.isEmpty()) {
                resultadosArea.setText("No se encontraron partidos para el deporte seleccionado en tu zona.");
            } else {
                for (PartidoDTO p : partidos) {
                    resultadosArea.append("Dirección: " + p.getDireccion() +
                        "\nFecha y Hora: " + p.getHorario() +
                        "\nOrganizador: " + p.getOrganizadorPartido().getNombre() +
                        "\nJugadores requeridos: " + p.getCantidadJugadoresRequerida() +
                        "\nDuración: " + p.getDuracionEncuentro() + " hs\n\n");
                }
            }
        });

        gbc.gridx = 0; gbc.gridy = 0; panel.add(deporteLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(deporteCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buscarBtn, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(volverBtn, gbc);

        add(panel);
    }
}