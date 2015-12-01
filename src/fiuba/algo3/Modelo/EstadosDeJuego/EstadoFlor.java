package fiuba.algo3.Modelo.EstadosDeJuego;

import fiuba.algo3.Modelo.ModeladoDeCarta.CartaJugada;
import fiuba.algo3.Modelo.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Modelo.Juego;

/**
 * Created by anthony on 23/11/2015.
 */
public class EstadoFlor implements EstadoDeJuego {
    private Juego juego;
    public EstadoFlor(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void flor() {throw new RuntimeException();

    }

    @Override
    public void contraFlor() {

    }

    @Override
    public void contraFlorAlResto() {

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
        decisionSegunEstado.elegirJugadaEstadoFlor();
    }
}
