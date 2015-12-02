package fiuba.algo3;

import fiuba.algo3.Modelo.Juego.Juego;
import fiuba.algo3.Modelo.ModeladoDeCarta.*;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 19/11/2015.
 */
public class JuegoTest {
    private Juego juego;
    private Jugador jugador1;
    private Jugador jugador2;
    private PaloEspada paloEspada;
    private PaloBasto paloBasto;
    private PaloOro paloOro;
    private PaloCopa paloCopa;

    @Before
    public void setup(){
        juego = new Juego();
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador1.setJuego(juego);
        juego.agregarJugador(jugador1);
        jugador2.setJuego(juego);
        juego.agregarJugador(jugador2);
        juego.configurarManejadorDeTurnos();
        paloEspada = new PaloEspada();
        paloBasto = new PaloBasto();
        paloOro = new PaloOro();
        paloCopa = new PaloCopa();
    }

    @Test
    public void seJuegaUnaCartaEnEstadoPrimeraManoYEstaSeguardaEnMesa() {
        Carta carta = new Carta(2, paloEspada);
        CartaJugada cartaJugada = new CartaJugada(carta, jugador1);
        jugador1.jugarCarta(cartaJugada);
        Assert.assertTrue(juego.getMesaDelJuego().listaDeCartasJugadas().size() == 1);
    }
    @Test
    public void seRepartenCartasAJugadoresYCadaUnoTiene3Cartas() {
        juego.repartirCartasAJugadores();
        Assert.assertEquals(3, jugador1.getMano().getCartasEnMano().size()); // me aseguro que ambos configJugadores recibieron cartas
        Assert.assertEquals(3, jugador2.getMano().getCartasEnMano().size()); // me aseguro que ambos configJugadores recibieron cartas
    }
    @Test
    public void unJugador1CantaEnvidoYJugador2NoQuiereEntoncesJugador1Suma1Punto(){
        juego.repartirCartasAJugadores();
        jugador1.envido();
        jugador2.noQuiero();
        Assert.assertEquals(1, jugador1.getEquipo().getPuntaje());
    }

    @Test
    public void cadaJugadorJuegaUnaCartaYSeDevuelveElJugadorGanadorDeMano(){
        Carta carta1Espada = new Carta(1,paloEspada);
        Carta carta4Espada = new Carta(4,paloEspada);
        jugador1.recibirCarta(carta1Espada);
        jugador2.recibirCarta(carta4Espada);

        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        Assert.assertTrue(jugador1.getEquipo().getManosGanadas() == 1);
    }

    @Test
    public void seCantaTrucoEnLaPrimeraManoYelSegundoJugadorCantaElEnvidoYElQueCantTrucoNoQuiere(){
        jugador1.truco();
        jugador2.envido();
        jugador1.noQuiero();
        Assert.assertEquals(jugador2.getEquipo().getPuntaje(), 1);
    }

    @Test
    public void testEnvidoQuerido(){
        jugador1.recibirCarta(new Carta(11,paloOro));
        jugador1.recibirCarta(new Carta(5,paloBasto));
        jugador1.recibirCarta(new Carta(6,paloBasto));          // ENVIDO SUPUESTO 31

        jugador2.recibirCarta(new Carta(7,paloEspada));
        jugador2.recibirCarta(new Carta(3,paloBasto));
        jugador2.recibirCarta(new Carta(6, paloEspada));          //ENVIDO SUPUESTO 33

        jugador1.envido();
        jugador2.quiero();
        Assert.assertEquals(2,jugador2.getEquipo().getPuntaje());
    }

    @Test
    public void testEnvidoEnvidoQuerido(){
        jugador1.recibirCarta(new Carta(11,paloOro));
        jugador1.recibirCarta(new Carta(5,paloBasto));
        jugador1.recibirCarta(new Carta(6,paloBasto));          // ENVIDO SUPUESTO 31

        jugador2.recibirCarta(new Carta(7, paloEspada));
        jugador2.recibirCarta(new Carta(3, paloBasto));
        jugador2.recibirCarta(new Carta(6, paloEspada));          //ENVIDO SUPUESTO 33

        jugador1.envido();
        jugador2.envido();
        jugador1.quiero();
        Assert.assertEquals(4,jugador2.getEquipo().getPuntaje());
    }
    @Test
    public void testRealEnvidoQuerido(){
        jugador1.recibirCarta(new Carta(11,paloOro));
        jugador1.recibirCarta(new Carta(5,paloBasto));
        jugador1.recibirCarta(new Carta(6,paloBasto));          // ENVIDO SUPUESTO 31

        jugador2.recibirCarta(new Carta(7,paloEspada));
        jugador2.recibirCarta(new Carta(3,paloBasto));
        jugador2.recibirCarta(new Carta(6, paloEspada));          //ENVIDO SUPUESTO 33

        jugador1.realEnvido();
        jugador2.quiero();
        Assert.assertEquals(3,jugador2.getEquipo().getPuntaje());
    }

