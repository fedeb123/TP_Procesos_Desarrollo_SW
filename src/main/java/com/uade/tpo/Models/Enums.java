package com.uade.tpo.models;

public class Enums {

    public enum TipoEstadoPartido {
        NECESITA_JUGADORES,
        PARTIDO_ARMADO,
        CONFIRMADO,
        EN_JUEGO,
        FINALIZADO,
        CANCELADO
    }

    public enum TipoNivelDeJuego {
        PRINCIPIANTE,
        INTERMEDIO,
        AVANZADO
    }

    public enum TipoDeporte {
        FUTBOL,
        HOCKEY,
        HANDBALL,
        BASQUET
    }
}
