package fiuba.algo3;

import fiuba.algo3.manejoDeJugadores.Equipo;
import fiuba.algo3.manejoDeJugadores.Jugador;
import fiuba.algo3.manejoDeJugadores.ListaJugadores;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fechee on 19/11/2015.
 */
public class EquipoTests {


    @Test
    public void testClaseCapo(){
        Equipo equipoCapos = new Equipo("Capos");
        Assert.assertEquals("Capos",equipoCapos.getNombre());

        equipoCapos.sumarPuntos(1);
        Assert.assertEquals(1,equipoCapos.getPuntaje());
    }



    @Test
    public void testIntegracionParaCrearJugadoresAgregarlosALaListaYAsignarlesEquipo(){

        Jugador juan = new Jugador("juan");
        Jugador carlos = new Jugador("carlos");
        Jugador pedro = new Jugador("pedro");
        Jugador ale = new Jugador("ale");


        ListaJugadores jugadores = new ListaJugadores();    // se supone que los configJugadores se vana agregando en orden
        jugadores.agregarUltimo(juan);
        jugadores.agregarUltimo(carlos);
        jugadores.agregarUltimo(pedro);
        jugadores.agregarUltimo(ale);


        Assert.assertEquals(juan.getEquipo(),pedro.getEquipo());    // significa que el 3er jugador que se agrego jugara con el primero (juan y pedro)

        Assert.assertEquals(carlos.getEquipo(),ale.getEquipo());   // lo mismo se aplica entre el 2do y el 4to jugador
    }


    @Test
    public void testIntegralParaCrearJugdoresYAsignarlesEquipoConDosJugadores(){
        Jugador juan = new Jugador("juan");
        Jugador carlos = new Jugador("carlos");

        ListaJugadores jugadores = new ListaJugadores();    // se supone que los configJugadores se vana agregando en orden
        jugadores.agregarUltimo(juan);
        jugadores.agregarUltimo(carlos);

        Assert.assertFalse(juan.getEquipo() == carlos.getEquipo());
    }


    @Test
    public void testAgregarJugadorAUnEquipoLoAgregaBien(){
        Equipo equipo = new Equipo("CARLOS");
        Jugador carlitos = new Jugador("carlitos");
        equipo.agregarJugador(carlitos);

        Assert.assertTrue(equipo.getJugadores().contains(carlitos));
    }


}
