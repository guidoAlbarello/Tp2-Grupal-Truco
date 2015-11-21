package fiuba.algo3;

import fiuba.algo3.EstadosDeJuego.*;
import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.manejoDeJugadores.Jugador;
import fiuba.algo3.manejoDeJugadores.ListaJugadores;
import fiuba.algo3.manejoDeJugadores.ManejadorDeTurnos;
import fiuba.algo3.manejoDeJugadores.NodoJugador;

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
        this.mazoDelJuego = new Mazo();
    }


    public void cambiarEstadoRealEnvido() {this.estadoDeJuego = new EstadoRealEnvido(this);   }

    public void cambiarEstadoFaltaEnvido() {this.estadoDeJuego = new EstadoFaltaEnvido(this);   }

    public void cambiarEstadoEnvido() {this.estadoDeJuego = new EstadoEnvido(this);
        this.manejadorDeTurnos.pasarElTurno();
    }

    public void cambiarEstadoTruco() {this.estadoDeJuego = new EstadoTruco(this);    }

    public void cambiarEstadoValeCuatro() {this.estadoDeJuego = new EstadoValeCuatro(this);    }

    public void cambiarEstadoRetruco() {this.estadoDeJuego = new EstadoRetruco(this);
    }

    public void setEstadoDeJuego(EstadoDeJuego estadoDeJuego) {
        this.estadoDeJuego = estadoDeJuego;
    }

    public void jugarCarta(CartaJugada cartaJugada) {
        estadoDeJuego.jugarCarta(cartaJugada);
        //this.manejadorDeTurnos.pasarElTurno();
    }

    public Mesa mesaDelJuego() {       return this.mesaDelJuego;    }

    public void configurarManejadorDeTurnos(){ this.manejadorDeTurnos = new ManejadorDeTurnos(this.listaDeJugadores,this); }

    public void cambiarEstadoEnvidoEnvido() {
        this.estadoDeJuego = new EstadoEnvidoEnvido(this);
    }

    public void agregarJugador(Jugador jugador) {       listaDeJugadores.agregarUltimo(jugador);    }

    public void repartirCartasAJugadores() {
        for (int i = 0 ; i < this.listaDeJugadores.getTamanio() ; i++) {
            Jugador actual = this.listaDeJugadores.getJugadorEnPosicion(i);
            this.mazoDelJuego.repartirCartasAJugador(actual);
        }
    }

    public void seCantaEnvido() {  this.manejadorDeTurnos.getJugadorConTurnoActual().envido();  }

    public void noSeQuizoEnvido() {
        this.manejadorDeTurnos.volverElTurno();
        this.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().sumarPuntos(1);

    }


    public void seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(int indiceDeLaCarta){
        Jugador jugadorConTurno = this.manejadorDeTurnos.getJugadorConTurnoActual();
        Carta carta = jugadorConTurno.jugarCartaEnPosicion(indiceDeLaCarta);
        CartaJugada cartaJugada = new CartaJugada(carta,jugadorConTurno);
        this.mesaDelJuego.agregarCartaALsitaDeCartasJugadas(cartaJugada);
        this.manejadorDeTurnos.pasarElTurno();
    }
}
