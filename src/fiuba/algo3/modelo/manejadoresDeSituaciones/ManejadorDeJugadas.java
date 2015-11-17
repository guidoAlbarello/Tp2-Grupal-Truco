package fiuba.algo3.modelo.manejadoresDeSituaciones;

import fiuba.algo3.modelo.JugadasOpcional.*;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.JugadorEnRonda;
import fiuba.algo3.modelo.Mesa;

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

    public void resolverJugada(Jugada respuesta) {
        respuesta.resolverEnManejadorDeJugadas(this);
    }

    public void resolverJugadaTipo(CantosPosibles cantosPosibles){
        this.manejadorDeTurnos.pasarTurnoEnMano(); // pasa al otro jugador
    }

    public void resolverJugadaTipo(QuieroEnvido seQuiereLaJugada){
        JugadorEnRonda jugadorGanador = this.mesaDeJuego.compararTantos(this.jugador1EnRonda, this.jugador2EnRonda);
        jugadorGanador.sumaPuntajeEnRonda(seQuiereLaJugada.getValorDeJugada());
    }

    public void resolverJugadaTipo(NoQuieroEnvido noSeQuiereLaJugada){
        manejadorDeTurnos.pasarTurnoEnMano();
        JugadorEnRonda jugador = manejadorDeTurnos.getJugadorTurnoEnMano();
        jugador.sumaPuntajeEnRonda(noSeQuiereLaJugada.getValorDeJugada());
    }


    public void resolverJugadaTipo(QuieroTruco seQuiereLaJugada){
        this.mesaDeJuego.setPuntosEnJuego(seQuiereLaJugada.getValorDeJugada());
    }

    public void resolverJugadaTipo(NoQuieroTruco noSeQuiereLaJugada){
        manejadorDeTurnos.pasarTurnoEnMano();
        JugadorEnRonda jugador = manejadorDeTurnos.getJugadorTurnoEnMano();
        jugador.sumaPuntajeEnRonda(noSeQuiereLaJugada.getValorDeJugada());
    }

    public void resolverJugadaTipo(QuieroFlor seQuiereLaJugada){
        JugadorEnRonda jugadorGanador = this.mesaDeJuego.compararFlor(this.jugador1EnRonda, this.jugador2EnRonda);
        jugadorGanador.sumaPuntajeEnRonda(seQuiereLaJugada.getValorDeJugada());
    }

    public void resolverJugadaTipo(NoQuieroFlor noSeQuiereLaJugada){
        manejadorDeTurnos.pasarTurnoEnMano();
        JugadorEnRonda jugador = manejadorDeTurnos.getJugadorTurnoEnMano();
        jugador.sumaPuntajeEnRonda(noSeQuiereLaJugada.getValorDeJugada());
    }

    public void resolverJugadaTipo(CartaJugada cartaJugada){
        this.mesaDeJuego.agregarCartaEnMesa(cartaJugada);
        if (this.mesaDeJuego.getCartasEnMesa().size() == 2){
            JugadorEnRonda jugadorGanaMano = this.mesaDeJuego.compararCartas(); //---------ACA tambien cambie cartasEnMesa que recibe compararCartas
            jugadorGanaMano.aumentarManosGanadas();
            this.mesaDeJuego.limpiarMesa();
        }
        manejadorDeTurnos.pasarTurnoEnMano();//paso al siguiente jugador por q entest caso coomo son 2
    }

    public Mesa getMesaDeJuego() {
        return this.mesaDeJuego;
    }
}
