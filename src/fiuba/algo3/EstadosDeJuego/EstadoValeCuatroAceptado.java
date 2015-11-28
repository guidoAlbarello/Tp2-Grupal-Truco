package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
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
}