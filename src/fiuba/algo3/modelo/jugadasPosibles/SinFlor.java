package fiuba.algo3.modelo.jugadasPosibles;

import fiuba.algo3.modelo.JugadasOpcional.Jugada;
import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;

/**
 * Created by Krion on 15/11/2015.
 */
public class SinFlor extends SeJuegaConFlor {

    @Override
    public Jugada getSiHayJugadaFlor() {
        throw new NoSeEstaJugandoConFlorError();
    }
}
