package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krion on 16/11/2015.
 */
public class CantoContraFlorAlResto extends CantosFlor{
    private List<Class> respuestasPosibles;

    public CantoContraFlorAlResto(Jugador unJugador) {
        this.setValorDeJugada(100);
        this.setJugadorQueLoCanto(unJugador);
        this.respuestasPosibles = new ArrayList<>();
        this.respuestasPosibles.add(Quiero.class);
        this.respuestasPosibles.add(NoQuiero.class);
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
