package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.NoHayFlorEnLaManoError;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Mano {

    private List<Carta> cartasEnLaMano;
    private LinkedList<Integer> indiceDeCartasJugadas; //agregue yo fede
    public Mano(){
        this.cartasEnLaMano = new ArrayList<Carta>();
        this.indiceDeCartasJugadas = new LinkedList<Integer>();
    }

    public void agregarCarta(Carta unaCarta) {
        this.cartasEnLaMano.add(unaCarta);
    }
    public Carta obtenerUltimaCarta(){return cartasEnLaMano.get(2);}

    public Envido obtenerEnvido(){
        List<Envido> envidosPosibles = new ArrayList<Envido>();
        for(int i = 0;i<3; i++){
            Carta unaCartaTmp = this.cartasEnLaMano.get(i);
            this.calcularEnvidoConCartasRestantes(unaCartaTmp, i, envidosPosibles);
        }

        Envido envidoMaximo = this.calcularEnvidoMaximo(envidosPosibles);
        return envidoMaximo;
    }

    private Envido calcularEnvidoMaximo(List<Envido> envidosPosibles){
        Iterator<Envido> iteradorEnvidosPosibles = envidosPosibles.iterator();
        int valorEnvidoMaximo = 0;
        Envido envidoMaximo = null;

        while(iteradorEnvidosPosibles.hasNext()){
            Envido envidoTmp = iteradorEnvidosPosibles.next();
            if(envidoTmp.getValorEnvido() > valorEnvidoMaximo){
                envidoMaximo = envidoTmp;
                valorEnvidoMaximo = envidoTmp.getValorEnvido();
            }
        }

        return envidoMaximo;
    }

    private void calcularEnvidoConCartasRestantes(Carta unaCarta, int i, List<Envido> envidosPosibles){
        for(int j = i; j < 3;j++) {
            if (i != j) {
                Carta unaCartaRestanteTmp = this.cartasEnLaMano.get(j);
                Envido EnvidoTmp = unaCarta.calcularEnvidoCon(unaCartaRestanteTmp);
                envidosPosibles.add(EnvidoTmp);
            }
        }
    }

    public int calcularFlor(){
        Iterator<Carta> iteradorCartasEnLaMano = this.cartasEnLaMano.iterator();
        Carta primerCarta = iteradorCartasEnLaMano.next();
        Palo unPalo = primerCarta.getPaloDeCarta();
        int valorDeFlor = primerCarta.getValorDeCarta();

        while(iteradorCartasEnLaMano.hasNext()){
            Carta cartaTmp = iteradorCartasEnLaMano.next();
            if(cartaTmp.getPaloDeCarta().esDelMismoPaloQue(unPalo)){
                valorDeFlor += cartaTmp.getValorDeCarta();
            }else{
                throw new NoHayFlorEnLaManoError();
            }
        }

        valorDeFlor += 20;
        return valorDeFlor;
    }


    public List<Carta> getCartasEnMano(){
        return this.cartasEnLaMano;
    }



    //agregue yo fede

    public void jugarCarta(Integer indiceDeCarta) {
        if (!this.indiceDeCartasJugadas.contains(indiceDeCarta)) {
            this.indiceDeCartasJugadas.addLast(indiceDeCarta);
        }
    }

    public Carta getCartaJugada(){
        int indiceDeUltimaCartaJugada = this.indiceDeCartasJugadas.getLast();
        return this.cartasEnLaMano.get(indiceDeUltimaCartaJugada);
    }
}

