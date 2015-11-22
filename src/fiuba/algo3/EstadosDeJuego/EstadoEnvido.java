package fiuba.algo3.EstadosDeJuego;


import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.NoSeResuelveEnvidoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoEnvido implements EstadoDeJuego {
    private Juego juego;

    public EstadoEnvido(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void envido() {
        this.juego.setEstadoDeJuego(new EstadoEnvidoEnvido(this.juego));
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
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void retruco() {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void valeCuatro() {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void quiero() {
        //resolver buscar el que tenga mas tantos y sumarle 2 puntos
    }

    @Override
    public void noQuiero() {
        juego.noSeQuizoEnvido();
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveEnvidoError();
    }

    @Override
    public int puntos() {
        return 1;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveEnvidoError();
    }
}
