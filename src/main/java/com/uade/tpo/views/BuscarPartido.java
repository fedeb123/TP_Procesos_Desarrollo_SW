package com.uade.tpo.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;

public class BuscarPartido extends JFrame {

    public BuscarPartido(UsuarioDTO usuarioLogueado) {
        setTitle("Buscar Partidos");
        setSize(600, 500);
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

        JPanel resultadosPanel = new JPanel();
        resultadosPanel.setLayout(new BoxLayout(resultadosPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(resultadosPanel);
        scrollPane.setPreferredSize(new Dimension(550, 250));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton volverBtn = new JButton("Volver");
        volverBtn.addActionListener(e -> {
            new Home(usuarioLogueado).setVisible(true);
            dispose();
        });

    buscarBtn.addActionListener(e -> {
    resultadosPanel.removeAll();
    //System.out.println("Total de partidos en repositorio: " + PartidoController.getInstance().getHistorialPartidos(usuarioLogueado).size());
    //System.out.println("Zona buscada: " + usuarioLogueado.getUbicacion().getProvincia() + ", " + usuarioLogueado.getUbicacion().getMunicipio());

    Enums.TipoDeporte deporte = (Enums.TipoDeporte) deporteCombo.getSelectedItem();
    Zona zona = new Zona(
        usuarioLogueado.getUbicacion().getProvincia(),
        usuarioLogueado.getUbicacion().getMunicipio()
    );

    ArrayList<PartidoDTO> partidos = PartidoController.getInstance().buscarPartidos(zona, deporte);

    if (partidos.isEmpty()) {
        JLabel sinResultados = new JLabel("No se encontraron partidos para el deporte seleccionado en tu zona.");
        sinResultados.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultadosPanel.add(sinResultados);
    } else {
        for (PartidoDTO p : partidos) {
            if (p.getOrganizadorPartido() != null 
                && p.getOrganizadorPartido().getNombre() != null 
                && !p.getOrganizadorPartido().getNombre().equals(usuarioLogueado.getNombre())) {
                
              JPanel partidoPanel = new JPanel();
              partidoPanel.setLayout(new BoxLayout(partidoPanel, BoxLayout.Y_AXIS));
              partidoPanel.setBorder(BorderFactory.createCompoundBorder(
                  BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                  BorderFactory.createEmptyBorder(10, 10, 10, 10)
              ));
              partidoPanel.setBackground(new Color(245, 245, 245));

              partidoPanel.add(new JLabel("Dirección: " + p.getDireccion()));
              partidoPanel.add(new JLabel("Fecha y Hora: " + p.getHorario()));
              partidoPanel.add(new JLabel("Organizador: " + p.getOrganizadorPartido().getNombre()));
              partidoPanel.add(new JLabel("Jugadores requeridos: " + p.getCantidadJugadoresRequerida()));
              partidoPanel.add(new JLabel("Duración: " + p.getDuracionEncuentro() + " hs"));

              JButton unirseBtn = new JButton("Unirse a este partido");
              unirseBtn.setBackground(new Color(40, 167, 69));
              unirseBtn.setForeground(Color.WHITE);
              unirseBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

              unirseBtn.addActionListener(ev -> {
                  PartidoController.getInstance().agregarJugador(p, usuarioLogueado);
                  JOptionPane.showMessageDialog(this, "Te has unido al partido exitosamente.");
              });

              partidoPanel.add(Box.createRigidArea(new Dimension(0, 8)));
              partidoPanel.add(unirseBtn);
              partidoPanel.add(Box.createRigidArea(new Dimension(0, 8)));

              JPanel contenedor = new JPanel(new BorderLayout());
              contenedor.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));
              contenedor.add(partidoPanel, BorderLayout.CENTER);

              resultadosPanel.add(contenedor);
              resultadosPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        }}
    }

    scrollPane.getViewport().revalidate();
    scrollPane.getViewport().repaint();
    resultadosPanel.revalidate();
    resultadosPanel.repaint();

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