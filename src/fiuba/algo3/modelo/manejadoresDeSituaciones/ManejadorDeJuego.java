package fiuba.algo3.modelo.manejadoresDeSituaciones;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.jugadasPermitidas.peticiones.EnvidoCantado;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.jugadasPermitidas.peticiones.RealEnvidoCantado;

/**
 * Created by anthony on 12/11/2015.
 */
public class ManejadorDeJuego {
    private Mesa mesaDelJuego;
    private Jugador jugador1;
    private Jugador jugador2;
    private ManejadorDeTurnos manejadorDeTurnos;
    private ManejadorDePuntaje manejadorDePuntaje;
    private ManejadorDeJugadas manejadorDeJugadas;

    public ManejadorDeJuego(Jugador jugador1,Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

    }

    public void comenzarPartida() {
        JugadorEnRonda jugadorEnRonda1 = new JugadorEnRonda(this.jugador1);// estos jugadores alamz¡cenan los puntos ganados en cad aronda
        JugadorEnRonda jugadorEnRonda2 = new JugadorEnRonda(this.jugador2);
        manejadorDeTurnos = new ManejadorDeTurnos(jugadorEnRonda1,jugadorEnRonda2);
        mesaDelJuego = new Mesa(jugadorEnRonda1,jugadorEnRonda2,manejadorDeTurnos);//se crea la mesa para
        this.manejadorDeJugadas = new ManejadorDeJugadas(jugadorEnRonda1, jugadorEnRonda2, manejadorDeTurnos, mesaDelJuego);
        this.manejadorDePuntaje = new ManejadorDePuntaje(this.jugador1.getNombre(), this.jugador2.getNombre());
        this.elejirJugadorMano(jugadorEnRonda1, jugadorEnRonda1);
        while (jugadorEnRonda1.getJugador().getPuntaje() < 30 && jugadorEnRonda2.getJugador().getPuntaje() < 30)
            comenzarRonda(jugadorEnRonda1, jugadorEnRonda1);
    }

    private void elejirJugadorMano(JugadorEnRonda jugadorEnRonda1, JugadorEnRonda jugadorEnRonda11) {
        //hacer la logica para que el usuario elija alguno d elos jugadores como mano
        manejadorDeTurnos.setJugadorMano(jugadorEnRonda1);
    }

    public void comenzarRonda(JugadorEnRonda jugadorEnRonda1, JugadorEnRonda jugadorEnRonda2) {
        manejadorDeTurnos.pasarJugadorMano();
        while (jugadorEnRonda1.getManosGanadas() < 2 && jugadorEnRonda2.getManosGanadas() < 2) {
            JugadorEnRonda jugadorMano = manejadorDeTurnos.getJugadorMano();
            Jugada jugada = jugadorMano.getJugador().hacerJugada();
            manejadorDeJugadas.resolverJugada(jugada);
            jugadorEnRonda1.actualizarPuntajeDeJugador();
            jugadorEnRonda1.inicializarParaNuevaRonda();
            jugadorEnRonda2.actualizarPuntajeDeJugador();
            jugadorEnRonda2.inicializarParaNuevaRonda();
        }
        if (jugadorEnRonda1.getManosGanadas() == 2 )
            jugadorEnRonda1.getJugador().sumaPuntaje(1);
        else
            jugadorEnRonda2.getJugador().sumaPuntaje(1);
        this.manejadorDePuntaje.sumaPuntaje(jugadorEnRonda1.getJugador().getNombre(), jugadorEnRonda1.getPuntosGanadosEnRonda());
        this.manejadorDePuntaje.sumaPuntaje(jugadorEnRonda2.getJugador().getNombre(), jugadorEnRonda2.getPuntosGanadosEnRonda());
    }


    /**
     * Created by Fechee on 10/11/2015.
     */

}
