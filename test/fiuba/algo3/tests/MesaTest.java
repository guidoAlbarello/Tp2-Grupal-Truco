import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.jugadasPosibles.respuestasAPeticiones.ReTrucoAceptado;
import fiuba.algo3.modelo.jugadasPosibles.respuestasAPeticiones.TrucoAceptado;
import fiuba.algo3.modelo.jugadasPosibles.respuestasAPeticiones.ValeCuatroAceptado;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeTurnos;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 13/11/2015.
 */
public class MesaTest {

    @Test
    public void determinarGanadorDeMano(){
        Cantos cantos = new CantosSinFlor();
        JugadorEnRonda jugador1 = new JugadorEnRonda(new Jugador("jugador1",cantos));
        JugadorEnRonda jugador2 = new JugadorEnRonda(new Jugador("jugador2",cantos));
        ManejadorDeTurnos turnos = new ManejadorDeTurnos(jugador1,jugador2);
        Mesa mesa = new Mesa(jugador1,jugador2,turnos);
        Mazo mazo = new Mazo();
        mazo.mezclarMazo();
        mazo.repartirCartasAJugador(jugador1.getJugador());
        mazo.repartirCartasAJugador(jugador2.getJugador());
        mesa.seJuegaUnaCarta(1); //ese uno SIGNIFICA QUE EL JUGDOR ESTA TIRANDO LA SEGUNDA CARTA QUE TIENE EN LA MANO
        turnos.pasarTurnoEnMano();
        mesa.seJuegaUnaCarta(1);
        JugadorEnRonda jugadorQueGanoLaMano = mesa.compararCartas();
        if (mesa.terminoLaMano()){   jugadorQueGanoLaMano.aumentarManosGanadas(); }

        Assert.assertEquals(1,jugadorQueGanoLaMano.getManosGanadas());
    }


    public void verificarManoTerminada(Mesa mesa){
        JugadorEnRonda jugadorQueGanoLaMano = mesa.compararCartas();
        if (mesa.terminoLaMano()){   jugadorQueGanoLaMano.aumentarManosGanadas(); }
    }

    @Test
    public void testDeTrucoCantadoYAceptado() {
        Cantos cantos = new CantosSinFlor();
        JugadorEnRonda jugador1 = new JugadorEnRonda(new Jugador("jugador1", cantos));
        JugadorEnRonda jugador2 = new JugadorEnRonda(new Jugador("jugador2", cantos));
        ManejadorDeTurnos turnos = new ManejadorDeTurnos(jugador1, jugador2);
        Mesa mesa = new Mesa(jugador1, jugador2, turnos);
        Mazo mazo = new Mazo();
        mazo.mezclarMazo();
        mazo.repartirCartasAJugador(jugador1.getJugador());
        mazo.repartirCartasAJugador(jugador2.getJugador());

        //EXPLICO, SE AGREGAN LAS LLAMADAS ASI DADO QUE NO SE CREO INTELIGENCIA PARA QUE EL JUGADOR DECIDA CUANDO CANTAR, AUNQUE ESO DEBERIA ESTAR EN LA VISTA.

        //mano1
        mesa.seJuegaUnaCarta(0);
        turnos.pasarTurnoEnMano();
        mesa.seJuegaUnaCarta(0);
        turnos.pasarTurnoEnMano();
        verificarManoTerminada(mesa);
        //mano2
        mesa.seJuegaUnaCarta(1);
        turnos.pasarTurnoEnMano();
        mesa.seJuegaUnaCarta(1);
        turnos.pasarTurnoEnMano();
        verificarManoTerminada(mesa);
        //mano3
        //mesa.seCantaTruco();       ****** YO ARME TODOESTO PENSANDO QUE EL TRUCO SE CANTA DESDE LA VISTA, LA CUAL ACTUALIZA LA PANTALLA Y DA 2 BOTONES POSIBLES:
                                                        // Quiero  o  NoQuiero  (significa que le pregunta al otro jugador)
                                                        // haciendo el llamado correspondiente a la jugada que actualiza el estado de mesa, dependiendo el boton que toque el cliente.
        mesa.resolverJugada(new TrucoAceptado(jugador1.getJugador()));
        mesa.seJuegaUnaCarta(2);
        turnos.pasarTurnoEnMano();
        mesa.seJuegaUnaCarta(2);
        verificarManoTerminada(mesa);


        //UNA VEZ QUE SE TERMINA LA MANO...
        if (mesa.terminoLaRonda()){
            JugadorEnRonda jugadorGanadorDeLaRonda = mesa.getGanadorDeRonda();
            jugadorGanadorDeLaRonda.sumaPuntajeEnRonda(mesa.getPuntosEnJuego()); //se supone que el ganador de la ronda implica sumar puntos relacionados con el canto de Truco/s e irse al maso.
            jugadorGanadorDeLaRonda.actualizarPuntajeDeJugador();
        }
        Assert.assertTrue(jugador1.getJugador().getPuntaje()==2 | jugador2.getJugador().getPuntaje()==2); //existe ganador de la ronda y este suma 2 puntos (no se contempla empardar 3 veces)
    }



