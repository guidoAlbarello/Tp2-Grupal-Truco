package fiuba.algo3;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoRetruco implements EstadoDeJuego {
    private Juego juego;

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
}
