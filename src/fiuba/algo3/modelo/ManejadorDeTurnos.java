package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class ManejadorDeTurnos {

    private JugadorJugando jugador1;
    private JugadorJugando jugador2;
    private JugadorJugando turnoActual;

    public ManejadorDeTurnos(JugadorJugando jugador1, JugadorJugando jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoActual = jugador1;
    }

    public JugadorJugando getJugador1() {
        return jugador1;
    }

    public JugadorJugando getJugador2() {
        return jugador2;
    }

    // aca me falta a logica para manejar los turnos
    public JugadorJugando jugadorContrario(JugadorJugando jugador) {
        if (jugador1.nombre() == "jugador1")
            return jugador2;
        else
            return jugador1;
    }

    public JugadorJugando darJugadorQueInicia() {
        return jugador1;
    }
}
