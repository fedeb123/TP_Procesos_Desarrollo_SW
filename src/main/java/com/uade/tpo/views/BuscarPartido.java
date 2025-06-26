package com.uade.tpo.views;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;

public class BuscarPartido extends JFrame {

    public BuscarPartido(UsuarioDTO usuarioLogueado) {
        setTitle("Buscar Partidos");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JComboBox<Enums.TipoDeporte> deporteCombo = new JComboBox<>(Enums.TipoDeporte.values());
        JButton buscarBtn = new JButton("Buscar");
        JTextArea resultadosArea = new JTextArea();
        resultadosArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultadosArea);

        buscarBtn.addActionListener(e -> {
            Enums.TipoDeporte deporte = (Enums.TipoDeporte) deporteCombo.getSelectedItem();
            Zona zona = new Zona(
                usuarioLogueado.getUbicacion().getProvincia(),
                usuarioLogueado.getUbicacion().getMunicipio()
            );
            ArrayList<PartidoDTO> partidos = PartidoController.getInstance().buscarPartidos(zona, deporte);

            resultadosArea.setText("");
            if (partidos.isEmpty()) {
                resultadosArea.setText("No se encontraron partidos.");
            } else {
                for (PartidoDTO p : partidos) {
                    resultadosArea.append("Dirección: " + p.getDireccion() + "\nFecha: " + p.getHorario() + "\n\n");
                }
            }
        });

        panel.add(new JLabel("Deporte:"));
        panel.add(deporteCombo);
        panel.add(buscarBtn);
        panel.add(scroll);

        add(panel);
    }
}
