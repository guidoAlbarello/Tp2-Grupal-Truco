package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krion on 16/11/2015.
 */
public class NoQuiero extends DecisionesFinalesDelCanto{
    private List<Class> respuestasPosibles;

    public NoQuiero(Jugador unJugador) {
        this.setValorDeJugada(-1);
        this.setJugadorQueLoCanto(unJugador);
        this.respuestasPosibles = new ArrayList<>();
    }

    @Override
    public List<Class> getJugadasPosibles() {
        return this.respuestasPosibles;
    }

    @Override
    public boolean esUnaJugadaValida(Jugada unaJugada) {
        return false;
    }
}
