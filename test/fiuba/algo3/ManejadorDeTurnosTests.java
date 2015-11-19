package fiuba.algo3;

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
    ManejadorDeTurnos turnos;
    Jugador jugador1,jugador2,jugador3,jugador4;

    @Before
    public void inicializar(){
        // CREO LOS JUGADORES
        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");
        jugador4 = new Jugador("jugador4");

        //LOS METO EN LA LISTA CIRCULAR CUSTOMIZADA
        ListaJugadores jugadores = new ListaJugadores();
        jugadores.agregarUltimo(jugador1);
        jugadores.agregarUltimo(jugador2);
        jugadores.agregarUltimo(jugador3);
        jugadores.agregarUltimo(jugador4);


        //CREO EL MANEJADOR DE TURNOS Y LE PASO LA LISTA
        this.turnos = new ManejadorDeTurnos(jugadores);
    }

    @Test
    public void testElJugadorConElTurnoInicialEsElPrimeroQueSeAgrego(){
        Assert.assertEquals(jugador1,turnos.getJugadorConTurnoActual());
    }

    @Test
    public void testElJugadorQueEsManoAlPrincipioEsElPrimeroQueSeAgrego(){
        Assert.assertEquals(jugador1,turnos.getJugadorQueEsMano());
    }

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



    @Test
    public void testPasarMano(){
        turnos.pasarMano(); //pasar mano se supone a llamar cuando termine la ronda
        Assert.assertEquals(jugador2,turnos.getJugadorConTurnoActual());
        Assert.assertTrue(turnos.getNumeroDeManoActual()==1);
        Assert.assertTrue(turnos.getRondaActual()==2);
    }

}
