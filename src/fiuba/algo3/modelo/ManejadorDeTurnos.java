package fiuba.algo3.modelo;

import java.util.LinkedList;

/**
 * Created by anthony on 10/11/2015.
 */
public class ManejadorDeTurnos {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador turnoActual;

    public ManejadorDeTurnos() {
        this.turnoActual = jugador1;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    // aca me falta a logica para manejar los turnos
    public Jugador jugadorContrario(Jugador jugador) {
        if (jugador1.getNombre() == "jugador1")
            return jugador;
        else
            return jugador1;
    }

    public Jugador darJugadorQueInicia() {
        return jugador1;
    }
}
