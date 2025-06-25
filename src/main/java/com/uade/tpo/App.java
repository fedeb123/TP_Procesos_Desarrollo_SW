package com.uade.tpo;


import com.uade.tpo.Emparejamiento.PorNivelMaximo;
import com.uade.tpo.Models.Enums;
import com.uade.tpo.Models.Partido;
import com.uade.tpo.Models.Usuario;
import com.uade.tpo.Models.Zona;
import com.uade.tpo.Restriccion.PorNivel;
import com.uade.tpo.Services.NotificacionService;
import com.uade.tpo.Services.impl.PartidoService;
import com.uade.tpo.Services.impl.UsuarioService;
import com.uade.tpo.storage.StorageAdapter;
import com.uade.tpo.storage.fake.FakeSQL;

import java.util.ArrayList;
import java.util.Date;

public class App
{
    public static void main( String[] args )
    {
        // Instanciar dependencias
        var fakeSQL = FakeSQL.getInstance();
        var storage = new StorageAdapter(fakeSQL);
        var notificacionService = new NotificacionService();
        var usuarioService = new UsuarioService(storage);
        var partidoService = new PartidoService(storage, notificacionService, usuarioService);

        // Creo 2 usuarios
        Usuario organizador = new Usuario(
                "Juan", "Pérez", 'M', "12345678", "juan@mail.com", "1234",
                Enums.TipoDeporte.FUTBOL, Enums.TipoNivelDeJuego.INTERMEDIO,
                new Zona("Buenos Aires", "CABA"), new PorNivelMaximo()
        );

        Usuario jugador = new Usuario(
                "Pedro", "Gómez", 'M', "87654321", "pedro@mail.com", "5678",
                Enums.TipoDeporte.FUTBOL, Enums.TipoNivelDeJuego.PRINCIPIANTE,
                new Zona("Buenos Aires", "CABA"), new PorNivelMaximo()
        );


        // Agrego usuarios
        storage.crearUsuario(organizador);
        storage.crearUsuario(jugador);


        // Creo partido
        Partido partido = new Partido(
                Enums.TipoDeporte.FUTBOL,
                new Zona("Buenos Aires", "CABA"),
                new Date(),
                "Av. Siempreviva 742",
                organizador,
                new ArrayList<>(), // restricciones
                new PorNivelMaximo(),
                2, // cantidadJugadoresRequerida
                90f,
                notificacionService,
                Enums.TipoNivelDeJuego.AVANZADO
        );


        System.out.println("nice");
    }
}
