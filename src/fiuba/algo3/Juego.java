package fiuba.algo3;

/**
 * Created by anthony on 18/11/2015.
 */
public class Juego {
    private EstadoDeJuego estadoDeJuego;

    public void cambiarEstadoRealEnvido() {this.estadoDeJuego = new EstadoRealEnvido();   }

    public void cambiarEstadoFaltaEnvido() {this.estadoDeJuego = new EstadoFaltaEnvido();   }

    public void cambiarEstadoEnvido() {this.estadoDeJuego = new EstadoEnvido();    }

    public void cambiarEstadoTruco() {this.estadoDeJuego = new EstadoTruco();    }

    public void cambiarEstadoValeCuatro() {this.estadoDeJuego = new EstadoValeCuatro();    }

    public void cambiarEstadoRetruco() {this.estadoDeJuego = new EstadoRetruco();
    }
}
