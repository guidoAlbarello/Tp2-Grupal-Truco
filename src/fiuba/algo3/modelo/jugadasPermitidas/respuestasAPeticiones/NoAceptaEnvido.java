package fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

/**
 * Created by anthony on 12/11/2015.
 */
public class NoAceptaEnvido extends Jugada {
    private Jugador jugadorQueLoCanto;
    public NoAceptaEnvido(Jugador jugador) {
        this.jugadorQueLoCanto = jugador;

    }
    @Override
    public void resolverEnMesa(ManejadorDeJugadas unManejadorDeJugadas) {
        unManejadorDeJugadas.resolverNoAceptaEnvido(this);
    }


    public Jugador jugadorQueCanto() {
        return jugadorQueLoCanto;
    }
}
