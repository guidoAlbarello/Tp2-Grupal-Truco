package fiuba.algo3.modelo;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Mazo {

    private LinkedList<Carta> mazoDelJuego;
    private int numeroDeCartas;
    private int cartasTotales =40;
    private LinkedList<Palo> palos;
    private LinkedList<Integer> numeros;

    public Mazo(){
        palos.add ( new PaloEspada() );
        palos.add ( new PaloBasto() );
        palos.add ( new PaloCopa() );
        palos.add ( new PaloOro() );

        numeroDeCartas= cartasTotales;
        mazoDelJuego = new LinkedList<>();

        for (Palo unPalo : palos) {
            for (int  numero : numeros) {
                Carta unaCarta = new Carta(numero,unPalo);
                mazoDelJuego.add(unaCarta);
            }
        }
    }

    public void repartirCartasAJugador(Jugador jugador) {
        jugador.recibirCarta(mazoDelJuego.removeLast());
        jugador.recibirCarta(mazoDelJuego.removeLast());
        jugador.recibirCarta(mazoDelJuego.removeLast());

    }

    public int obtenerNumeroDeCartas() {
        return mazoDelJuego.size();
    }


    public void mezclarMazo(){
        Collections.shuffle(mazoDelJuego);
    }
}
