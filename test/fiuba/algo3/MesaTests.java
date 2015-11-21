package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.*;
import fiuba.algo3.manejoDeJugadores.Equipo;
import fiuba.algo3.manejoDeJugadores.Jugador;
import fiuba.algo3.manejoDeJugadores.ListaJugadores;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Fechee on 21/11/2015.
 */
public class MesaTests {
    Juego juego;
    Jugador jugador1,jugador2;
    ListaJugadores jugadores;
    Mesa mesa;
    Mazo mazo;

    @Before
    public void setup(){
        juego = new Juego();
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");

        jugadores = new ListaJugadores();
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        juego.configurarManejadorDeTurnos();


        Palo espada = new PaloEspada();
        Palo oro = new PaloOro();
        Palo basto = new PaloBasto();
        Palo copa = new PaloCopa();

        jugador1.recibirCarta(new Carta(1,basto));      //CARTA POS 0
        jugador1.recibirCarta(new Carta(7,espada));        //CARTA POS 1
        jugador1.recibirCarta(new Carta(3,copa));        //CARTA POS 2

        jugador2.recibirCarta(new Carta(1,espada));           //CARTA POS 0
        jugador2.recibirCarta(new Carta(3,basto));          //CARTA POS 1
        jugador2.recibirCarta(new Carta(6,copa));             //CARTA POS 2
    }




    @Test
    public void test(){

        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(0);
        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(0);

        Assert.assertTrue(1==jugador2.getEquipo().getManosGanadas());

        //termino la primer mano o VUELTA

        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(1);
        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(1);

        Assert.assertTrue(1==jugador2.getEquipo().getManosGanadas());



    }
}
