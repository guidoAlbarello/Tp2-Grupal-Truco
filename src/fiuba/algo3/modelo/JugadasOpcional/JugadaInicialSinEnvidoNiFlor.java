package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.jugadasPosibles.SeJuegaConFlor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krion on 17/11/2015.
 */
public class JugadaInicialSinEnvidoNiFlor extends JugadaInicial {
    public JugadaInicialSinEnvidoNiFlor(Jugador unJugador, SeJuegaConFlor seJuegaConFlor) {
        super(unJugador, seJuegaConFlor);
        List<Class> jugadasPosibles = new ArrayList<>();
        jugadasPosibles.add(CantoTruco.class);
        this.setRespuestasPosibles(jugadasPosibles);
    }
}
