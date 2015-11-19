package fiuba.algo3;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoValeCuatro implements EstadoDeJuego {
    @Override
    public void envido() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void realEnvido() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void faltaEnvido() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void truco() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void retruco() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void valeCuatro() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void quiero() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void noQuiero() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public void irseAlMaso() {throw new NoSeResuelvValeCuatroError();
    }

    @Override
    public int puntos() {
        return 0;
    }
}