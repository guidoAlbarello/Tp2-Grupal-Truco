package fiuba.algo3.modelo;

import fiuba.algo3.modelo.exepciones.ValorDeCartaInvalidoError;
import fiuba.algo3.modelo.exepciones.ValorInvalidoDeCarta;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Carta {
    private int valor;
    private Palo palo;



    public Carta(Integer valor, Palo palo){
        this.valor = valor;
        this.palo = palo;
    }


}
