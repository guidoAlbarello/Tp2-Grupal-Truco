package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;

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
        this.respuestasPosibles.add(Quiero.class);
        this.respuestasPosibles.add(NoQuiero.class);
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
}
