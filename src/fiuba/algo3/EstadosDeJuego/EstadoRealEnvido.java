package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.NoSeResuelveRealEnvidoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoRealEnvido implements EstadoDeJuego {
    protected Juego juego;

    public EstadoRealEnvido(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void envido() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void realEnvido() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void faltaEnvido() {
        this.juego.cambiarEstadoFaltaEnvido();
    }

    @Override
    public void truco() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void retruco() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void valeCuatro() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void quiero() {
        // resolver el quiero
    }

    @Override
    public void noQuiero() {
        //resolver el no quiero
    }

    @Override
    public void irseAlMaso() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public int puntos() {
        return 2;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveRealEnvidoError();
    }
}