package fiuba.algo3;

import fiuba.algo3.EstadosDeJuego.*;

/**
 * Created by anthony on 18/11/2015.
 */
public class Juego {
    private EstadoDeJuego estadoDeJuego;
    private Mesa mesaDelJuego;

    public Juego(){
        this.estadoDeJuego = new EstadoPrimeraMano(this);//no se si esta bien inicializarlo asi peor por ahora lo dejo asi
        this.mesaDelJuego = new Mesa();
    }


    public void cambiarEstadoRealEnvido() {this.estadoDeJuego = new EstadoRealEnvido();   }

    public void cambiarEstadoFaltaEnvido() {this.estadoDeJuego = new EstadoFaltaEnvido();   }

    public void cambiarEstadoEnvido() {this.estadoDeJuego = new EstadoEnvido();    }

    public void cambiarEstadoTruco() {this.estadoDeJuego = new EstadoTruco();    }

    public void cambiarEstadoValeCuatro() {this.estadoDeJuego = new EstadoValeCuatro();    }

    public void cambiarEstadoRetruco() {this.estadoDeJuego = new EstadoRetruco();
    }

    public void setEstadoDeJuego(EstadoDeJuego estadoDeJuego) {
        this.estadoDeJuego = estadoDeJuego;
    }

    public void jugarCarta(CartaJugada cartaJugada) {
        estadoDeJuego.jugarCarta(cartaJugada);
    }

    public Mesa mesaDelJuego() {
        return this.mesaDelJuego;

    }
}
