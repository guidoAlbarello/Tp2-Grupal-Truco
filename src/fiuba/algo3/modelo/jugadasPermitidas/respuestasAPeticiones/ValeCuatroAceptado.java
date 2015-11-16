package fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

/**
 * Created by Fechee on 14/11/2015.
 */

public class ValeCuatroAceptado extends Jugada {
        public ValeCuatroAceptado(Jugador jugador) {
            super();
        }


        public Jugador jugadorQueCanto() {
            return null;
        }

        @Override
        public void resolverEnMesa(ManejadorDeJugadas unManejadorDeJugadas) {
            unManejadorDeJugadas.getMesaDeJuego().setPuntosEnJuego(4);
        }
}

