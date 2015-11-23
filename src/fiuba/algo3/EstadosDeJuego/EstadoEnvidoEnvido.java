package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Excepciones.NoSeResuelveEnvidoEnvidoError;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 19/11/2015.
 */
public class EstadoEnvidoEnvido implements EstadoDeJuego{
    private Juego juego;
    public EstadoEnvidoEnvido(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void flor() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void contraFlor() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void contraFlorAlResto() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void envido() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void realEnvido() {
        this.juego.setEstadoDeJuego(new EstadoRealEnvido(juego));
    }

    @Override
    public void faltaEnvido() {
        this.juego.setEstadoDeJuego(new EstadoFaltaEnvido(juego));
    }

    @Override
    public void truco() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void retruco() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void valeCuatro() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void quiero() {
        this.juego.siSeQuizoEnvido();

        juego.setEstadoDeJuego(new EstadoSinEnvido(juego));
    }

    @Override
    public void noQuiero() {
        juego.noSeQuizoEnvido();    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public int puntosDeEstado() {
        return 3;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveEnvidoEnvidoError();
    }
}