    @Test
    public void simulacionPartidaConTrucoRetrucoYVale4() {
        // SETUP
        Cantos cantos = new CantosSinFlor();
        JugadorEnRonda jugador1 = new JugadorEnRonda(new Jugador("jugador1", cantos));
        JugadorEnRonda jugador2 = new JugadorEnRonda(new Jugador("jugador2", cantos));
        ManejadorDeTurnos turnos = new ManejadorDeTurnos(jugador1, jugador2);
        Mesa mesa = new Mesa(jugador1, jugador2, turnos);
        Mazo mazo = new Mazo();
        mazo.mezclarMazo();
        mazo.repartirCartasAJugador(jugador1.getJugador());
        mazo.repartirCartasAJugador(jugador2.getJugador());


        //mano1
        mesa.seJuegaUnaCarta(0);
        turnos.pasarTurnoEnMano();
        //SUPONGAMOS QUE ACA EL JUGADOR2, CANTA TRUCO.
        mesa.resolverJugada(new TrucoAceptado(jugador2.getJugador()));  //esto significa que el jugador1 acepta y por ende, tiene que quiero.
        mesa.seJuegaUnaCarta(0);
        turnos.pasarTurnoEnMano();
        verificarManoTerminada(mesa);


        //mano2
        //sin importar quien gano la mano, el jugador1, que tenia el quiero, canta retruco
        mesa.resolverJugada(new ReTrucoAceptado(jugador1.getJugador()));  // el jugador2 acepta y tiene el quiero.
        mesa.seJuegaUnaCarta(1);  //todavia es el turno del jugador1, quien en esta, tira una carta.
        turnos.pasarTurnoEnMano();
        mesa.seJuegaUnaCarta(1);
        turnos.pasarTurnoEnMano();
        verificarManoTerminada(mesa);


        //mano1
        mesa.seJuegaUnaCarta(2);
        turnos.pasarTurnoEnMano();
        // el jugador2 canta Vale4
        mesa.resolverJugada(new ValeCuatroAceptado(jugador2.getJugador())); // el jugador1 acepta
        mesa.seJuegaUnaCarta(2);
        turnos.pasarTurnoEnMano();
        verificarManoTerminada(mesa);

        //termina la ronda
        if (mesa.terminoLaRonda()){
            JugadorEnRonda jugadorGanadorDeLaRonda = mesa.getGanadorDeRonda();
            jugadorGanadorDeLaRonda.sumaPuntajeEnRonda(mesa.getPuntosEnJuego());
            jugadorGanadorDeLaRonda.actualizarPuntajeDeJugador();
        }
        Assert.assertTrue(jugador1.getJugador().getPuntaje()==4 | jugador2.getJugador().getPuntaje()==4); //existe ganador de la ronda y este suma 4 puntos por VALECUATRO (no se contempla empardar 3 veces)


    }


}
