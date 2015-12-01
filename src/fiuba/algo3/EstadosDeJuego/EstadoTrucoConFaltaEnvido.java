package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 01/12/2015.
 */
public class EstadoTrucoConFaltaEnvido implements EstadoDeJuego {
    private Juego juego;
    public EstadoTrucoConFaltaEnvido(Juego juego){
        this.juego = juego;
        this.juego.sumarPuntosEnvidoNoQuerido();
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
        throw new RuntimeException();
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
        juego.siSeQuizoFaltaEnvido();
        juego.setEstadoDeJuego(new EstadoSinEnvido(juego));
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
