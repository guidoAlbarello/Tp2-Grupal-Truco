package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.JugadaInvalidaPrimeraManoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoPrimeraMano implements EstadoDeJuego {
    private Juego juego;

    public EstadoPrimeraMano(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void envido() {
        this.juego.cambiarEstadoEnvido();
    }

    @Override
    public void realEnvido() {
        this.juego.cambiarEstadoRealEnvido();
    }

    @Override
    public void faltaEnvido() {
        this.juego.cambiarEstadoFaltaEnvido();
    }

    @Override
    public void truco() {
        this.juego.cambiarEstadoTruco();
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
    public int puntos() {
        return 0;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        this.juego.mesaDelJuego().agregarCartaALsitaDeCartasJugadas(cartaJugada);

        // aca tendria q pasar el turno pero no kiero tocarr eso por q todavia no tengo a  manejador de turnos
    }
}
