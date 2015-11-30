package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Juego;
import fiuba.algo3.manejoDeJugadores.Jugador;

/**
 * Created by anthony on 24/11/2015.
 */
public class EstadoRetrucoAceptado implements EstadoDeJuego {
    private Juego juego;
    public EstadoRetrucoAceptado(Juego juego) {
        this.juego = juego;
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

    }

    @Override
    public void realEnvido() {

    }

    @Override
    public void faltaEnvido() {

    }

    @Override
    public void truco() {

    }

    @Override
    public void retruco() {

    }

    @Override
    public void valeCuatro() {
        Jugador jugadorActual = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
        this.juego.setEstadoDeJuego(new EstadoValeCuatro(juego));
        juego.manejadorDeTurnos.setPrimeroQueCantoTruco(jugadorActual);

    }

    @Override
    public void quiero() {

    }

    @Override
    public void noQuiero() {

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

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoRetrucoAceptado();
    }
}
