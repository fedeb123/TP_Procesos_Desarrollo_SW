package com.uade.tpo.views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.uade.tpo.models.Enums;
import com.uade.tpo.models.dto.UsuarioDTO;

class CrearPartido extends JFrame {
    public CrearPartido(UsuarioDTO usuarioLogueado) {
        setTitle("Crear Partido");
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        JTextField direccionField = new JTextField();
        JSpinner fechaSpinner = new JSpinner(new SpinnerDateModel());
        JComboBox<Enums.TipoDeporte> deporteCombo = new JComboBox<>(Enums.TipoDeporte.values());
        JButton crearBtn = new JButton("Crear");

        // crearBtn.addActionListener(e -> {
        //     PartidoDTO partido = new PartidoDTO();
        //     partido.setDireccion(direccionField.getText());
        //     partido.setHorario((Date) fechaSpinner.getValue());
        //     partido.setTipoDeporte((Enums.TipoDeporte) deporteCombo.getSelectedItem());
        //     partido.setOrganizadorPartido(usuarioLogueado);

        //     PartidoController.getInstance().crearPartido(partido);
        //     JOptionPane.showMessageDialog(this, "Partido creado con éxito");
        //     dispose();
        // });

        panel.add(new JLabel("Dirección"));
        panel.add(direccionField);
        panel.add(new JLabel("Fecha y Hora"));
        panel.add(fechaSpinner);
        panel.add(new JLabel("Deporte"));
        panel.add(deporteCombo);
        panel.add(crearBtn);

        add(panel);
    }
}
