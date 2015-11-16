package fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

/**
 * Created by anthony on 10/11/2015.
 */
public class AceptaEnvido extends Jugada {
    private Jugador jugadorQueLoCanto;

    public AceptaEnvido(Jugador jugador) {
        this.jugadorQueLoCanto = jugador;

    }

    public void resolverEnMesa(ManejadorDeJugadas unManejadorDeJugadas){
        unManejadorDeJugadas.resolverAceptaEnvido(this);
    }


    public Jugador jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
}
