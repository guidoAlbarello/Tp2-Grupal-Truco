package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 25/11/2015.
 */
public class EstadoValeCuatroAceptado implements EstadoDeJuego {
    private Juego juego;
    public EstadoValeCuatroAceptado(Juego juego) {
        this.juego = juego;
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
        throw new RuntimeException();
    }

    @Override
    public void noQuiero() {
        throw new RuntimeException();
    }

    @Override
    public void irseAlMaso() {
        this.juego.manejadorDeTurnos.pasarTurnoActual();
        this.juego.seFueronAlMaso();
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

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoValeCuatroAceptado();
    }
}
