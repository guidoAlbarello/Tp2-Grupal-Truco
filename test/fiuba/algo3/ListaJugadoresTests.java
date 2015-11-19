package fiuba.algo3;

import fiuba.algo3.manejoDeJugadores.Jugador;
import fiuba.algo3.manejoDeJugadores.ListaJugadores;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fechee on 18/11/2015.
 */
public class ListaJugadoresTests {


    @Test
    public void test(){
        Jugador jugador1 = new Jugador("jugador1");
        Jugador jugador2 = new Jugador("jugador2");
        Jugador jugador3 = new Jugador("jugador3");
        Jugador jugador4 = new Jugador("jugador4");

        ListaJugadores jugadores = new ListaJugadores();

        jugadores.agregarUltimo(jugador1);
        Assert.assertEquals(jugador1,jugadores.getUltimo().getJugador());

        jugadores.agregarUltimo(jugador2);
        Assert.assertEquals(jugador2,jugadores.getUltimo().getJugador());

        jugadores.agregarUltimo(jugador3);
        Assert.assertEquals(jugador3,jugadores.getUltimo().getJugador());

        jugadores.agregarUltimo(jugador4);
        Assert.assertEquals(jugador4,jugadores.getUltimo().getJugador());


        // ESTA PENSADO PARA EL CASO QUE SE QUIERA RECORRER CON UN FOR COMENZANDO DESDE CERO (0)...
        Assert.assertEquals(jugadores.getJugadorEnPosicion(0),jugador1);
        Assert.assertEquals(jugadores.getJugadorEnPosicion(1),jugador2);
        Assert.assertEquals(jugadores.getJugadorEnPosicion(2),jugador3);
        Assert.assertEquals(jugadores.getJugadorEnPosicion(3),jugador4);




    }
}
