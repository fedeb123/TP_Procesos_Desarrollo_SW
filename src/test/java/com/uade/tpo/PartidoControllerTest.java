package com.uade.tpo;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.uade.tpo.controllers.PartidoController;
import com.uade.tpo.controllers.UsuarioController;
import com.uade.tpo.jobs.PartidoJob;
import com.uade.tpo.models.Enums;
import com.uade.tpo.models.Zona;
import com.uade.tpo.models.dto.PartidoDTO;
import com.uade.tpo.models.dto.UsuarioDTO;
import com.uade.tpo.emparejamiento.PorNivelMinimo;


class FlujoCompletoPartidoTest {


    private static void resetSingleton(Class<?> clazz, String fieldName) throws Exception {
        Field f = clazz.getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(null, null);
    }

    @AfterEach
    void tearDown() throws Exception {
        resetSingleton(UsuarioController.class, "instance");
        resetSingleton(PartidoController.class, "instance");
    }


    @Test
    @DisplayName("Flujo completo: alta usuarios + partido + confirmación")
    void flujoCompletoPartido() throws Exception {

        var partidoJob       = new PartidoJob();   // si tu Job levanta hilos en background, considera detenerlo luego
        var usuarioController = UsuarioController.getInstance();
        var partidoController = PartidoController.getInstance();

        partidoJob.start();

        UsuarioDTO organizador = new UsuarioDTO("Juan", "Pérez", "abc@gmail.com", "12345678", 'M',
                "1234", Enums.TipoNivelDeJuego.INTERMEDIO, Enums.TipoDeporte.FUTBOL,
                new Zona("Buenos Aires", "CABA").toDTO(), new ArrayList<>());

        UsuarioDTO jugador = new UsuarioDTO("Pedro", "Gómez", "pedro@mail.com", "5678", 'M',
                "87654321", Enums.TipoNivelDeJuego.PRINCIPIANTE, Enums.TipoDeporte.FUTBOL,
                new Zona("Buenos Aires", "CABA").toDTO(), new ArrayList<>());

        UsuarioDTO user2 = new UsuarioDTO("Carlos", "González", "carlos.gonzalez@mail.com", "pass456", 'M',
                "2222", Enums.TipoNivelDeJuego.INTERMEDIO, Enums.TipoDeporte.FUTBOL,
                new Zona("Rosario", "Santa Fe").toDTO(), new ArrayList<>());

        usuarioController.crearUsuario(organizador);
        usuarioController.crearUsuario(jugador);
        usuarioController.crearUsuario(user2);

        Date fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("26/06/2025 01:47");

        PartidoDTO partidoNuevo = new PartidoDTO(
                Enums.TipoDeporte.FUTBOL,
                new Zona("Buenos Aires", "CABA").toDTO(),
                fecha,
                "Av. Siempre Viva 123",
                organizador,
                new PorNivelMinimo(),
                2,
                1,
                Enums.TipoNivelDeJuego.PRINCIPIANTE,
                new ArrayList<>());

        partidoController.crearPartido(partidoNuevo);

        partidoController.agregarJugador(partidoNuevo, jugador);
        partidoController.agregarJugador(partidoNuevo, user2);

        partidoController.confirmarPartipacion(partidoNuevo, jugador);
        partidoController.confirmarPartipacion(partidoNuevo, user2);

        PartidoDTO partidoBuscado = partidoController.buscarPartido("Av. Siempre Viva 123", fecha);
        assertNotNull(partidoBuscado, "El partido debería existir en el repositorio");

        assertEquals(organizador.getCorreo(), partidoBuscado.getOrganizadorPartido().getCorreo());

        ArrayList<PartidoDTO> historialJugador = partidoController.getHistorialPartidos(jugador);
        boolean enHistorial = historialJugador.stream()
                .anyMatch(p -> "Av. Siempre Viva 123".equals(p.getDireccion()));
        assertTrue(enHistorial,
                "El partido recién jugado debería aparecer en el historial del jugador");

    }
}