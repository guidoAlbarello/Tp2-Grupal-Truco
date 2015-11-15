package fiuba.algo3.modelo.manejadoresDeSituaciones;

import fiuba.algo3.modelo.JugadorEnRonda;

import java.util.LinkedList;

/**
 * Created by anthony on 10/11/2015.
 */
public class ManejadorDeTurnos {

    private JugadorEnRonda jugador1;
    private JugadorEnRonda jugador2;
    private JugadorEnRonda jugadorMano;
    private JugadorEnRonda jugadorTurnoEnMano;

    public ManejadorDeTurnos(JugadorEnRonda jugador1, JugadorEnRonda jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorMano = jugador1;
        this.jugadorTurnoEnMano = this.jugadorMano;

    }


    // aca me falta a logica para manejar los turnos
    public JugadorEnRonda getJugadorTurnoEnMano() {
        return this.jugadorTurnoEnMano;
    }
    public void pasarTurnoEnMano(){
        if (jugadorTurnoEnMano.getJugador().getNombre().equals("jugador1"))
            jugadorTurnoEnMano = jugador2;
        else
            jugadorTurnoEnMano = jugador1;
    }
    public void pasarJugadorMano(){
        if (jugadorMano.getJugador().getNombre().equals("jugador1"))
            jugadorMano = jugador2;
        else
            jugadorMano = jugador1;
    }
    public JugadorEnRonda getJugadorMano() {
        return this.jugadorMano;
    }


    public void setJugadorMano(JugadorEnRonda jugadorMano) {
    }

}
