package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Carta;
import fiuba.algo3.modelo.JugadorEnRonda;

import java.util.List;

/**
 * Created by anthony on 10/11/2015.
 */
public class CartaJugada extends Jugada {
    public JugadorEnRonda jugadorQueLaJugo;
    public Carta carta;

    public CartaJugada(JugadorEnRonda jugador, Carta carta) {
        jugadorQueLaJugo = jugador;
        this.carta = carta;
    }

    public JugadorEnRonda jugadorQueCanto() {
        return jugadorQueLaJugo;
    }

    @Override
    public void resolverEnManejadorDeJugadas(ManejadorDeJugadas unManejadorDeJugadas) {

    }

    @Override
    public List<Class> getJugadasPosibles() {
        return null;
    }

    @Override
    public boolean esUnaJugadaValida(Jugada unaJugada) {
        return false;
    }
}
