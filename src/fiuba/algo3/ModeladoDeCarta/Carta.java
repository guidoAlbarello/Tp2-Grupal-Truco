package fiuba.algo3.ModeladoDeCarta;

import fiuba.algo3.Excepciones.ValorDeCartaInvalidoError;

/**
 * Created by anthony on 19/11/2015.
 */
public class Carta {
    private int valorDeCarta;
    private Palo paloDeCarta;
    private TipoDeCarta tipoDeCarta;

    public Carta(int unValor, Palo unPalo) {
        this.setValorDeCarta(unValor);
        this.setPaloDeCarta(unPalo);
        if(unValor < 10)
            this.tipoDeCarta = new CartaNoFigura();
        else
            this.tipoDeCarta = new CartaFigura();
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

    public int getValorDeEnvido(){
        return this.tipoDeCarta.getValorDeEnvido(this.getValorDeCarta());
    }

    public int getValorDeCarta() {
        return valorDeCarta;
    }

    public Envido calcularEnvidoCon(Carta unaCarta){
        boolean sonDelMismoPalo = this.getPaloDeCarta().esDelMismoPaloQue(unaCarta.getPaloDeCarta());
        Envido envidoACalcular;
        if(sonDelMismoPalo)
            envidoACalcular = new EnvidoCartasIgualPalo();
        else
            envidoACalcular = new EnvidoCartasDiferentePalo();

        return envidoACalcular.calcularEnvido(this.getValorDeEnvido(), unaCarta.getValorDeEnvido());
    }

    public Palo getPaloDeCarta() {
        return this.paloDeCarta;
    }
}
