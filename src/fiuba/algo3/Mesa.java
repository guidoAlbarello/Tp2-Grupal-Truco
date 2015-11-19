package fiuba.algo3;

import java.awt.*;
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
}
