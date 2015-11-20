package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.ModeladoDeCarta.Palo;
import fiuba.algo3.ModeladoDeCarta.PaloEspada;
import fiuba.algo3.manejoDeJugadores.Equipo;
import fiuba.algo3.manejoDeJugadores.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 19/11/2015.
 */
public class JuegoTest {
    private Juego juego;
    private Equipo equipo1;
    private Equipo equipo2;
    private Jugador jugador1;
    private Jugador jugador2;
    private Mesa mesaDeJuego;

    @Before
    public void setup(){
        juego = new Juego();
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        equipo1 = new Equipo("equipo1");
        equipo2 = new Equipo("equipo2");
        equipo1.agregarJugador(jugador1);
        equipo2.agregarJugador(jugador2);
        mesaDeJuego = new Mesa();


    }

    @Test
    public void seJuegaUnaCartaEnEstadoPrimeraManoYEstaSeguardaEnMesa(){
        Palo unPalo = new PaloEspada();
        Carta carta = new Carta(2, unPalo);
        CartaJugada cartaJugada = new CartaJugada(carta,jugador1);
        juego.jugarCarta(cartaJugada);
        Assert.assertTrue(juego.mesaDelJuego().listaDeCartasJugadas().size() == 1);

  /*  }@Test
    public void unJugador1CantaEnvidoYJugador2NoQuiereEntoncesJugador1Suma1Punto(){
        jugador1.setJuego(juego);

        jugador2.setJuego(juego);
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        juego.repartirCartasAJugadores();
        jugador1.envido();

        jugador2.noQuiero();

        Assert.assertTrue( jugador1.getEquipo().getPuntaje() == 1);

*/


    }



}
