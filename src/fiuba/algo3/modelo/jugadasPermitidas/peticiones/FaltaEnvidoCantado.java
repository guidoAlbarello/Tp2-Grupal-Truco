package fiuba.algo3.modelo.jugadasPermitidas.peticiones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

/**
 * Created by anthony on 11/11/2015.
 */
public class FaltaEnvidoCantado extends Jugada {
    public FaltaEnvidoCantado(Jugador jugador) {
        super();
    }


    public Jugador jugadorQueCanto() {
        return null;
    }

    @Override
    public void resolverEnMesa(ManejadorDeJugadas unManejadorDeJugadas){

    }
}