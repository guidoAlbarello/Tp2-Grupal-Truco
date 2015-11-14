import fiuba.algo3.modelo.*;
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
        mesa.seCantaTruco();
        mesa.seAceptaTruco();
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
}
