package fiuba.algo3.Modelo.EstadosDeJuego;

import fiuba.algo3.Modelo.ModeladoDeCarta.CartaJugada;
import fiuba.algo3.Modelo.Excepciones.JugadaNoValidaError;
import fiuba.algo3.Modelo.Excepciones.NoSeJugoTruco;
import fiuba.algo3.Modelo.Excepciones.YaSeJugoEnvidoError;
import fiuba.algo3.Modelo.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Modelo.Juego.Juego;

/**
 * Created by anthony on 22/11/2015.
 */
public class EstadoSinEnvido implements EstadoDeJuego {
    private Juego juego;
    public EstadoSinEnvido(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void flor() {throw new YaSeJugoEnvidoError();}

    @Override
    public void contraFlor() {throw new YaSeJugoEnvidoError();}

    @Override
    public void contraFlorAlResto() {throw new YaSeJugoEnvidoError();}

    @Override
    public void envido() {
        throw new YaSeJugoEnvidoError();
    }

    @Override
    public void realEnvido() {
        throw new YaSeJugoEnvidoError();
    }

    @Override
    public void faltaEnvido() {
        throw new YaSeJugoEnvidoError();
    }

    @Override
    public void truco() {
        this.juego.manejadorDeTurnos.setUltimoQueJugoTruco(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoTruco(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoTruco(juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void retruco() {
        throw new NoSeJugoTruco();
    }

    @Override
    public void valeCuatro() {
        throw new NoSeJugoTruco();
    }

    @Override
    public void quiero() {
        throw new JugadaNoValidaError();
    }

    @Override
    public void noQuiero() {
        throw new JugadaNoValidaError();
    }

    @Override
    public void irseAlMaso() {
        this.juego.manejadorDeTurnos.pasarTurnoActual();
        this.juego.seFueronAlMaso();
    }

    @Override
    public int puntosSiSeQuiere() {
        return 20;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        this.juego.agregarCartaAMesa(cartaJugada);
        this.juego.manejadorDeTurnos.pasarTurnoCartas();
    }

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoSinEnvido();
    }
}

