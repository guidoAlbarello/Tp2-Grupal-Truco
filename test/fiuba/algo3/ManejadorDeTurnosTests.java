package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.*;
import fiuba.algo3.manejoDeJugadores.Equipo;
import fiuba.algo3.manejoDeJugadores.Jugador;
import fiuba.algo3.manejoDeJugadores.ListaJugadores;
import fiuba.algo3.manejoDeJugadores.ManejadorDeTurnos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Fechee on 19/11/2015.
 */
public class ManejadorDeTurnosTests {
    Juego juego;
    ManejadorDeTurnos turnos;
    Jugador jugador1,jugador2,jugador3,jugador4;



    @Before
    public void inicializar(){
        juego = new Juego();


        // CREO LOS JUGADORES
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");
        jugador4 = new Jugador("jugador4");

        //LOS METO EN LA LISTA CIRCULAR CUSTOMIZADA
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
        //juego.agregarJugador(jugador3);
        //juego.agregarJugador(jugador4);

        juego.configurarManejadorDeTurnos();


        Palo espada = new PaloEspada();
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
    public void testElJugadorConElTurnoInicialEsElPrimeroQueSeAgrego(){
        ListaJugadores estosJugadores = new ListaJugadores();
        estosJugadores.agregarUltimo(jugador1);
        estosJugadores.agregarUltimo(jugador2);


        ManejadorDeTurnos turnos = new ManejadorDeTurnos(estosJugadores,null);  //le paso null en lugar de un juego para testear unitariamente pasar mano
        Assert.assertEquals(jugador1,turnos.getJugadorConTurnoActual());

        Assert.assertEquals(jugador2,turnos.getJugadorSiguienteAlTurnoActual());
        Assert.assertEquals(jugador2,turnos.getJugadorAnteriorAlTurnoActual());
    }

    @Test
    public void testElJugadorQueEsManoAlPrincipioEsElPrimeroQueSeAgrego(){
        ListaJugadores estosJugadores = new ListaJugadores();
        estosJugadores.agregarUltimo(jugador1);
        estosJugadores.agregarUltimo(jugador2);


        ManejadorDeTurnos turnos = new ManejadorDeTurnos(estosJugadores,null);  //le paso null en lugar de un juego para testear unitariamente pasar mano
        Assert.assertEquals(jugador1,turnos.getJugadorQueEsMano());
    }


/*
    @Test
    public void testPasarTurnoEnUnaManoCompleta(){
        //DOY UNA VUELTA EN LA MESA (una mano completa)

        Assert.assertTrue(1==turnos.getManoActual());
        turnos.pasarElTurno();
        Assert.assertEquals(jugador2,turnos.getJugadorConTurnoActual());

        turnos.pasarElTurno();
        Assert.assertEquals(jugador3,turnos.getJugadorConTurnoActual());

        turnos.pasarElTurno();
        Assert.assertEquals(jugador4,turnos.getJugadorConTurnoActual());
        Assert.assertTrue(1==turnos.getRondaActual());

        turnos.pasarElTurno();
        Assert.assertEquals(jugador1,turnos.getJugadorConTurnoActual());
        Assert.assertTrue(2==turnos.getManoActual());
    }
*/
/*
    @Test
    public void testPasarTurnoEnUnaRondaCompleta(){
        //DOY UNA VUELTA EN LA MESA (una mano completa)

        turnos.pasarElTurno();

        turnos.pasarElTurno();

        turnos.pasarElTurno();

        turnos.pasarElTurno();
        Assert.assertEquals(2,turnos.getManoActual());
        //--------------------------------------- COMIENZA SEGUNDA MANO
        turnos.pasarElTurno();

        turnos.pasarElTurno();

        turnos.pasarElTurno();

        turnos.pasarElTurno();
        Assert.assertEquals(3,turnos.getManoActual());
        //--------------------------------------- COMIENZA ULTIMA MANO
        turnos.pasarElTurno();

        turnos.pasarElTurno();

        turnos.pasarElTurno();

        turnos.pasarElTurno();
        Assert.assertEquals(1,turnos.getManoActual());//SE VERIFICA QUE TERMINO LA ULTIMA MANO Y SE PASA A OTRA RONDA
        Assert.assertTrue(2==turnos.getRondaActual());
    }


*/
    @Test
    public void testPasarTurno(){
        ListaJugadores estosJugadores = new ListaJugadores();
        estosJugadores.agregarUltimo(jugador1);
        estosJugadores.agregarUltimo(jugador2);
        ManejadorDeTurnos turnos = new ManejadorDeTurnos(estosJugadores,null);  //le paso null en lugar de un juego para testear unitariamente pasar mano


        Assert.assertEquals(jugador1,turnos.getJugadorConTurnoActual());

        Assert.assertEquals(jugador2,turnos.getJugadorSiguienteAlTurnoActual());

        turnos.pasarElTurno();

        Assert.assertEquals(jugador2,turnos.getJugadorConTurnoActual());

        Assert.assertEquals(jugador1,turnos.getJugadorSiguienteAlTurnoActual());
    }


    @Test
    public void testPasarMano() {
        ListaJugadores estosJugadores = new ListaJugadores();
        estosJugadores.agregarUltimo(jugador1);
        estosJugadores.agregarUltimo(jugador2);
        ManejadorDeTurnos turnos = new ManejadorDeTurnos(estosJugadores, null);  //le paso null en lugar de un juego para testear unitariamente pasar mano

        turnos.pasarMano();

        Assert.assertEquals(jugador2,turnos.getJugadorConTurnoActual());
        Assert.assertEquals(jugador2,turnos.getJugadorQueEsMano());

    }








    @Test
    public void testSimulacionPartidaSinCantosDosJugadores(){
        Equipo equipoDelJugador1, equipoDelJugador2;
        equipoDelJugador1 = jugador1.getEquipo();
        equipoDelJugador2 = jugador2.getEquipo();

        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(0); // 1 BASTO
        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(0); //1 ESPADA

        Assert.assertTrue(equipoDelJugador2.getManosGanadas()==1);

        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(1); // 7 ESPADA
        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(1); // 3 BASTO

        Assert.assertTrue(equipoDelJugador1.getManosGanadas()==1 & equipoDelJugador2.getManosGanadas()==1);

        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(2); //3 COPA
        juego.seJuegaUnaCartaDeLaManoDelJugadorEnPosicion(2); // 6 COPA

        Assert.assertTrue(equipoDelJugador1.getPuntaje()==1);
    }

}
