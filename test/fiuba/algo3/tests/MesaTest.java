import fiuba.algo3.modelo.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 13/11/2015.
 */
public class MesaTest {

    @Test
    public void determinarGanadorDeRonda(){
        Cantos cantos = new CantosSinFlor();
        JugadorEnRonda jugador1 = new JugadorEnRonda(new Jugador("jugador1",cantos));
        JugadorEnRonda jugador2 = new JugadorEnRonda(new Jugador("jugador2",cantos));
        ManejadorDeTurnos turnos = new ManejadorDeTurnos(jugador1,jugador2);
        Mesa mesa = new Mesa(jugador1,jugador2,turnos);
        Mazo mazo = new Mazo();
        mazo.mezclarMazo();
        mazo.repartirCartasAJugador(jugador1.getJugador());
        mazo.repartirCartasAJugador(jugador2.getJugador());
        mesa.seJuegaUnaCarta(1); //ese uno SIGNIFICA QUE EL JUGDOR ESTA TIRANDO LA PRIMER CARTA QUE TIENE EN LA MANO
        turnos.pasarTurnoEnMano();
        mesa.seJuegaUnaCarta(1);
        JugadorEnRonda jugadorQueGanoLaMano = mesa.compararCartas();
        if (mesa.terminoLaMano()){   jugadorQueGanoLaMano.aumentarManosGanadas(); }

        Assert.assertEquals(1,jugadorQueGanoLaMano.getManosGanadas());
    }
}
