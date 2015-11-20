package fiuba.algo3;

import fiuba.algo3.EstadosDeJuego.*;
import fiuba.algo3.manejoDeJugadores.Jugador;
import fiuba.algo3.manejoDeJugadores.ListaJugadores;
import fiuba.algo3.manejoDeJugadores.ManejadorDeTurnos;

/**
 * Created by anthony on 18/11/2015.
 */
public class Juego {
    private EstadoDeJuego estadoDeJuego;
    private Mesa mesaDelJuego;
    private ListaJugadores listaDeJugadores;
    private ManejadorDeTurnos manejadorDeTurnos;
    private Mazo mazoDelJuego;

    public Juego(){
        this.estadoDeJuego = new EstadoPrimeraMano(this);//no se si esta bien inicializarlo asi peor por ahora lo dejo asi
        this.mesaDelJuego = new Mesa();
        this.listaDeJugadores = new ListaJugadores();
        this.manejadorDeTurnos = new ManejadorDeTurnos(listaDeJugadores);
        this.mazoDelJuego = new Mazo();
    }


    public void cambiarEstadoRealEnvido() {this.estadoDeJuego = new EstadoRealEnvido(this);   }

    public void cambiarEstadoFaltaEnvido() {this.estadoDeJuego = new EstadoFaltaEnvido(this);   }

    public void cambiarEstadoEnvido() {this.estadoDeJuego = new EstadoEnvido(this);    }

    public void cambiarEstadoTruco() {this.estadoDeJuego = new EstadoTruco(this);    }

    public void cambiarEstadoValeCuatro() {this.estadoDeJuego = new EstadoValeCuatro(this);    }

    public void cambiarEstadoRetruco() {this.estadoDeJuego = new EstadoRetruco(this);
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

    public void cambiarEstadoEnvidoEnvido() {
        this.estadoDeJuego = new EstadoEnvidoEnvido(this);
    }

    public void agregarJugador(Jugador jugador) {
        listaDeJugadores.agregarUltimo(jugador);
    }

    public void repartirCartasAJugadores() {

    }

    public void noSeQuizoEnvido() {
        this.manejadorDeTurnos.pasarElTurno();
        this.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().sumarPuntos(1);
    }
}
