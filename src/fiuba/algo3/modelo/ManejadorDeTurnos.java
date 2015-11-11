package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class ManejadorDeTurnos {

    private JugadorEnJuego jugador1;
    private JugadorEnJuego jugador2;
    private JugadorEnJuego turnoActual;

    public ManejadorDeTurnos(JugadorEnJuego jugador1, JugadorEnJuego jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoActual = jugador1;
    }

    public JugadorEnJuego getJugador1() {
        return jugador1;
    }

    public JugadorEnJuego getJugador2() {
        return jugador2;
    }

    // aca me falta a logica para manejar los turnos
    public JugadorEnJuego jugadorContrario(JugadorEnJuego jugador) {
        if (jugador1.nombre() == "jugador1")
            return jugador2;
        else
            return jugador1;
    }

    public JugadorEnJuego darJugadorQueInicia() {
        return jugador1;
    }
}
