package fiuba.algo3.ModeladoDeCarta;

import fiuba.algo3.Excepciones.ValorDeCartaInvalidoError;

/**
 * Created by anthony on 19/11/2015.
 */
public class Carta {
    private int valorDeCarta;
    private Palo paloDeCarta;

    public Carta(int unValor, Palo unPalo) {
        this.setValorDeCarta(unValor);
        this.setPaloDeCarta(unPalo);
    }

    public void setValorDeCarta(int unValorDeCarta) {
        if(unValorDeCarta <= 12 && unValorDeCarta >= 1 && unValorDeCarta != 8 && unValorDeCarta != 9){
            this.valorDeCarta = unValorDeCarta;
        } else{
            throw new ValorDeCartaInvalidoError();
        }
    }

    public void setPaloDeCarta(Palo unPaloDeCarta) {
        this.paloDeCarta = unPaloDeCarta;
    }
}
