package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.manejoDeJugadores.Jugador;

/**
 * Created by anthony on 19/11/2015.
 */
public class CartaJugada {
    private Carta carta;
    private Jugador jugador;
    public CartaJugada(Carta carta, Jugador jugador) {
        this.jugador = jugador;
        this.carta = carta;
    }
}
