package fiuba.algo3;

import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;
import fiuba.algo3.Modelo.manejoDeJugadores.ListaJugadores;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Fechee on 18/11/2015.
 */
public class ListaJugadoresTests {
    private ListaJugadores jugadores;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Jugador jugador4;

    @Before
    public void setup(){
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");
        jugador4 = new Jugador("jugador4");
        jugadores = new ListaJugadores();
    }


    @Test
    public void test(){
;

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

    @Test
    public void seObtieneNodoDeJugadorConElJugador(){
        jugadores.agregarUltimo(jugador1);
        jugadores.agregarUltimo(jugador2);
        jugadores.agregarUltimo(jugador3);
        jugadores.agregarUltimo(jugador4);

        Assert.assertTrue(jugadores.buscarNodoJugadorPorJugador(jugador3).getSiguiente().getJugador()==jugador4);
    }
}
