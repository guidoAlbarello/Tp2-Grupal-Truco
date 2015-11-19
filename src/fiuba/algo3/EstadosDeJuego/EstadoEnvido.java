package fiuba.algo3.EstadosDeJuego;


import fiuba.algo3.Juego;
import fiuba.algo3.Excepciones.NoSeResuelveEnvidoError;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoEnvido implements EstadoDeJuego {
    private Juego juego;
    @Override
    public void envido() {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void realEnvido() {
        this.juego.cambiarEstadoRealEnvido();
    }

    @Override
    public void faltaEnvido() {
        this.juego.cambiarEstadoFaltaEnvido();
    }

    @Override
    public void truco() {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void retruco() {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void valeCuatro() {
        throw new NoSeResuelveEnvidoError();
    }

    @Override
    public void quiero() {
        //resolver buscar el que tenga mas tantos y sumarle 2 puntos
    }

    @Override
    public void noQuiero() {
        //resolver que no se acepte - sumarle 1 punto al que canto el envido
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveEnvidoError();
    }

    @Override
    public int puntos() {
        return 1;
    }
}
