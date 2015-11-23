package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 22/11/2015.
 */
public class EstadoSinEnvido implements EstadoDeJuego {
    private Juego juego;
    public EstadoSinEnvido(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void envido() {
        throw new YaSeJugoEnvidoError();
    }

    @Override
    public void realEnvido() {
        throw new YaSeJugoEnvidoError();
    }

    @Override
    public void faltaEnvido() {
        throw new YaSeJugoEnvidoError();
    }

    @Override
    public void truco() {
        this.juego.setEstadoDeJuego(new EstadoTruco(juego));
    }

    @Override
    public void retruco() {
        throw new NoSeJugoTruco();
    }

    @Override
    public void valeCuatro() {
        throw new NoSeJugoTruco();
    }

    @Override
    public void quiero() {
        throw new JugadaNoValidaError();
    }

    @Override
    public void noQuiero() {
        throw new JugadaNoValidaError();
    }

    @Override
    public void irseAlMaso() {

    }

    @Override
    public int puntosDeEstado() {
        return 0;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {

        this.juego.agregarCartaAMesa(cartaJugada);
    }
}
