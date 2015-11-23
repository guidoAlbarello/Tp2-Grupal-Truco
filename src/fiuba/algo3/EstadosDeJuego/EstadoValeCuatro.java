package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Excepciones.NoSeResuelvValeCuatroError;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoValeCuatro implements EstadoDeJuego {
    private Juego juego;
    private int puntosDeEstado;

    public EstadoValeCuatro(Juego juego) {
        this.juego = juego;
        this.puntosDeEstado = 4;
    }
    @Override
    public void envido() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void realEnvido() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void faltaEnvido() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void truco() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void retruco() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void valeCuatro() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void quiero() {            this.juego.siSeQuizoTruco();
        this.juego.setPuntosDeTruco(this.puntosDeEstado());
        juego.setEstadoDeJuego(new EstadoTrucoJugado(juego));}

    @Override
    public void noQuiero() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void irseAlMaso() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public int puntosDeEstado() {
        return this.puntosDeEstado;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {

        this.juego.agregarCartaAMesa(cartaJugada);
    }
}