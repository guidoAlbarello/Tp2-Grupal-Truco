package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.*;
import fiuba.algo3.manejoDeJugadores.Equipo;
import fiuba.algo3.manejoDeJugadores.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Fechee on 24/11/2015.
 */
public class TestRondaCuatroJugadores {
    private Juego juego;
    private Jugador jugador1,jugador2,jugador3,jugador4;
    private PaloEspada paloEspada;
    private PaloBasto paloBasto;
    private PaloOro paloOro;
    private PaloCopa paloCopa;

    @Before
    public void setup(){
        juego = new Juego();

        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");
        jugador4 = new Jugador("jugador4");

        jugador1.setJuego(juego);
        juego.agregarJugador(jugador1);
        jugador2.setJuego(juego);
        juego.agregarJugador(jugador2);
        jugador3.setJuego(juego);
        juego.agregarJugador(jugador3);
        jugador4.setJuego(juego);
        juego.agregarJugador(jugador4);
        juego.configurarManejadorDeTurnos();

        paloEspada = new PaloEspada();
        paloBasto = new PaloBasto();
        paloOro = new PaloOro();
        paloCopa = new PaloCopa();
    }

    @Test
    public void testRondaCuatroJugadores(){

        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(3,paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloOro));  //carta en posicion 2            ENVIDO = 29

