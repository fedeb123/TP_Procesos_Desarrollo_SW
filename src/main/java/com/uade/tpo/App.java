package com.uade.tpo;


import java.util.Date;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.controllers.UsuarioController;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;


public class App
{
    public static void main( String[] args )
    {
        // Instanciar dependencias

        var usuarioController = UsuarioController.getInstance();
        var partidoController = PartidoController.getInstance();

        // Creo 2 usuarios
        UsuarioDTO organizador = new UsuarioDTO("Juan", "Pérez", "abc@gmail.com", "12345678", 'M', "1234", Enums.TipoNivelDeJuego.INTERMEDIO, Enums.TipoDeporte.FUTBOL, new Zona("Buenos Aires", "CABA"));

        UsuarioDTO jugador = new UsuarioDTO("Pedro", "Gómez", "pedro@mail.com", "5678", 'M', "87654321", Enums.TipoNivelDeJuego.PRINCIPIANTE, Enums.TipoDeporte.FUTBOL, new Zona("Buenos Aires", "CABA"));


        // Agrego usuarios
        usuarioController.crearUsuario(organizador);
        usuarioController.crearUsuario(jugador);

        // Creo partido
        PartidoDTO partidoNuevo = new PartidoDTO(Enums.TipoDeporte.FUTBOL, new Zona("Buenos Aires", "CABA"), new Date(), "Av. Siempre Viva 123", organizador, null, 11, 90.0f, Enums.TipoNivelDeJuego.INTERMEDIO);
        partidoController.crearPartido(partidoNuevo);
        partidoController.agregarJugador(partidoNuevo, jugador);      


        System.out.println("nice");
    }
}
