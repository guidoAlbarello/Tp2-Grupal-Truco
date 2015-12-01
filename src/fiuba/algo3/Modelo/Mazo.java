package fiuba.algo3.Modelo;

import fiuba.algo3.Modelo.ModeladoDeCarta.*;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Fechee on 19/11/2015.
 */
public class Mazo {

    private LinkedList<Carta> mazoDelJuego;
    private int numeroDeCartas;
    private int cartasTotales =40;
    private LinkedList<Palo> palos;
    private LinkedList<Integer> numeros;
    //private LinkedList<Integer> figuras;


    public Mazo(){
        //PALO
        palos = new LinkedList<Palo>();
        palos.add ( new PaloEspada() );
        palos.add ( new PaloBasto() );
        palos.add ( new PaloCopa() );
        palos.add ( new PaloOro() );
        //NUMEROS
        numeros = new LinkedList<Integer>();
        numeros.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 10, 11, 12));
        //figuras = new LinkedList<Integer>();
        //figuras.addAll(Arrays.asList(10,11,12));

        numeroDeCartas= cartasTotales;
        mazoDelJuego = new LinkedList<>();

        for (Palo unPalo : palos) {
            for (Integer  numero : numeros) {
                Carta unaCarta = new Carta(numero,unPalo);
                mazoDelJuego.add(unaCarta);
            }
        }
    }

    //ESTE METODO SACA LA CARTA DEL MAZO!!!
    public Carta repartirUltimaCarta(){
        return this.mazoDelJuego.removeLast();
    }


    //ENTREGA 3 CARTAS AL JUGADOR
    public void repartirCartasAJugador(Jugador jugador) {
        jugador.recibirCarta(repartirUltimaCarta());
        jugador.recibirCarta(repartirUltimaCarta());
        jugador.recibirCarta(repartirUltimaCarta());
    }

    public int obtenerNumeroDeCartas() {
        return mazoDelJuego.size();
    }


    public void mezclarMazo(){
        Collections.shuffle(mazoDelJuego);
    }

    public LinkedList<Carta> getMazoDelJuego(){
        return this.mazoDelJuego;
    }
}