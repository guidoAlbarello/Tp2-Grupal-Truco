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
        jugador1.setJuego(juego);
        juego.agregarJugador(jugador1);
        jugador2.setJuego(juego);
        juego.agregarJugador(jugador2);

        juego.configurarManejadorDeTurnos();

    }

    @Test
    public void seJuegaUnaCartaEnEstadoPrimeraManoYEstaSeguardaEnMesa() {

        Palo unPalo = new PaloEspada();
        Carta carta = new Carta(2, unPalo);
        CartaJugada cartaJugada = new CartaJugada(carta, jugador1);
        jugador1.jugarCarta(cartaJugada);
        Assert.assertTrue(juego.mesaDelJuego().listaDeCartasJugadas().size() == 1);
    }
    @Test
    public void seRepartenCartasAJugadoresYCadaUnoTiene3Cartas() {


        juego.repartirCartasAJugadores();
        Assert.assertEquals(3, jugador1.getMano().getCartasEnMano().size()); // me aseguro que ambos jugadores recibieron cartas
        Assert.assertEquals(3, jugador2.getMano().getCartasEnMano().size()); // me aseguro que ambos jugadores recibieron cartas
    }
    @Test
    public void unJugador1CantaEnvidoYJugador2NoQuiereEntoncesJugador1Suma1Punto(){

        juego.repartirCartasAJugadores();
        jugador1.envido();
        jugador2.noQuiero(); //PARA MI ESTO NO TIENE QUE SER ASI...
        //tiene que ser asi
        //juego.seCantaEnvido();
        //juego.noSeQuizoEnvido();
        Assert.assertTrue( jugador1.getEquipo().getPuntaje() == 1);
    }





    @Test
    public void cadaJugadorJuegaUnaCartaYSeDevuelveElJugadorGanador(){
        Palo paloEspada = new PaloEspada();
        Carta carta1Espada = new Carta(1,paloEspada);
        Carta carta4Espada = new Carta(4,paloEspada);
        CartaJugada cartaDeJugador1 = new CartaJugada(carta1Espada,jugador1);
        CartaJugada cartaDeJugador2 = new CartaJugada(carta4Espada,jugador2);

        jugador1.jugarCarta(cartaDeJugador1);
        jugador2.jugarCarta(cartaDeJugador2);

        Assert.assertEquals("jugador1" ,this.juego.mesaDelJuego().ganadorDeMano().getNombre());
    }

    @Test
    public void seCantaTrucoEnLaPrimeraManoYelSegundoJugadorCantaElEnvidoYElQueCantTrucoNoQuiere(){

        jugador1.truco();
        jugador2.envido();
        jugador1.noQuiero();

        Assert.assertEquals(jugador2.getEquipo().getPuntaje(),1);
    }




}
