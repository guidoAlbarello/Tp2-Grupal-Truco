package fiuba.algo3.modelo;

import java.util.LinkedList;

/**
 * Created by Fechee on 10/11/2015.
 */
public class JuegoTruco {


    //---------------------Quizas esto vaya en MESA------------------

    private static final int PUNTOS_ENVIDO = 2;
    //private static final int PUNTOS_REAL_ENVIDO = 3;
    //private static final int PUNTOS_ENVIDO_ENVIDO = 4;
    private static final int PUNTOS_FLOR = 3;
    //private static final int PUNTOS_CONTRAFLOR = 6;
    //private static final int PUNTOS_TRUCO = 2;
    //private static final int PUNTOS_RETRUCO = 3;
    //private static final int PUNTOS_TRUCO_VALE4 = 4;



    private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();

    private Jugador jugadorMano;
    private Jugador turnoActual;

    private Mazo mazoDeCartas;

    private Jugador ganador;


    public JuegoTruco(boolean conFlor){

    }


    public void agregarJugador(String nombre){
        this.jugadores.addLast(new Jugador(nombre));
    }


}
