package fiuba.algo3.modelo;

import java.util.LinkedList;

/**
 * Created by Fechee on 10/11/2015.
 */
public class JuegoTruco {


    //---------------------Quizas esto vaya en MESA------------------

    private static final int PUNTOS_ENVIDO = 2;
    private static final int PUNTOS_FLOR = 3;




    private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();

    private Jugador jugadorMano;
    private Jugador turnoActual;

    private Cantos cantosDelJuego;

  //  private Mazo mazoDeCartas;

    private Jugador ganador;


    public JuegoTruco(boolean conFlor){
        if (conFlor){
            this.cantosDelJuego = new CantosConFlor();
        }
        else{
            this.cantosDelJuego = new CantosSinFlor();
        }
    }


    public void agregarJugador(String nombre){
        this.jugadores.addLast(new Jugador(nombre));
        this.jugadores.getLast().setCantos(cantosDelJuego);
    }


}
