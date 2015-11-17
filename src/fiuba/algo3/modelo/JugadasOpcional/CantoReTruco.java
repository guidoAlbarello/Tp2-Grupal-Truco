package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krion on 16/11/2015.
 */
public class CantoReTruco extends CantosTruco {
    private List<Class> respuestasPosibles;

    public CantoReTruco(Jugador unJugador) {
        this.setValorDeJugada(1);
        this.setJugadorQueLoCanto(unJugador);
        this.respuestasPosibles = new ArrayList<>();
        this.respuestasPosibles.add(QuieroTruco.class);
        this.respuestasPosibles.add(NoQuieroTruco.class);
        this.respuestasPosibles.add(CantoValeCuatro.class);
    }

    @Override
    public List<Class> getJugadasPosibles() {
        return this.respuestasPosibles;
    }

    @Override
    public boolean esUnaJugadaValida(Jugada unaJugada) {
        return this.respuestasPosibles.contains(unaJugada.getClass());
    }

    @Override
    public void resolverEnManejadorDeJugadas(ManejadorDeJugadas manejadorDeJugadas) {
        manejadorDeJugadas.resolverJugadaTipo(this);
    }
}
