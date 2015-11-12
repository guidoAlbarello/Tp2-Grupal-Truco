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
    private ManejadorDeTurnos manejadorDeTurnos;
    private Cantos cantosDelJuego;

    private Mazo mazoDeCartas;
    private Mesa mesa;
    private Jugador ganador;


    public JuegoTruco(boolean conFlor){
        mezclarCartas();
        if (conFlor){
            this.cantosDelJuego = new CantosConFlor();

        }
        else{
            this.cantosDelJuego = new CantosSinFlor();
        }
    }

    public void mezclarCartas(){
        this.mazoDeCartas = new Mazo();
        this.mazoDeCartas.mezclarMazo();
    }


    //public void agregarJugador(String nombre){ this.jugadores.addLast(new Jugador(nombre,cantosDelJuego));  }

   /* public void agregarJugadores(String nombreJugador1,String nombreJugador2){
        this.mesa = new Mesa(new Jugador(nombreJugador1,cantosDelJuego),new Jugador(nombreJugador2,cantosDelJuego));
    }

    public void repartirCartas(){
        this.mazoDeCartas.repartirCartasAJugador(this.mesa.getJugador1());
        this.mazoDeCartas.repartirCartasAJugador(this.mesa.getJugador2());
    }*/


}
