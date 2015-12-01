package fiuba.algo3.Modelo.ModeladoDeCarta;

import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;

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

    public Carta getCarta() {
        return carta;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
