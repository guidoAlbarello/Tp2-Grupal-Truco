package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krion on 16/11/2015.
 */
public class CantoFaltaEnvido extends CantosEnvido {
    private List<Class> respuestasPosibles;

    public CantoFaltaEnvido(Jugador unJugador) {
        this.setValorDeJugada(100);
        this.setJugadorQueLoCanto(unJugador);
        this.respuestasPosibles = new ArrayList<>();
        this.respuestasPosibles.add(QuieroEnvido.class);
        this.respuestasPosibles.add(NoQuieroEnvido.class);
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
