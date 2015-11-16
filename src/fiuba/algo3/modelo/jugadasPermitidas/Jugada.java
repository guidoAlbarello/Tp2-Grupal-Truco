package fiuba.algo3.modelo.jugadasPermitidas;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

/**
 * Created by anthony on 11/11/2015.
 */
public abstract class Jugada {
    public abstract void resolverEnMesa(ManejadorDeJugadas unManejadorDeJugadas);
}

