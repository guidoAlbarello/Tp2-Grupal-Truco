package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.NoSeResuelveTrucoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoTruco implements EstadoDeJuego {
    private Juego juego;
    private int puntosDeEstado;

    public EstadoTruco(Juego juego) {
        this.juego = juego;this.puntosDeEstado = 2;
    }
    @Override
    public void envido() {
        this.juego.setEstadoDeJuego(new EstadoTrucoConEnvido(juego));
    }

    @Override
    public void realEnvido() {
        throw new NoSeResuelveTrucoError();/* aca en realidad esto no es correcto por que
        si se puede cantar realEnvido cuando se canto Truco*/
    }

    @Override
    public void faltaEnvido() {
        throw new NoSeResuelveTrucoError();/* aca en realidad esto no es correcto por que
        si se puede cantar faltaEnvido cuando se canto Truco*/
    }

    @Override
    public void truco() {throw new NoSeResuelveTrucoError();
    }

    @Override
    public void retruco() {this.juego.setEstadoDeJuego(new EstadoRetruco(juego));
    }

    @Override
    public void valeCuatro() {throw new NoSeResuelveTrucoError();
    }

    @Override
    public void quiero() {
            this.juego.siSeQuizoTruco();
        this.juego.setPuntosDeTruco(this.puntosDeEstado());
        juego.setEstadoDeJuego(new EstadoTrucoJugado(juego));
    }

    @Override
    public void noQuiero() {
        this.juego.noSeQuizoEnvido();
    }

    @Override
    public void irseAlMaso() {
        throw new NoSeResuelveTrucoError();
    }

    @Override
    public int puntosDeEstado() {
        return this.puntosDeEstado;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveTrucoError();
    }
}