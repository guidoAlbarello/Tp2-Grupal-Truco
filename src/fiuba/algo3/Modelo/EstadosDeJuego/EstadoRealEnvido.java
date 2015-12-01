package fiuba.algo3.Modelo.EstadosDeJuego;

import fiuba.algo3.Modelo.ModeladoDeCarta.CartaJugada;
import fiuba.algo3.Modelo.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Modelo.Juego.Juego;
import fiuba.algo3.Modelo.Excepciones.NoSeResuelveRealEnvidoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoRealEnvido implements EstadoDeJuego {
    protected Juego juego;
    private int puntosDeEstado = 3;

    public EstadoRealEnvido(Juego juego) {
        this.juego = juego;
        this.juego.sumarPuntosEnvidoNoQuerido();
        this.juego.sumarPuntosEnvidoSiQuerido(this.puntosDeEstado);
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
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void realEnvido() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void faltaEnvido() {
        this.juego.setEstadoDeJuego(new EstadoFaltaEnvido(juego));
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
    }

    @Override
    public void truco() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void retruco() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void valeCuatro() {
        throw new NoSeResuelveRealEnvidoError();
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
    public void irseAlMaso() {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public int puntosSiSeQuiere() {
        return puntosDeEstado;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveRealEnvidoError();
    }

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoRealEnvido();
    }
}