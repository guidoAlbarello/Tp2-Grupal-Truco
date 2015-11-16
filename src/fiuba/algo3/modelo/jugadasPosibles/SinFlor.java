package fiuba.algo3.modelo.jugadasPosibles;

import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;

/**
 * Created by Krion on 15/11/2015.
 */
public class SinFlor extends SeJuegaConFlor {

    @Override
    protected Jugada getSiHayJugadaFlor() {
        throw new NoSeEstaJugandoConFlorError();
    }
}
