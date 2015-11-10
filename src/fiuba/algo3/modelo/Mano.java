package fiuba.algo3.modelo;

import java.util.LinkedList;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Mano {

    private LinkedList<Carta> cartas;


    public Mano(){
        this.cartas = new LinkedList<Carta>();
    }



    public void jugarCarta(Carta unaCarta){
        //TODO
    }


    public void borrar() {
        this.cartas = new LinkedList<Carta>();
    }

    public void agregarCarta(Carta unaCarta) {
        this.cartas.addLast(unaCarta);
    }
}
