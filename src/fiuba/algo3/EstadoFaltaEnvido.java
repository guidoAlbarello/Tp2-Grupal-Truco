package fiuba.algo3;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoFaltaEnvido implements EstadoDeJuego {
    @Override
    public void envido() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void realEnvido() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void faltaEnvido() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void truco() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void retruco() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void valeCuatro() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public void quiero() {
        //resolver
    }

    @Override
    public void noQuiero() {
        //resolver
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelveFaltaEnvidoError();
    }

    @Override
    public int puntos() {
        return 3;
    }
}
