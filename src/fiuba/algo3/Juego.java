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

    public Juego(){
        this.estadoDeJuego = new EstadoJuegoConFlor(this);//por ahora directamente se incializa con flor depseus veremos
        this.mesaDelJuego = new Mesa();
        this.listaDeJugadores = new ListaJugadores();
        this.mazoDelJuego = new Mazo();
        this.puntosDeTruco= 1;// si no se quiere o un se va al maso directamente
    }

    public int getPuntosDeTruco(){
        return this.puntosDeTruco;
    }

    public void setEstadoDeJuego(EstadoDeJuego estadoDeJuego) {
        this.estadoDeJuego = estadoDeJuego;
    }

    public void jugarCarta(CartaJugada cartaJugada) {
        estadoDeJuego.jugarCarta(cartaJugada);
        this.manejadorDeTurnos.pasarTurnoCartas();
    }

    public Mesa mesaDelJuego() {       return this.mesaDelJuego;    }

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

    public void seCantaEnvido() {
        this.estadoDeJuego.envido();
        this.manejadorDeTurnos.pasarTurnoCantos();
    }

    public void noQuiero(){
        this.estadoDeJuego.noQuiero();
    }

    public void noSeQuizoEnvido() {
        this.manejadorDeTurnos.volverTurnoCanto();
        this.manejadorDeTurnos.getJugadorConTurnoCanto().getEquipo().sumarPuntos(1);

    }

    public void quiero() {
        this.manejadorDeTurnos.pasarTurnoCantos();
        this.estadoDeJuego.quiero();
    }

    public void siSeQuizoEnvido() {
        this.manejadorDeTurnos.volverTurnoCanto();
        getGanadorDeEnvido().getEquipo().sumarPuntos(estadoDeJuego.puntosDeEstado());
    }

    public Jugador getGanadorDeEnvido(){
        int tantosJugador1 = listaDeJugadores.getPrimero().getJugador().getMano().obtenerEnvido().getValorEnvido();
        int tantosJugador2 = listaDeJugadores.getUltimo().getJugador().getMano().obtenerEnvido().getValorEnvido();
        if (tantosJugador1 == tantosJugador2)
            return this.manejadorDeTurnos.getJugadorQueEsMano();
        if (tantosJugador1 > tantosJugador2)
            return listaDeJugadores.getPrimero().getJugador();
        else
            return listaDeJugadores.getUltimo().getJugador();
    }

    public void seCantaRealEnvido() {
        this.estadoDeJuego.realEnvido();
        this.manejadorDeTurnos.pasarTurnoCantos();
    }

    public void agregarCartaAMesa(CartaJugada cartaJugada) {
        this.mesaDelJuego.agregarCartaALsitaDeCartasJugadas(cartaJugada);
    }

    public void siSeQuizoTruco() {
        this.manejadorDeTurnos.pasarTurnoCantos();
    }

    public void setPuntosDeTruco(int puntosDeTruco) {
        this.puntosDeTruco = puntosDeTruco;
    }

    public void seCantaTruco() {
        this.estadoDeJuego.truco();
        this.manejadorDeTurnos.pasarTurnoCantos();
    }

    public void seCantaRetruco() {
        this.estadoDeJuego.retruco();
        this.manejadorDeTurnos.pasarTurnoCantos();
    }

    public void seCantaValeCuatro() {
        this.estadoDeJuego.valeCuatro();
        this.manejadorDeTurnos.pasarTurnoCantos();
    }


    public void meVoyAlMaso() {
        this.estadoDeJuego.irseAlMaso();
    }

    public void seFueronAlMaso() {
        this.manejadorDeTurnos.pasarTurnoCantos();// paso el turno asi me paro donde el siguiente jugador que es el contrario al q se fue al mazo
        this.manejadorDeTurnos.getJugadorConTurnoCanto().getEquipo().sumarPuntos(this.puntosDeTruco);
        this.manejadorDeTurnos.reiniciarRonda();
    }
}
