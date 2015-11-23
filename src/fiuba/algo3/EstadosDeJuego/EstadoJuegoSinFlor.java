package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Excepciones.JuegoSinFlorError;
import fiuba.algo3.Excepciones.JugadaInvalidaPrimeraManoError;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 23/11/2015.
 */
public class EstadoJuegoSinFlor implements EstadoDeJuego{
    private Juego juego;

    public EstadoJuegoSinFlor(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void flor() {
       throw new JuegoSinFlorError();
    }

    @Override
    public void contraFlor() {
        throw new JuegoSinFlorError();
    }

    @Override
    public void contraFlorAlResto() {
        throw new JuegoSinFlorError();
    }

    @Override
    public void envido() {

        this.juego.setEstadoDeJuego(new EstadoEnvido(this.juego));
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
        this.juego.setEstadoDeJuego(new EstadoTruco(juego));
    }

    @Override
    public void retruco() {
        throw new JugadaInvalidaPrimeraManoError();
    }

    @Override
    public void valeCuatro() {
        throw new JugadaInvalidaPrimeraManoError();
    }

    @Override
    public void quiero() {
        throw new JugadaInvalidaPrimeraManoError();
    }

    @Override
    public void noQuiero() {throw new JugadaInvalidaPrimeraManoError();
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

        // aca tendria q pasar el turno pero no kiero tocarr eso por q todavia no tengo a  manejador de turnos
    }
}
