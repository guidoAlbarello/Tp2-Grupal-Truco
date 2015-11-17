package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krion on 17/11/2015.
 */
public class NoQuieroFlor extends DecisionesFinalesDelCanto{
    private List<Class> respuestasPosibles;

    public NoQuieroFlor(Jugador unJugador) {
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

    @Override
    public void resolverEnManejadorDeJugadas(ManejadorDeJugadas manejadorDeJugadas) {
        manejadorDeJugadas.resolverJugadaTipo(this);
    }
}
