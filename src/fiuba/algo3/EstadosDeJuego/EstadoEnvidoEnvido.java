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
        //resolver buscar el que tenga mas tantos y sumarle 2 puntos
    }

    @Override
    public void noQuiero() {
        //resolver que no se acepte - sumarle 1 punto al que canto el envido
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public int puntos() {
        return 1;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveEnvidoEnvidoError();
    }
}
