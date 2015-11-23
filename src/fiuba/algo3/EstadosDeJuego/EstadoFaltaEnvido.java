package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Excepciones.NoSeResuelveFaltaEnvidoError;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoFaltaEnvido implements EstadoDeJuego {
    private Juego juego;
    public EstadoFaltaEnvido(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void flor() {

    }

    @Override
    public void contraFlor() {

    }

    @Override
    public void contraFlorAlResto() {

    }

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
        //resolver
    }

    @Override
    public void noQuiero() {
        //resolver
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public int puntosDeEstado() {
        return 3;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveFaltaEnvidoError();
    }
}
