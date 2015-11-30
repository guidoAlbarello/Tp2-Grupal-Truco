package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Excepciones.NoSeResuelveEnvidoEnvidoError;
import fiuba.algo3.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Juego;
import fiuba.algo3.manejoDeJugadores.Jugador;

/**
 * Created by anthony on 19/11/2015.
 */
public class EstadoEnvidoEnvido implements EstadoDeJuego{
    private Juego juego;
    private int puntodDeEstado = 4;
    public EstadoEnvidoEnvido(Juego juego) {
        this.juego = juego;
        this.juego.sumarPuntosEnvidoNoQuerido();
        this.juego.sumarPuntosEnvidoSiQuerido(2);//suma 2 puntos
    }

    @Override
    public void flor() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void contraFlor() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void contraFlorAlResto() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void envido() {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void realEnvido() {
        Jugador jugadorActual = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        this.juego.setEstadoDeJuego(new EstadoRealEnvido(this.juego));
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getJugadorQueCantoEnvido());
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(jugadorActual);
    }

    @Override
    public void faltaEnvido() {
        Jugador jugadorActual = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        this.juego.setEstadoDeJuego(new EstadoFaltaEnvido(this.juego));
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getJugadorQueCantoEnvido());
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(jugadorActual);
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
        this.juego.siSeQuizoEnvido();
        juego.setEstadoDeJuego(new EstadoSinEnvido(juego));
        juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoEnvido());
    }

    @Override
    public void noQuiero() {
        juego.setEstadoDeJuego(new EstadoSinEnvido(juego));
        juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoEnvido());
        juego.noSeQuizoEnvido();
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public int puntosSiSeQuiere() {
        return this.puntodDeEstado;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveEnvidoEnvidoError();
    }

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoEnvidoEnvido();
    }
}
