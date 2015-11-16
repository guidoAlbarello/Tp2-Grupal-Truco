package fiuba.algo3.modelo.jugadasPermitidas.peticiones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

/**
 * Created by anthony on 10/11/2015.
 */
public class EnvidoCantado extends Jugada {
    private Jugador jugadorQueLoCanto;
    public EnvidoCantado(Jugador jugador) {
        jugadorQueLoCanto = jugador;
    }

    public void resolverEnMesa(ManejadorDeJugadas unManejadorDeJugadas){
        unManejadorDeJugadas.resolverEnvido(this);
    }



}
