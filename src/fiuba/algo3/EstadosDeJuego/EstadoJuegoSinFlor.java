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
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoEnvido(this.juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void realEnvido() {
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoRealEnvido(juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void faltaEnvido() {
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoFaltaEnvido(juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void truco() {
        this.juego.manejadorDeTurnos.setUltimoQueJugoTruco(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoTruco(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoTruco(juego));
        this.juego.setPuntosDeTruco(this.puntosSiSeQuiere());
        this.juego.manejadorDeTurnos.pasarTurnoActual();
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
    public int puntosSiSeQuiere() {
        return 0;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        this.juego.agregarCartaAMesa(cartaJugada);
        this.juego.manejadorDeTurnos.pasarTurnoCartas();
    }
}
