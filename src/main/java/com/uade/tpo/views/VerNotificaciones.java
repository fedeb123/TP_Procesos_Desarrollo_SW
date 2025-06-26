package com.uade.tpo.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.controllers.UsuarioController;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;


public class VerNotificaciones extends JFrame {

    private JPanel panelNotificaciones;

    public VerNotificaciones(UsuarioDTO usuarioDTO) {
        setTitle("Notificaciones de " + usuarioDTO.getNombre());
        setSize(400, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panelNotificaciones = new JPanel();
        panelNotificaciones.setLayout(new BoxLayout(panelNotificaciones, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panelNotificaciones);

        UsuarioDTO usuario = UsuarioController.getInstance().buscarUsuario(usuarioDTO.getDni());
        for (String notificacion : usuario.getNotificaciones()) {
            JPanel notiPanel = new JPanel();
            notiPanel.setLayout(new BoxLayout(notiPanel, BoxLayout.Y_AXIS));
            notiPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.GRAY, 1),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            notiPanel.setBackground(new Color(250, 250, 250));

            JLabel label = new JLabel(notificacion);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            notiPanel.add(label);

            // Agregar botón si es del tipo confirmación de partido
            if (notificacion.contains("Partido armado, No olvidar confirmar")) {
                JButton confirmarBtn = new JButton("Confirmar Participación");
                confirmarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                confirmarBtn.setBackground(new Color(0, 123, 255));
                confirmarBtn.setForeground(Color.WHITE);

                confirmarBtn.addActionListener(e -> {
                    // Buscar el partido correspondiente (simplificado)
                    ArrayList<PartidoDTO> partidos = PartidoController.getInstance().getAllPartidos();
                    for (PartidoDTO partido : partidos) {
                        // Comparar por DNI en lugar de usar contains
                        boolean usuarioEnPartido = false;
                        for (UsuarioDTO jugador : partido.getJugadores()) {
                            if (jugador.getDni().equals(usuario.getDni())) {
                                usuarioEnPartido = true;
                                break;
                            }
                        }
                        
                        if (usuarioEnPartido) {
                            System.out.println("Confirmado");
                            PartidoController.getInstance().confirmarPartipacion(partido, usuarioDTO);
                            JOptionPane.showMessageDialog(this, "Confirmación realizada con éxito.");

                            confirmarBtn.setEnabled(false);
                            break;
                        }
                    }
                });

                notiPanel.add(Box.createRigidArea(new Dimension(0, 8)));
                notiPanel.add(confirmarBtn);
            }
        if (notificacion.equals("Partido finalizado")){
                JButton comentarioBtn = new JButton("Comentar partido");
                comentarioBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                comentarioBtn.setBackground(new Color(0, 123, 255));
                comentarioBtn.setForeground(Color.WHITE);

                comentarioBtn.addActionListener(e -> {
                ArrayList<PartidoDTO> partidos = PartidoController.getInstance().getAllPartidos();
                for (PartidoDTO partido : partidos) {
                      if (usuarioDTO.getDni().equals(usuario.getDni())) {
                        new ComentarioPartido(partido, usuarioDTO).setVisible(true);
                        break;
                    }
                }
              });

                  notiPanel.add(Box.createRigidArea(new Dimension(0, 8)));
                  notiPanel.add(comentarioBtn);
            }

            panelNotificaciones.add(Box.createRigidArea(new Dimension(0, 10)));
            panelNotificaciones.add(notiPanel);
        }

        add(scrollPane, BorderLayout.CENTER);
        JButton volverBtn = new JButton("Volver");
        volverBtn.addActionListener(e -> {
            //new Home(usuarioLogueado).setVisible(true);
            dispose();
        });
    }

    public static void agregarNotificacionGlobal(String mensaje) {
        // Ya no se usa para usuario específico
    }

    public void agregarNotificacion(String mensaje) {
        // Ya no se usa porque el diseño es dinámico por panel
    }

    public static List<String> getNotificacionesGlobales() {
        return new ArrayList<>();
    }
}
