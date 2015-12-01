package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Excepciones.NoSeResuelveFaltaEnvidoError;
import fiuba.algo3.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoFaltaEnvido implements EstadoDeJuego {
    private Juego juego;
    public EstadoFaltaEnvido(Juego juego) {
        this.juego = juego;
        this.juego.sumarPuntosEnvidoNoQuerido();
    }

    @Override
    public void flor() {throw new NoSeResuelveFaltaEnvidoError();}

    @Override
    public void contraFlor() {throw new NoSeResuelveFaltaEnvidoError();}

    @Override
    public void contraFlorAlResto() {throw new NoSeResuelveFaltaEnvidoError();}

    @Override
    public void envido() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void realEnvido() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void faltaEnvido() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void truco() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void retruco() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void valeCuatro() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void quiero() {
        juego.siSeQuizoFaltaEnvido();
        juego.setEstadoDeJuego(new EstadoSinEnvido(juego));
        juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoEnvido());
    }

    @Override
    public void noQuiero() {
        juego.setEstadoDeJuego(new EstadoSinEnvido(juego));
        juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoEnvido());
        juego.noSeQuizoEnvido();
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public int puntosSiSeQuiere() {
        return 3;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoFaltaEnvido();
    }
}
