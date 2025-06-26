package com.uade.tpo;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.controllers.UsuarioController;
import com.uade.tpo.emparejamiento.PorNivelMinimo;
import com.uade.tpo.jobs.PartidoJob;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;




public class App
{
    public static void main( String[] args )
    {
        // Instanciar dependencias
        var partidoJob = new PartidoJob();
        var usuarioController = UsuarioController.getInstance();
        var partidoController = PartidoController.getInstance();

        partidoJob.start();

        // Creo 2 usuarios
        UsuarioDTO organizador = new UsuarioDTO("Juan", "Pérez", "abc@gmail.com", "12345678", 'M', "1234", Enums.TipoNivelDeJuego.INTERMEDIO, Enums.TipoDeporte.FUTBOL, new Zona("Buenos Aires", "CABA").toDTO());    
        UsuarioDTO jugador = new UsuarioDTO("Pedro", "Gómez", "pedro@mail.com", "5678", 'M', "87654321", Enums.TipoNivelDeJuego.PRINCIPIANTE, Enums.TipoDeporte.FUTBOL, new Zona("Buenos Aires", "CABA").toDTO());
        UsuarioDTO user1 = new UsuarioDTO("Ana", "López", "ana.lopez@mail.com", "pass123", 'F', "1111", Enums.TipoNivelDeJuego.PRINCIPIANTE, Enums.TipoDeporte.BASQUET, new Zona("Buenos Aires", "CABA").toDTO());
        UsuarioDTO user2 = new UsuarioDTO("Carlos", "González", "carlos.gonzalez@mail.com", "pass456", 'M', "2222", Enums.TipoNivelDeJuego.INTERMEDIO, Enums.TipoDeporte.FUTBOL, new Zona("Rosario", "Santa Fe").toDTO());
        UsuarioDTO user3 = new UsuarioDTO("María", "Pérez", "maria.perez@mail.com", "pass789", 'F', "3333", Enums.TipoNivelDeJuego.AVANZADO, Enums.TipoDeporte.TENIS, new Zona("Córdoba", "Córdoba").toDTO());
        UsuarioDTO user4 = new UsuarioDTO("Jorge", "Martínez", "jorge.martinez@mail.com", "pass321", 'M', "4444", Enums.TipoNivelDeJuego.PRINCIPIANTE, Enums.TipoDeporte.VOLEIBOL, new Zona("Mendoza", "Mendoza").toDTO());
        UsuarioDTO user5 = new UsuarioDTO("Lucía", "Ramírez", "lucia.ramirez@mail.com", "pass654", 'F', "5555", Enums.TipoNivelDeJuego.INTERMEDIO, Enums.TipoDeporte.FUTBOL, new Zona("Buenos Aires", "CABA").toDTO());
        UsuarioDTO user6 = new UsuarioDTO("Diego", "Sánchez", "diego.sanchez@mail.com", "pass987", 'M', "6666", Enums.TipoNivelDeJuego.AVANZADO, Enums.TipoDeporte.BASQUET, new Zona("Rosario", "Santa Fe").toDTO());
        UsuarioDTO user7 = new UsuarioDTO("Elena", "Vargas", "elena.vargas@mail.com", "pass147", 'F', "7777", Enums.TipoNivelDeJuego.PRINCIPIANTE, Enums.TipoDeporte.TENIS, new Zona("Córdoba", "Córdoba").toDTO());
        UsuarioDTO user8 = new UsuarioDTO("Miguel", "Torres", "miguel.torres@mail.com", "pass258", 'M', "8888", Enums.TipoNivelDeJuego.INTERMEDIO, Enums.TipoDeporte.VOLEIBOL, new Zona("Mendoza", "Mendoza").toDTO());
        UsuarioDTO user9 = new UsuarioDTO("Sofía", "Castro", "sofia.castro@mail.com", "pass369", 'F', "9999", Enums.TipoNivelDeJuego.AVANZADO, Enums.TipoDeporte.FUTBOL, new Zona("Buenos Aires", "CABA").toDTO());
        UsuarioDTO user10 = new UsuarioDTO("Andrés", "Herrera", "andres.herrera@mail.com", "pass741", 'M', "1010", Enums.TipoNivelDeJuego.INTERMEDIO, Enums.TipoDeporte.BASQUET, new Zona("Rosario", "Santa Fe").toDTO());

        // Agrego usuarios
        usuarioController.crearUsuario(organizador);
        usuarioController.crearUsuario(jugador);
        usuarioController.crearUsuario(user1);
        usuarioController.crearUsuario(user2);
        usuarioController.crearUsuario(user3);
        usuarioController.crearUsuario(user4);
        usuarioController.crearUsuario(user5);
        usuarioController.crearUsuario(user6);
        usuarioController.crearUsuario(user7);
        usuarioController.crearUsuario(user8);
        usuarioController.crearUsuario(user9);
        usuarioController.crearUsuario(user10);

        //Creo una fecha
        Date fecha = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            fecha = sdf.parse("25/06/2025 20:46");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Creo partido
        PartidoDTO partidoNuevo = new PartidoDTO(Enums.TipoDeporte.FUTBOL, new Zona("Buenos Aires", "CABA"), fecha ,"Av. Siempre Viva 123", organizador, new PorNivelMinimo(), 2, 90.0f, Enums.TipoNivelDeJuego.PRINCIPIANTE);
        partidoController.crearPartido(partidoNuevo);

        // Agrego Jugadores al partido creado
        partidoController.agregarJugador(partidoNuevo, jugador);   
        partidoController.agregarJugador(partidoNuevo, user2);

        // Confirmo participacion de Jugadores
        partidoController.confirmarPartipacion(partidoNuevo, jugador);
        partidoController.confirmarPartipacion(partidoNuevo, user2);

    }
}
