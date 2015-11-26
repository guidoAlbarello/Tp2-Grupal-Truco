package fiuba.algo3;

import fiuba.algo3.Excepciones.NoHayFlorEnLaManoError;
import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.ModeladoDeCarta.Envido;
import fiuba.algo3.ModeladoDeCarta.Palo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krion on 19/11/2015.
 */
public class Mano {
    private List<Carta> cartasEnLaMano;
    private List<Integer> indicesDeCartasJugadas;

    public Mano(){
        this.indicesDeCartasJugadas = new ArrayList<Integer>();
        this.cartasEnLaMano = new ArrayList<Carta>();
    }

    public void agregarCarta(Carta unaCarta) {
        this.cartasEnLaMano.add(unaCarta);
    }

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


    public List<Carta> getCartasEnMano(){  return this.cartasEnLaMano;  }

    public Carta jugarCarta(int indiceDeLaCarta) {
        this.indicesDeCartasJugadas.add(indiceDeLaCarta);
        return this.cartasEnLaMano.get(indiceDeLaCarta);
    }

    public void reiniciarMano(){
        this.indicesDeCartasJugadas = new ArrayList<Integer>();
        this.cartasEnLaMano = new ArrayList<Carta>();
    }

    public void reiniciarIndicesDeCartasTiradas(){
        this.indicesDeCartasJugadas.clear();
    }

    public boolean hayFlorEnMano() {
        Iterator<Carta> iterador = this.cartasEnLaMano.iterator();
        Carta primeraCartaDeLaMano = iterador.next();
        boolean hayFlor = true;
        while (hayFlor && iterador.hasNext()){
            Carta cartaDeLaMano = iterador.next();
            hayFlor = primeraCartaDeLaMano.getPaloDeCarta().esDelMismoPaloQue(cartaDeLaMano.getPaloDeCarta());
        }
        return hayFlor;
    }
}
