package fiuba.algo3.Modelo.EstadosDeJuego;

import fiuba.algo3.Modelo.ModeladoDeCarta.CartaJugada;
import fiuba.algo3.Modelo.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Modelo.Juego.Juego;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;

/**
 * Created by anthony on 01/12/2015.
 */
public class EstadoTrucoConRealEnvido implements EstadoDeJuego {
    private Juego juego;
    private int puntosDeEstado = 3;
    public EstadoTrucoConRealEnvido(Juego juego){
        this.juego = juego;
        this.juego.sumarPuntosEnvidoNoQuerido();
        this.juego.sumarPuntosEnvidoSiQuerido(this.puntosDeEstado);
    }
    @Override
    public void flor() {
        throw new RuntimeException();
    }

    @Override
    public void contraFlor() {
        throw new RuntimeException();
    }

    @Override
    public void contraFlorAlResto() {
        throw new RuntimeException();
    }

    @Override
    public void envido() {
        throw new RuntimeException();
    }

    @Override
    public void realEnvido() {
        throw new RuntimeException();
    }

    @Override
    public void faltaEnvido() {
        Jugador jugadorActual = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        this.juego.setEstadoDeJuego(new EstadoTrucoConFaltaEnvido(this.juego));
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getJugadorQueCantoEnvido());
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(jugadorActual);
    }

    @Override
    public void truco() {
        throw new RuntimeException();
    }

    @Override
    public void retruco() {
        throw new RuntimeException();
    }

    @Override
    public void valeCuatro() {
        throw new RuntimeException();
    }

    @Override
    public void quiero() {
        juego.siSeQuizoEnvido();
        juego.setEstadoDeJuego(new EstadoSinEnvido(juego));//cambiar esto
        juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
        juego.manejadorDeTurnos.setPrimeroQueCantoTruco(null);
    }

    @Override
    public void noQuiero() {
        juego.setEstadoDeJuego(new EstadoSinEnvido(juego));//cambiar esto
        juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoEnvido());
        juego.noSeQuizoEnvido();
        juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
        juego.manejadorDeTurnos.setPrimeroQueCantoTruco(null);
    }

    @Override
    public void irseAlMaso() {
        throw new RuntimeException();
    }

    @Override
    public int puntosSiSeQuiere() {
        return 0;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new RuntimeException();
    }

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoTrucoSinEnvido();
    }
}
