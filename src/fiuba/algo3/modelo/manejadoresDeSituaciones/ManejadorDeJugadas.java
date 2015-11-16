package fiuba.algo3.modelo.manejadoresDeSituaciones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.JugadorEnRonda;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPermitidas.CartaJugada;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.jugadasPermitidas.peticiones.EnvidoCantado;
import fiuba.algo3.modelo.jugadasPermitidas.peticiones.RealEnvidoCantado;
import fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones.AceptaEnvido;
import fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones.AceptaRealEnvido;
import fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones.NoAceptaEnvido;

import java.util.Dictionary;

/**
 * Created by Krion on 16/11/2015.
 */
public class ManejadorDeJugadas {
    private ManejadorDeTurnos manejadorDeTurnos;
    private Mesa mesaDeJuego;
    private JugadorEnRonda jugador1EnRonda;
    private JugadorEnRonda jugador2EnRonda;

    public ManejadorDeJugadas(JugadorEnRonda unJugadorEnRonda, JugadorEnRonda otroJugadorEnRonda, ManejadorDeTurnos unManejadorDeTurnos, Mesa unaMesa){
        this.jugador1EnRonda = unJugadorEnRonda;
        this.jugador2EnRonda = otroJugadorEnRonda;
        this.manejadorDeTurnos = unManejadorDeTurnos;
        this.mesaDeJuego = unaMesa;
    }

    public void resolverEnvido(EnvidoCantado envido) {
        manejadorDeTurnos.pasarTurnoEnMano();
        Jugador jugadorQueLeTocaResponder = manejadorDeTurnos.getJugadorTurnoEnMano().getJugador();
        Jugada jugadaDelJugador = jugadorQueLeTocaResponder.seleccionarRespuesta("AceptaEnvido");
        this.resolverJugada(jugadaDelJugador);
    }

    public void resolverJugada(Jugada respuesta) {
        respuesta.resolverEnMesa(this);
    }

    public void resolverAceptaEnvido(AceptaEnvido aceptaEnvido) {
        JugadorEnRonda jugadorGanador = this.mesaDeJuego.compararTantos(jugador1EnRonda, jugador2EnRonda);
        jugadorGanador.sumaPuntajeEnRonda(2);// se suman 2 puntos por acepto envido
    }

    public void resolverRealEnvido(RealEnvidoCantado realEnvido){
        manejadorDeTurnos.pasarTurnoEnMano();
        Jugador jugador = manejadorDeTurnos.getJugadorTurnoEnMano().getJugador();
        Jugada respuesta = jugador.seleccionarRespuesta("AceptaRealEnvido");
        this.resolverJugada(respuesta);
    }

    public void resolverAceptaRealEnvido(AceptaRealEnvido aceptaRealEnvido) {
        JugadorEnRonda jugadorGanador = this.mesaDeJuego.compararTantos(jugador1EnRonda, jugador2EnRonda);
        jugadorGanador.sumaPuntajeEnRonda(4);// se suman 4 puntos por acepto envido
    }

    public void resolverNoAceptaEnvido(NoAceptaEnvido noAceptaEnvido) {
        manejadorDeTurnos.pasarTurnoEnMano();
        JugadorEnRonda jugador = manejadorDeTurnos.getJugadorTurnoEnMano();
        jugador.sumaPuntajeEnRonda(1);//no se acepta envido entonces el otro jugador suma 1
    }
    public void resolverCartaJugada(CartaJugada cartaJugada){
        this.mesaDeJuego.agregarCartaEnMesa(cartaJugada);
        if (this.mesaDeJuego.getCartasEnMesa().size() == 2){
            JugadorEnRonda jugadorGanaMano = this.mesaDeJuego.compararCartas(); //---------ACA tambien cambie cartasEnMesa que recibe compararCartas
            jugadorGanaMano.aumentarManosGanadas();
            this.mesaDeJuego.limpiarMesa();
        }
        manejadorDeTurnos.pasarTurnoEnMano();//paso al siguiente jugador por q entest caso coomo son 2
        Jugador jugador = manejadorDeTurnos.getJugadorTurnoEnMano().getJugador();
        Jugada jugada = jugador.hacerJugada();
        this.resolverJugada(jugada);
    }

    public Mesa getMesaDeJuego() {
        return this.mesaDeJuego;
    }
}
