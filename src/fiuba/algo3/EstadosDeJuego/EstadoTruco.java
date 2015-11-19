package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.NoSeResuelveTrucoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoTruco implements EstadoDeJuego {
    private Juego juego;

    @Override
    public void envido() {
        throw new NoSeResuelveTrucoError();/* aca en realidad esto no es correcto por que
        si se puede cantar Envido cuando se canto Truco*/
    }

    @Override
    public void realEnvido() {
        throw new NoSeResuelveTrucoError();/* aca en realidad esto no es correcto por que
        si se puede cantar realEnvido cuando se canto Truco*/
    }

    @Override
    public void faltaEnvido() {
        throw new NoSeResuelveTrucoError();/* aca en realidad esto no es correcto por que
        si se puede cantar faltaEnvido cuando se canto Truco*/
    }

    @Override
    public void truco() {throw new NoSeResuelveTrucoError();
    }

    @Override
    public void retruco() {this.juego.cambiarEstadoRetruco();
    }

    @Override
    public void valeCuatro() {throw new NoSeResuelveTrucoError();
    }

    @Override
    public void quiero() {

    }

    @Override
    public void noQuiero() {throw new NoSeResuelveTrucoError();
    }

    @Override
    public void irseAlMaso() {
        throw new NoSeResuelveTrucoError();
    }

    @Override
    public int puntos() {
        return 0;
    }
}