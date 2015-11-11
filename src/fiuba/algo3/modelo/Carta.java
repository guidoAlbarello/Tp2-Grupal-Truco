package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.ValorDeCartaInvalidoError;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Carta {
    private int valorDeCarta;
    private Palo paloDeCarta;

    public Carta(int unValor, Palo unPalo) {
        this.setValorDeCarta(unValor);
        this.setPaloDeCarta(unPalo);
    }


    public void setPaloDeCarta(Palo unPalo) {
        this.paloDeCarta = unPalo;
    }

    public void setValorDeCarta(int unValor) {
        if(unValor <= 12 && unValor >= 1){
            this.valorDeCarta = unValor;
        } else{
            throw new ValorDeCartaInvalidoError();
        }
    }

    public int getValorDeCarta(){
        return this.valorDeCarta;
    }

    public Palo getPaloDeCarta(){
        return this.paloDeCarta;
    }

    public Envido calcularEnvidoCon(Carta unaCarta){
        boolean sonDelMismoPalo = this.getPaloDeCarta().esDelMismoPaloQue(unaCarta.getPaloDeCarta());
        Envido envidoACalcular;
        if(sonDelMismoPalo)
            envidoACalcular = new EnvidoCartasIgualPalo();
        else
            envidoACalcular = new EnvidoCartasDiferentePalo();

        return envidoACalcular.calcularEnvido(this, unaCarta);
    }
}
