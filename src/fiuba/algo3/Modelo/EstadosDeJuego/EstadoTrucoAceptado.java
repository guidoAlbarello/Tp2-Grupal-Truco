package fiuba.algo3.Modelo.EstadosDeJuego;

import fiuba.algo3.Modelo.ModeladoDeCarta.CartaJugada;
import fiuba.algo3.Modelo.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Modelo.Juego.Juego;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;

/**
 * Created by anthony on 23/11/2015.
 */
public class EstadoTrucoAceptado implements EstadoDeJuego {
    private Juego juego;
    public EstadoTrucoAceptado(Juego juego) {
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
        Jugador jugadorTurnoActual = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getUltimoQueJugoTruco());
        juego.manejadorDeTurnos.setUltimoQueJugoTruco(jugadorTurnoActual);
        juego.manejadorDeTurnos.setPrimeroQueCantoTruco(jugadorTurnoActual);
        this.juego.setEstadoDeJuego(new EstadoRetruco(juego));

    }

    @Override
    public void valeCuatro() {
        this.juego.setEstadoDeJuego(new EstadoValeCuatro(juego));
    }

    @Override
    public void quiero() {

    }

    @Override
    public void noQuiero() {

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
        decisionSegunEstado.elegirJugadaEstadoTrucoAceptado();
    }
}
