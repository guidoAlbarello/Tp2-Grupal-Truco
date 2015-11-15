package fiuba.algo3.modelo.jugadasPosibles.respuestasAPeticiones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPosibles.Jugada;

/**
 * Created by anthony on 12/11/2015.
 */
public class NoAceptaEnvido extends Jugada {
    private Jugador jugadorQueLoCanto;
    public NoAceptaEnvido(Jugador jugador) {
        this.jugadorQueLoCanto = jugador;

    }
    @Override
    public void resolverEnMesa(Mesa mesa) {
        mesa.resolverNoAceptaEnvido(this);
    }


    public Jugador jugadorQueCanto() {
        return jugadorQueLoCanto;
    }
}
