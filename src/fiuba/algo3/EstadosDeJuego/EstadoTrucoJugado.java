package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 23/11/2015.
 */
public class EstadoTrucoJugado implements EstadoDeJuego {
    private Juego juego;
    public EstadoTrucoJugado(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void envido() {

    }

    @Override
    public void realEnvido() {

    }

    @Override
    public void faltaEnvido() {

    }

    @Override
    public void truco() {

    }

    @Override
    public void retruco() {

    }

    @Override
    public void valeCuatro() {

    }

    @Override
    public void quiero() {

    }

    @Override
    public void noQuiero() {

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