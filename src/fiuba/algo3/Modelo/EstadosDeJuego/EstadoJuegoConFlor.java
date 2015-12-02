package fiuba.algo3.Modelo.EstadosDeJuego;

import fiuba.algo3.Modelo.ModeladoDeCarta.CartaJugada;
import fiuba.algo3.Modelo.Excepciones.NoHayFlorEnManoError;
import fiuba.algo3.Modelo.Excepciones.NoSeCantoFlorError;
import fiuba.algo3.Modelo.InteligenciaArtificial.DecisionSegunEstado;
import fiuba.algo3.Modelo.Juego.Juego;
import fiuba.algo3.Modelo.Excepciones.JugadaInvalidaPrimeraManoError;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoJuegoConFlor implements EstadoDeJuego {
    private Juego juego;

    public EstadoJuegoConFlor(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void flor() {
        Jugador jugadorAnterior = juego.manejadorDeTurnos.getJugadorAnteriorAlTurnoActual();
        Jugador jugadorActual = juego.manejadorDeTurnos.getJugadorConTurnoActual();
        Jugador jugadorPosterior = juego.manejadorDeTurnos.getJugadorSiguienteAlTurnoActual();

        if (jugadorActual.getMano().hayFlorEnMano() && !(jugadorAnterior.getMano().hayFlorEnMano() || jugadorPosterior.getMano().hayFlorEnMano())) {
            this.juego.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().sumarPuntos(3);
            this.juego.setEstadoDeJuego(new EstadoSinEnvido(juego));
        }
        else
        if (jugadorActual.getMano().hayFlorEnMano() && (jugadorAnterior.getMano().hayFlorEnMano() || jugadorPosterior.getMano().hayFlorEnMano())){
            this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
            this.juego.manejadorDeTurnos.setPrimeroQueCantoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
            this.juego.setEstadoDeJuego(new EstadoFlor(this.juego));
            this.juego.manejadorDeTurnos.pasarTurnoActual();

        }else
            throw new NoHayFlorEnManoError();
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
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoEnvido(this.juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }


    @Override
    public void realEnvido() {
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoRealEnvido(juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void faltaEnvido() {
        this.juego.manejadorDeTurnos.setUltimoQueJugoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoEnvido(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoFaltaEnvido(juego));
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void truco() {
        this.juego.manejadorDeTurnos.setUltimoQueJugoTruco(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.manejadorDeTurnos.setPrimeroQueCantoTruco(juego.manejadorDeTurnos.getJugadorConTurnoActual());
        this.juego.setEstadoDeJuego(new EstadoTruco(juego));
        this.juego.setPuntosDeTruco(this.puntosSiSeQuiere());
        this.juego.manejadorDeTurnos.pasarTurnoActual();
    }

    @Override
    public void retruco() {
        throw new JugadaInvalidaPrimeraManoError();
    }

    @Override
    public void valeCuatro() {
        throw new JugadaInvalidaPrimeraManoError();
    }

    @Override
    public void quiero() {
        throw new JugadaInvalidaPrimeraManoError();
    }

    @Override
    public void noQuiero() {throw new JugadaInvalidaPrimeraManoError();
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
        decisionSegunEstado.elegirJugadaEstadoJuegoConFlor();
    }
}
