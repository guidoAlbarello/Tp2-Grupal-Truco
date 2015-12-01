package fiuba.algo3.Modelo.EstadosDeJuego;


import fiuba.algo3.Modelo.ModeladoDeCarta.CartaJugada;
import fiuba.algo3.Modelo.Excepciones.NoSeCantoFlorError;
import fiuba.algo3.Modelo.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Modelo.Juego.Juego;
import fiuba.algo3.Modelo.Excepciones.NoSeResuelveEnvidoError;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoEnvido implements EstadoDeJuego {
    private Juego juego;
    private int puntosDeEstado = 2;

    public EstadoEnvido(Juego juego) {
        this.juego = juego;
        this.juego.sumarPuntosEnvidoNoQuerido();
        this.juego.sumarPuntosEnvidoSiQuerido(this.puntosDeEstado);
    }

    @Override
    public void flor() {
        this.juego.setEstadoDeJuego(new EstadoFlor(juego));
    }

    @Override
    public void contraFlor() {
        throw new NoSeCantoFlorError();
    }

    @Override
    public void contraFlorAlResto() {
        throw new NoSeCantoFlorError();
    }

    @Override
    public void envido() {
        Jugador jugadorActual = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        this.juego.setEstadoDeJuego(new EstadoEnvidoEnvido(this.juego));
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getJugadorQueCantoEnvido());
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(jugadorActual);
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
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void retruco() {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void valeCuatro() {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void quiero() {
        juego.siSeQuizoEnvido();
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
    public void irseAlMaso() {throw new NoSeResuelveEnvidoError();
    }

    @Override
    public int puntosSiSeQuiere() {
        return this.puntosDeEstado;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoEnvido();
    }
}
