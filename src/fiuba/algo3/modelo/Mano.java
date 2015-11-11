package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Mano {

    private List<Carta> cartasEnLaMano;

    public Mano(){
        this.cartasEnLaMano = new ArrayList<Carta>();
    }

    public void agregarCarta(Carta unaCarta) {
        this.cartasEnLaMano.add(unaCarta);
    }

    public List<Envido> obtenerEnvido(){
        List<Envido> envidosPosibles = new ArrayList<Envido>();
        for(int i = 0;i<3; i++){
            Carta unaCartaTmp = this.cartasEnLaMano.get(i);
            calcularEnvidoConCartasRestantes(unaCartaTmp, i, envidosPosibles);
        }
        return envidosPosibles;
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