        jugador2.recibirCarta(new Carta(11,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloBasto));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3,paloOro));   //carta en posicion 2           ENVIDO = 26

        jugador3.recibirCarta(new Carta(11,paloEspada));   //carta en posicion 0
        jugador3.recibirCarta(new Carta(6,paloEspada));      //carta en posicion 1
        jugador3.recibirCarta(new Carta(3,paloEspada));   //carta en posicion 2           ENVIDO = 29

        jugador4.recibirCarta(new Carta(11,paloCopa));   //carta en posicion 0
        jugador4.recibirCarta(new Carta(7,paloCopa));      //carta en posicion 1
        jugador4.recibirCarta(new Carta(4,paloCopa));   //carta en posicion 2             ENVIDO = 31

        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador3.jugarCartaEnPosicion(0);
        jugador4.envido();
        jugador1.quiero();
        Assert.assertEquals(2,jugador4.getEquipo().getPuntaje());
        jugador4.jugarCartaEnPosicion(0);

        Assert.assertEquals(jugador1,juego.manejadorDeTurnos.getJugadorConTurnoActual());

        Assert.assertTrue(1==juego.getMesaDelJuego().getEmparde().getEquipo().getManosGanadas());  //PRIMER MANO SE EMPARDA

        jugador1.truco();
        jugador2.quiero();
        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);
        jugador3.jugarCartaEnPosicion(1);
        jugador4.retruco();
        jugador1.quiero();
        jugador4.jugarCartaEnPosicion(1);

        Assert.assertEquals(3,jugador1.getEquipo().getPuntaje());
        Assert.assertEquals(3,jugador3.getEquipo().getPuntaje());

        Assert.assertEquals(jugador2,juego.manejadorDeTurnos.getJugadorQueEsMano());

        //Verifico que cuando la ronda termino se repartieron las cartas
        Assert.assertEquals(3,jugador1.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador2.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador3.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador4.getMano().getCartasEnMano().size());
    }


    @Test
    public void SinEmparde(){

        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(3,paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloOro));  //carta en posicion 2            ENVIDO = 29

        jugador2.recibirCarta(new Carta(11,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloBasto));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3,paloOro));   //carta en posicion 2           ENVIDO = 26

        jugador3.recibirCarta(new Carta(3,paloEspada));   //carta en posicion 0
        jugador3.recibirCarta(new Carta(6,paloEspada));      //carta en posicion 1
        jugador3.recibirCarta(new Carta(11,paloEspada));   //carta en posicion 2           ENVIDO = 29

        jugador4.recibirCarta(new Carta(11,paloCopa));   //carta en posicion 0
        jugador4.recibirCarta(new Carta(7,paloCopa));      //carta en posicion 1
        jugador4.recibirCarta(new Carta(4,paloCopa));   //carta en posicion 2             ENVIDO = 31

        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador3.jugarCartaEnPosicion(0);
        jugador4.envido();
        jugador1.quiero();
        Assert.assertEquals(2,jugador4.getEquipo().getPuntaje());
        jugador4.jugarCartaEnPosicion(0);

        Assert.assertEquals(jugador3,juego.manejadorDeTurnos.getJugadorConTurnoActual());

        Assert.assertTrue(1 == jugador1.getEquipo().getManosGanadas());

        jugador3.truco();
        jugador4.quiero();
        jugador3.jugarCartaEnPosicion(1);
        jugador4.jugarCartaEnPosicion(1);
        jugador1.jugarCartaEnPosicion(1);
        jugador2.retruco();
        jugador3.quiero();
        jugador2.jugarCartaEnPosicion(1);

        Assert.assertEquals(3,jugador1.getEquipo().getPuntaje());
        Assert.assertEquals(3,jugador3.getEquipo().getPuntaje());

        Assert.assertEquals(jugador2,juego.manejadorDeTurnos.getJugadorQueEsMano());

        //Verifico que cuando la ronda termino se repartieron las cartas
        Assert.assertEquals(3,jugador1.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador2.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador3.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador4.getMano().getCartasEnMano().size());
    }

    @Test
    public void testFinal(){

        jugador1.recibirCarta(new Carta(1,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(4,paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloOro));  //carta en posicion 2            ENVIDO = 27

        jugador2.recibirCarta(new Carta(11,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloBasto));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(4,paloOro));   //carta en posicion 2           ENVIDO = 26

        jugador3.recibirCarta(new Carta(3,paloEspada));   //carta en posicion 0
        jugador3.recibirCarta(new Carta(6,paloEspada));      //carta en posicion 1
        jugador3.recibirCarta(new Carta(11,paloEspada));   //carta en posicion 2           ENVIDO = 29

        jugador4.recibirCarta(new Carta(11,paloCopa));   //carta en posicion 0
        jugador4.recibirCarta(new Carta(7,paloCopa));      //carta en posicion 1
        jugador4.recibirCarta(new Carta(5,paloCopa));   //carta en posicion 2             ENVIDO = 32

        jugador1.envido();
        jugador2.envido();
        jugador1.realEnvido();
        jugador2.quiero();
        Assert.assertEquals(jugador1,juego.manejadorDeTurnos.getJugadorConTurnoActual());
        Assert.assertTrue(7 == jugador2.getEquipo().getPuntaje());
        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador3.jugarCartaEnPosicion(0);
        jugador4.jugarCartaEnPosicion(0);

        Assert.assertEquals(jugador3,juego.manejadorDeTurnos.getJugadorConTurnoActual());
        Assert.assertTrue(1 == jugador3.getEquipo().getManosGanadas());

        jugador3.truco();
        jugador4.quiero();
        jugador3.jugarCartaEnPosicion(1);
        jugador4.jugarCartaEnPosicion(1);
        jugador1.jugarCartaEnPosicion(1);
        jugador2.retruco();
        jugador3.quiero();
        jugador2.jugarCartaEnPosicion(1);

        Assert.assertEquals(jugador4,juego.manejadorDeTurnos.getJugadorConTurnoActual());
        Assert.assertTrue(1 == jugador4.getEquipo().getManosGanadas());

        jugador4.jugarCartaEnPosicion(2);
        jugador1.jugarCartaEnPosicion(2);
        jugador2.jugarCartaEnPosicion(2);
        jugador3.jugarCartaEnPosicion(2);

        Assert.assertEquals(7,jugador2.getEquipo().getPuntaje());
        Assert.assertEquals(3,jugador1.getEquipo().getPuntaje());

        Assert.assertEquals(jugador2,juego.manejadorDeTurnos.getJugadorQueEsMano());

        //Verifico que cuando la ronda termino se repartieron las cartas
        Assert.assertEquals(3,jugador1.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador2.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador3.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador4.getMano().getCartasEnMano().size());
    }
    @Test
    public void testSeCantaDirectamenteUnRealEnvidoYdespuesSeVaAlMaso(){

        jugador1.recibirCarta(new Carta(1,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(4,paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloOro));  //carta en posicion 2            ENVIDO = 27

        jugador2.recibirCarta(new Carta(11,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloBasto));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(4,paloOro));   //carta en posicion 2           ENVIDO = 26

        jugador3.recibirCarta(new Carta(3,paloEspada));   //carta en posicion 0
        jugador3.recibirCarta(new Carta(6,paloEspada));      //carta en posicion 1
        jugador3.recibirCarta(new Carta(11,paloEspada));   //carta en posicion 2           ENVIDO = 29

        jugador4.recibirCarta(new Carta(11,paloCopa));   //carta en posicion 0
        jugador4.recibirCarta(new Carta(7,paloCopa));      //carta en posicion 1
        jugador4.recibirCarta(new Carta(5,paloCopa));   //carta en posicion 2             ENVIDO = 32

        jugador1.realEnvido();
        jugador2.quiero();
        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador3.jugarCartaEnPosicion(0);
        jugador4.meVoyAlMaso();

        Assert.assertEquals(3,jugador4.getEquipo().getPuntaje());
        Assert.assertEquals(1,jugador1.getEquipo().getPuntaje());
        Assert.assertEquals(jugador2,juego.manejadorDeTurnos.getJugadorQueEsMano());
        Assert.assertEquals(jugador2,juego.manejadorDeTurnos.getJugadorConTurnoActual());

    }


}
