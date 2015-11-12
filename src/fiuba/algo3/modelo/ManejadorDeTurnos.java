package fiuba.algo3.modelo;

import java.util.LinkedList;

/**
 * Created by anthony on 10/11/2015.
 */
public class ManejadorDeTurnos {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorMano;
    private Jugador jugadorTurnoEnMano;

    public ManejadorDeTurnos(Jugador jugador1,Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorMano = jugador1;
        this.jugadorTurnoEnMano = this.jugadorMano;

    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    // aca me falta a logica para manejar los turnos
    public Jugador jugadorTurnoEnMano() {
        return this.jugadorTurnoEnMano;
    }
    public void pasarTurnoEnMano(){
        if (jugadorTurnoEnMano.getNombre().equals("jugador1"))
            jugadorTurnoEnMano = jugador2;
        else
            jugadorTurnoEnMano = jugador1;
    }
    public void pasarJugadorMano(){
        if (jugadorMano.getNombre().equals("jugador1"))
            jugadorMano = jugador2;
        else
            jugadorMano = jugador1;
    }
    public Jugador jugadorMano() {
        return this.jugadorMano;
    }
}
