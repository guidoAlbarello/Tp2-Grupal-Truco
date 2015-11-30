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
    public ManejadorDeTurnos manejadorDeTurnos;
    private Mazo mazoDelJuego;
    private int puntosDeTruco;
    private int puntosDeEnvidoQuerido;
    private int puntosDeEnvidoNoQuerido;

    public Juego(){

        this.mesaDelJuego = new Mesa();
        this.listaDeJugadores = new ListaJugadores();
        this.configurarManejadorDeTurnos();
        this.mazoDelJuego = new Mazo();
        this.estadoDeJuego = new EstadoJuegoConFlor(this);//por ahora , se incializa con flor depseus veremos
        this.puntosDeTruco= 1;// si no se quiere o un se va al maso directamente
        this.puntosDeEnvidoNoQuerido = 0;
        this.puntosDeEnvidoQuerido = 0;
    }

    public int getPuntosDeTruco(){
        return this.puntosDeTruco;
    }

    public void setEstadoDeJuego(EstadoDeJuego estadoDeJuego) {
        this.estadoDeJuego = estadoDeJuego;
    }

    public Mesa getMesaDelJuego() {       return this.mesaDelJuego;    }

    public void configurarManejadorDeTurnos(){ this.manejadorDeTurnos = new ManejadorDeTurnos(this.listaDeJugadores,this); }

    public void agregarJugador(Jugador jugador) {       listaDeJugadores.agregarUltimo(jugador);    }

    public void repartirCartasAJugadores() {
        this.listaDeJugadores.sacarCartasATodosLosJugadores();
        this.mazoDelJuego = new Mazo();
        this.mazoDelJuego.mezclarMazo();
        for (int i = 0 ; i < this.listaDeJugadores.getTamanio() ; i++) {
            Jugador actual = this.listaDeJugadores.getJugadorEnPosicion(i);
            this.mazoDelJuego.repartirCartasAJugador(actual);
        }
    }

    public void jugarCarta(CartaJugada cartaJugada) {estadoDeJuego.jugarCarta(cartaJugada);}

    public void seCantaEnvido() {this.estadoDeJuego.envido();    }

    public void seCantaRealEnvido() {this.estadoDeJuego.realEnvido(); }

    public void seCantaFaltaEnvido() {this.estadoDeJuego.faltaEnvido();}

    public void siSeQuizoEnvido() {getGanadorDeEnvido().getEquipo().sumarPuntos(this.puntosDeEnvidoQuerido);}

    public void siSeQuizoFaltaEnvido() {getGanadorDeEnvido().getEquipo().sumarPuntos(this.puntosDeFaltaEnvido());}

    public void noSeQuizoEnvido() {this.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().sumarPuntos(this.puntosDeEnvidoNoQuerido);}

    private Integer puntosDeFaltaEnvido() {
        int puntajeEquipo1 = manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().getPuntaje();
        int puntajeEquipo2 = manejadorDeTurnos.getJugadorSiguienteAlTurnoActual().getEquipo().getPuntaje();
        if (puntajeEquipo1 > puntajeEquipo2)
            return 30 - puntajeEquipo1;// habria q hacer lgo mas lindo aca
        else
            return 30 - puntajeEquipo2;
    }

    public void quiero() {this.estadoDeJuego.quiero();}

    public void noQuiero(){this.estadoDeJuego.noQuiero();}

    public void seCantaTruco() {this.estadoDeJuego.truco();}

    public void seCantaRetruco() {this.estadoDeJuego.retruco();}

    public void seCantaValeCuatro() {this.estadoDeJuego.valeCuatro();}

    public void setPuntosDeTruco(int puntosDeTruco) {
        this.puntosDeTruco = puntosDeTruco;
    }

    public void meVoyAlMaso() {
        this.estadoDeJuego.irseAlMaso();
    }

    public void seFueronAlMaso() {
        this.manejadorDeTurnos.getJugadorConTurnoActual().getEquipo().sumarPuntos(this.puntosDeTruco);
        this.manejadorDeTurnos.reiniciarRonda();
    }

    public ListaJugadores getJugadores() {return listaDeJugadores;}

    public Jugador getGanadorDeEnvido(){
        Jugador jugador1 = listaDeJugadores.getPrimero().getJugador().getEquipo().jugadorConEnvidoMayorEnEquipo();
        Jugador jugador2 = listaDeJugadores.getPrimero().getSiguiente().getJugador().getEquipo().jugadorConEnvidoMayorEnEquipo();
        int tantosJugador1 = jugador1.getMano().obtenerEnvido().getValorEnvido();
        int tantosJugador2 = jugador2.getMano().obtenerEnvido().getValorEnvido();
        if (tantosJugador1 == tantosJugador2)
            return this.manejadorDeTurnos.getJugadorQueEsMano();
        if (tantosJugador1 > tantosJugador2)
            return jugador1;
        else
            return jugador2;
    }

    public void agregarCartaAMesa(CartaJugada cartaJugada) {
        this.mesaDelJuego.agregarCartaALsitaDeCartasJugadas(cartaJugada);
    }


    public void sumarPuntosEnvidoNoQuerido() {
        this.puntosDeEnvidoNoQuerido ++;
    }

    public void sumarPuntosEnvidoSiQuerido(int puntosDeEstado) {
        this.puntosDeEnvidoQuerido += puntosDeEstado;
    }

    public void inicializarPuntosParaRonda(){
        this.puntosDeTruco = 1;
        this.puntosDeEnvidoQuerido = 0;
        this.puntosDeEnvidoNoQuerido = 0;
    }
    public int getPuntosDeEnvidoQuerido(){
        return this.puntosDeEnvidoQuerido;
    }
}
