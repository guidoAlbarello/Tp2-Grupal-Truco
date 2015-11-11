package fiuba.algo3.modelo;

/**
 * Created by anthony on 11/11/2015.
 */
public class FaltaEnvido extends Jugada {
    public FaltaEnvido(JugadorEnJuego jugador) {
        super();
    }

    @Override
    public JugadorEnJuego jugadorQueCanto() {
        return null;
    }

    @Override
    public void resolverEnMesa(Mesa mesa) {

    }
}
