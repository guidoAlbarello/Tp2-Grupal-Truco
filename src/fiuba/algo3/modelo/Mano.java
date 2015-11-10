package fiuba.algo3.modelo;

import java.util.LinkedList;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Mano {

    private LinkedList<Carta> cartas;
    private String envidoPalo;
    private int envido;


    public Mano(){
        this.cartas = new LinkedList<Carta>();
        this.envido=0;
        this.envidoPalo="";
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

    private String getPaloEnComun(LinkedList<Carta> cartas) {
        if ( cartas.get(0).getPalo() == cartas.get(1).getPalo() );
    }

    public int calcularEnvido() {
        this.cartas
        }
    }
}
