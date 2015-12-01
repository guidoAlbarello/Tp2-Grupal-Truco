package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.NoSeResuelveTrucoError;
import fiuba.algo3.manejoDeJugadores.Jugador;

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
    public void flor() {

    }

    @Override
    public void contraFlor() {

    }

    @Override
    public void contraFlorAlResto() {

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
        this.juego.setEstadoDeJuego(new EstadoRealEnvido(this.juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void faltaEnvido() {
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoFaltaEnvido(this.juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void truco() {throw new NoSeResuelveTrucoError();
    }

    @Override
    public void retruco() {
        Jugador jugadorTurnoActual = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        juego.manejadorDeTurnos.setPrimeroQueCantoTruco(jugadorTurnoActual);
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getUltimoQueJugoTruco());
        juego.manejadorDeTurnos.setUltimoQueJugoTruco(jugadorTurnoActual);
        this.juego.setEstadoDeJuego(new EstadoRetruco(juego));
    }

    @Override
    public void valeCuatro() {throw new NoSeResuelveTrucoError();
    }

    @Override
    public void quiero() {
        this.juego.setPuntosDeTruco(this.puntosSiSeQuiere());
        juego.setEstadoDeJuego(new EstadoTrucoAceptado(juego));
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
    }

    @Override
    public void noQuiero() {
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
        this.juego.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().sumarPuntos(this.puntosDeEstado - 1);
        this.juego.manejadorDeTurnos.reiniciarRonda();
    }

    @Override
    public void irseAlMaso() {
        throw new NoSeResuelveTrucoError();
    }

    @Override
    public int puntosSiSeQuiere() {
        return this.puntosDeEstado;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveTrucoError();
    }

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoTruco();
    }
}