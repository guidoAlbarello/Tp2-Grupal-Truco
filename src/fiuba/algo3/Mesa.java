package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.manejoDeJugadores.Jugador;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by anthony on 19/11/2015.
 */
public class Mesa {
    private LinkedList<CartaJugada> listaDeCartasJugadas;

    public Mesa(){
        this.listaDeCartasJugadas = new LinkedList<>();
    }

    public LinkedList<CartaJugada> listaDeCartasJugadas() {
        return this.listaDeCartasJugadas;
    }

    public void agregarCartaALsitaDeCartasJugadas(CartaJugada cartaJugada) {
        this.listaDeCartasJugadas.add(cartaJugada);
    }
    public Jugador ganadorDeMano(){
        Iterator<CartaJugada> iterador = this.listaDeCartasJugadas.iterator();
        CartaJugada cartaGanadora = iterador.next();
        while ( iterador.hasNext()){
            CartaJugada unaCartaJugada = iterador.next();
            if (cartaGanadora.getCarta().getValorDePoder() < unaCartaJugada.getCarta().getValorDePoder()) {
                cartaGanadora = unaCartaJugada;
            }
        }
        return cartaGanadora.getJugador();
    }
}
