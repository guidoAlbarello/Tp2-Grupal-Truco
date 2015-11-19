package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.NoSeResuelveRetrucoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoRetruco implements EstadoDeJuego {
    private Juego juego;
    public EstadoRetruco(Juego juego) {
        this.juego = juego;
    }
    @Override
    public void envido() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void realEnvido() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void faltaEnvido() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void truco() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void retruco() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public void valeCuatro() {this.juego.cambiarEstadoValeCuatro();
    }

    @Override
    public void quiero() {

    }

    @Override
    public void noQuiero() {

    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveRetrucoError();
    }

    @Override
    public int puntos() {
        return 0;
    }

    @Override
    public void jugarCarta(CartaJugada cartaJugada) {
        throw new NoSeResuelveRetrucoError();
    }
}