    @Test
    public void seJueganCartasSinCantarNadaYAlGanadorDeLaRondaSeLeSuma1Punto(){
        jugador1.recibirCarta(new Carta(11,paloOro));
        jugador1.recibirCarta(new Carta(5,paloBasto));
        jugador1.recibirCarta(new Carta(6,paloBasto));          // ENVIDO SUPUESTO 31

        jugador2.recibirCarta(new Carta(7,paloBasto));
        jugador2.recibirCarta(new Carta(6,paloOro));
        jugador2.recibirCarta(new Carta(3,paloEspada));          //ENVIDO SUPUESTO 33

        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(2);
        jugador1.jugarCartaEnPosicion(2);

        Assert.assertEquals(1,jugador2.getEquipo().getPuntaje());
    }

    @Test
    public void seCantaUnEnvidoYLuegoSeJueganCartasJugador1Gana2PuntosDelEnvidoYjuagdor2GanaLaRonda(){
        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5,paloBasto)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloBasto));  //carta en posicion 2
        // ENVIDO = 31
        jugador2.recibirCarta(new Carta(7,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3,paloEspada));   //carta en posicion 2
        //ENVIDO = 7

        jugador1.envido();
        jugador2.quiero();
        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(2);
        jugador1.jugarCartaEnPosicion(2);

        Assert.assertEquals(1, jugador2.getEquipo().getPuntaje());
        Assert.assertEquals(2,jugador1.getEquipo().getPuntaje());
    }

    @Test
    public void seCantaTrucoYSeAceptaAlfinalDeLarondaElGanadorSeLleva2Puntos(){
        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5,paloBasto)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloBasto));  //carta en posicion 2
        // ENVIDO = 31
        jugador2.recibirCarta(new Carta(7,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3, paloEspada));   //carta en posicion 2
        //ENVIDO = 7


        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);
        jugador2.truco();
        jugador1.quiero();
        jugador2.jugarCartaEnPosicion(2);
        jugador1.jugarCartaEnPosicion(2);

        Assert.assertEquals(2,jugador2.getEquipo().getPuntaje());
    }

    @Test
    public void seCantaTrucoYLuegoRetrucoSeAceptaAlfinalDeLarondaElGanadorSeLleva3Puntos(){
        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5,paloBasto)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloBasto));  //carta en posicion 2
        // ENVIDO = 31
        jugador2.recibirCarta(new Carta(7,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3,paloEspada));   //carta en posicion 2
        //ENVIDO = 7


        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);
        jugador2.truco();
        jugador1.retruco();
        jugador2.quiero();
        jugador2.jugarCartaEnPosicion(2);
        jugador1.jugarCartaEnPosicion(2);

        Assert.assertEquals(3,jugador2.getEquipo().getPuntaje());
    }

    @Test
    public void seCantaTrucoYLuegoRetrucoYLuegoUnVale4SeAceptaAlfinalDeLarondaElGanadorSeLleva4Puntos(){
        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5,paloBasto)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloBasto));  //carta en posicion 2
        // ENVIDO = 31
        jugador2.recibirCarta(new Carta(7,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3,paloEspada));   //carta en posicion 2
        //ENVIDO = 7

        jugador1.truco();
        jugador2.retruco();
        jugador1.quiero();
        jugador2.jugarCartaEnPosicion(0);
        jugador1.jugarCartaEnPosicion(0);
        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);

        jugador2.valeCuatro();
        jugador1.quiero();
        jugador2.jugarCartaEnPosicion(2);
        jugador1.jugarCartaEnPosicion(2);

        Assert.assertEquals(4,jugador2.getEquipo().getPuntaje());
    }

    @Test
    public void jugador1CantaTrucoYJugador2AceptaDespuesDeTirarUnasCartasJugador2SeVaAlMasoEntoncesJugador1SeLlevaLosPuntosDelTruco(){
        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5, paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6, paloBasto));  //carta en posicion 2
        // ENVIDO = 31
        jugador2.recibirCarta(new Carta(7, paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6, paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3, paloOro));   //carta en posicion 2
        //ENVIDO = 7

        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador1.truco();
        jugador2.quiero();
        jugador1.jugarCartaEnPosicion(1);
        jugador2.meVoyAlMaso();

        Assert.assertEquals(2,jugador1.getEquipo().getPuntaje());
    }

    @Test
    public void rondaCompletaPara2Jugadores(){
        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5,paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloBasto));  //carta en posicion 2
        // ENVIDO = 11
        jugador2.recibirCarta(new Carta(7,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6,paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3,paloOro));   //carta en posicion 2
        //ENVIDO = 29

        jugador1.envido();
        jugador2.envido();
        jugador1.quiero();
        Assert.assertEquals(4,jugador2.getEquipo().getPuntaje());
        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);
        jugador1.truco();
        jugador2.retruco();
        jugador1.quiero();
        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(2);
        jugador1.valeCuatro();
        jugador2.quiero();
        jugador1.jugarCartaEnPosicion(2);

        Assert.assertEquals(8,jugador2.getEquipo().getPuntaje());
    }

    @Test
    public void testPasaManoyReparteCartasCuandoTerminaRonda(){

        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5, paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6, paloBasto));  //carta en posicion 2

        jugador2.recibirCarta(new Carta(10, paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6, paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3, paloOro));   //carta en posicion 2

        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);

        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);

        jugador2.jugarCartaEnPosicion(2);// aca vuelve a jugar el juagdor 2 por que gano la mano anterior
        jugador1.jugarCartaEnPosicion(2);

        //suma 1 pt por ganar ronda
        Assert.assertEquals(1, jugador2.getEquipo().getPuntaje());

        //termina la ronda y el jugador2, ahora es mano
        Assert.assertEquals(jugador2, juego.manejadorDeTurnos.getJugadorQueEsMano());

        //Verifico que cuando la ronda termino se repartieron las cartas
        Assert.assertEquals(3, jugador1.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador2.getMano().getCartasEnMano().size());
    }

    @Test
    public void testPrimerManoEmpardadaYSegundaDefinida(){

        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5,paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6,paloBasto));  //carta en posicion 2

        jugador2.recibirCarta(new Carta(11,paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6, paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3, paloOro));   //carta en posicion 2

        jugador1.jugarCartaEnPosicion(0);
        jugador2.jugarCartaEnPosicion(0);

        jugador1.jugarCartaEnPosicion(1);
        jugador2.jugarCartaEnPosicion(1);

        //suma 1 pt por ganar ronda
        Assert.assertEquals(1,jugador2.getEquipo().getPuntaje());

        //termina la ronda y el jugador2, ahora es mano
        Assert.assertEquals(jugador2,juego.manejadorDeTurnos.getJugadorQueEsMano());

        //Verifico que cuando la ronda termino se repartieron las cartas
        Assert.assertEquals(3,jugador1.getMano().getCartasEnMano().size());
        Assert.assertEquals(3,jugador2.getMano().getCartasEnMano().size());
    }

    @Test
    public void seCantaFaltaEnvidoAlComienzoDeLaPartidaYElGanadorSuma30Puntos(){
        //ENVIDO 11
        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5, paloCopa)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6, paloBasto));  //carta en posicion 2
        //ENVIDO 29
        jugador2.recibirCarta(new Carta(11, paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6, paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3, paloOro));   //carta en posicion 2

        jugador1.faltaEnvido();
        jugador2.quiero();

        Assert.assertEquals(30,jugador2.getEquipo().getPuntaje());
    }

    @Test
    public void seCantaFlorySiElOtroNoTieneSeSuma3PuntosSinPasarElTurno(){

        jugador1.recibirCarta(new Carta(11,paloOro));  //carta en posicion 0
        jugador1.recibirCarta(new Carta(5, paloOro)); //carta en posicion 1
        jugador1.recibirCarta(new Carta(6, paloOro));  //carta en posicion 2

        jugador2.recibirCarta(new Carta(11, paloBasto));   //carta en posicion 0
        jugador2.recibirCarta(new Carta(6, paloOro));      //carta en posicion 1
        jugador2.recibirCarta(new Carta(3, paloOro));   //carta en posicion 2

        jugador1.flor();

        Assert.assertEquals(3,jugador1.getEquipo().getPuntaje());
        Assert.assertEquals(juego.manejadorDeTurnos.getJugadorConTurnoActual().getNombre(),"jugador1");
    }
}
