package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Excepciones.NoSeResuelvValeCuatroError;
import fiuba.algo3.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Juego;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoValeCuatro implements EstadoDeJuego {
    private Juego juego;
    private int puntosDeEstado;

    public EstadoValeCuatro(Juego juego) {
        this.juego = juego;
        this.puntosDeEstado = 4;
    }

    @Override
    public void flor() {throw new NoSeResuelvValeCuatroError();    }

    @Override
    public void contraFlor() {throw new NoSeResuelvValeCuatroError();    }

    @Override
    public void contraFlorAlResto() {throw new NoSeResuelvValeCuatroError();    }

    @Override
    public void envido() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void realEnvido() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void faltaEnvido() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void truco() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void retruco() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void valeCuatro() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public void quiero() {
        this.juego.setPuntosDeTruco(this.puntosSiSeQuiere());
        juego.setEstadoDeJuego(new EstadoValeCuatroAceptado(juego));
        juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
    }

    @Override
    public void noQuiero() {
        this.juego.manejadorDeTurnos.setJugadorTurnoActual(juego.manejadorDeTurnos.getPrimeroQueCantoTruco());
        this.juego.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().sumarPuntos(this.puntosDeEstado - 1);
        this.juego.manejadorDeTurnos.reiniciarRonda();
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelvValeCuatroError();}

    @Override
    public int puntosSiSeQuiere() {return this.puntosDeEstado;}

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado) {
        decisionSegunEstado.elegirJugadaEstadoValeCuatro();
    }
}