package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.ModeladoDeCarta.Envido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krion on 19/11/2015.
 */
public class Mano {
    private List<Carta> cartasEnLaMano;
    public Mano(){
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
}
