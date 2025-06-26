package com.uade.tpo.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.models.dto.ComentarioDTO;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;

public class ComentarioPartido extends JFrame{
    public ComentarioPartido (PartidoDTO partido, UsuarioDTO usuario){
      
      setTitle("Comentarios del Partido");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JPanel comentariosPanel = new JPanel();
        comentariosPanel.setLayout(new BoxLayout(comentariosPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(comentariosPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Campo para nuevo comentario
        JTextField nuevoComentarioField = new JTextField();
        JButton enviarBtn = new JButton("Agregar Comentario");
        enviarBtn.setBackground(new Color(40, 167, 69));
        enviarBtn.setForeground(Color.WHITE);

        // Panel inferior
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(nuevoComentarioField, BorderLayout.CENTER);
        inputPanel.add(enviarBtn, BorderLayout.EAST);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);
        //comentarPartido(partido);

        // Acción del botón
        enviarBtn.addActionListener(e-> {
                String texto = nuevoComentarioField.getText();
                if (!texto.isEmpty()) {
                    PartidoController.getInstance().comentarPartido(new ComentarioDTO(texto,usuario), partido);
                    nuevoComentarioField.setText("");
                    System.out.println("Se ha comentado: "+texto);
                } else {
                    JOptionPane.showMessageDialog(ComentarioPartido.this, "El comentario no puede estar vacío.");
                }
            
        });
    }
    
}
