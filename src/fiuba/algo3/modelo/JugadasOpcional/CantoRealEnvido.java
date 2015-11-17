package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krion on 16/11/2015.
 */
public class CantoRealEnvido extends CantosEnvido {
    private List<Class> respuestasPosibles;

    public CantoRealEnvido(Jugador unJugador) {
        this.setValorDeJugada(3);
        this.setJugadorQueLoCanto(unJugador);
        this.respuestasPosibles = new ArrayList<>();
        this.respuestasPosibles.add(QuieroFlor.class);
        this.respuestasPosibles.add(NoQuieroFlor.class);
        this.respuestasPosibles.add(CantoFaltaEnvido.class);
        this.respuestasPosibles.add(CantoFlor.class);
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
