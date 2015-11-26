package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.NoSeResuelveRetrucoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoRetruco implements EstadoDeJuego {
    private Juego juego;
    private int puntosDeEstado;

    public EstadoRetruco(Juego juego) {
        this.juego = juego;this.puntosDeEstado = 3;
    }

    @Override
    public void flor() {

    }

    @Override
    public void contraFlor() {

    }

    @Override
    public void contraFlorAlResto() {

    }

    @Override
    public void envido() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void realEnvido() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void faltaEnvido() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void truco() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void retruco() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void valeCuatro() {this.juego.setEstadoDeJuego(new EstadoValeCuatro(juego));
    }

    @Override
    public void quiero() {
        this.juego.setPuntosDeTruco(this.puntosSiSeQuiere());
        juego.setEstadoDeJuego(new EstadoRetrucoAceptado(juego));
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
    }

    @Override
    public void noQuiero() {
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
        this.juego.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().sumarPuntos(this.puntosDeEstado - 1);
        this.juego.manejadorDeTurnos.reiniciarRonda();
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public int puntosSiSeQuiere() {
        return this.puntosDeEstado;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {

        this.juego.agregarCartaAMesa(cartaJugada);
    }
}
