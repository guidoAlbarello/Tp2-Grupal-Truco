package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.ValorDeCartaInvalidoError;
import fiuba.algo3.modelo.palosPosibles.*;

import java.util.*;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Carta {
    private int valorDeCarta;
    private Palo paloDeCarta;
    private static final Map<Carta, Integer> asociacionDePoderDeCartas;

    static{
        Map<Carta, Integer> mapTmp = new HashMap<>();
        inicializarValoresDeCartas(mapTmp);
        asociacionDePoderDeCartas = mapTmp;
    }

    private static void inicializarValoresDeCartas(Map<Carta, Integer> mapTmp) {
        List<Palo> palosPosibles = new ArrayList<>();
        palosPosibles.add ( new PaloEspada() );
        palosPosibles.add ( new PaloBasto() );
        palosPosibles.add ( new PaloCopa() );
        palosPosibles.add ( new PaloOro() );

        List<Integer> valoresPosibles = new ArrayList<>();
        valoresPosibles.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 10, 11, 12));

        for(Palo unPalo : palosPosibles){
            for(Integer unValor : valoresPosibles){
                Carta unaCarta = new Carta(unValor, unPalo);
                Integer valorDePoderDeCarta = unValor;
                valorDePoderDeCarta = checkearPoderDeCarta(palosPosibles, unPalo, unValor, valorDePoderDeCarta);
                mapTmp.put(unaCarta, valorDePoderDeCarta);
            }
        }
    }

    private static Integer checkearPoderDeCarta(List<Palo> palosPosibles, Palo unPalo, Integer unValor, Integer valorDePoderDeCarta) {
        if(unValor == 3 || unValor ==  2)
            valorDePoderDeCarta += 13;
        if(unValor == 1 && unPalo.esDelMismoPaloQue(palosPosibles.get(0)))
            valorDePoderDeCarta += 17;
        if(unValor == 1 && unPalo.esDelMismoPaloQue(palosPosibles.get(1)))
            valorDePoderDeCarta += 16;
        if(unValor == 1 && unPalo.esDelMismoPaloQue(palosPosibles.get(2)))
            valorDePoderDeCarta += 12;
        if(unValor == 1 && unPalo.esDelMismoPaloQue(palosPosibles.get(3)))
            valorDePoderDeCarta += 13;
        if(unValor == 7 && unPalo.esDelMismoPaloQue(palosPosibles.get(0)))
            valorDePoderDeCarta += 7;
        if(unValor == 7 && unPalo.esDelMismoPaloQue(palosPosibles.get(3)))
            valorDePoderDeCarta += 6;
        return valorDePoderDeCarta;
    }

    @Override
    public boolean equals(Object otroObjeto){
        if(otroObjeto instanceof Carta){
            if(this.getValorDeCarta() == ((Carta) otroObjeto).getValorDeCarta() && this.getPaloDeCarta().esDelMismoPaloQue(((Carta) otroObjeto).getPaloDeCarta()))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        int valorDeHashDelPalo = this.getPaloDeCarta().getValorDeHash();
        return this.getValorDeCarta() + valorDeHashDelPalo;
    }

    public Carta(int unValor, Palo unPalo) {
        this.setValorDeCarta(unValor);
        this.setPaloDeCarta(unPalo);
    }

    public Integer getValorDePoder(){
        return asociacionDePoderDeCartas.get(this);
    }

    public void setPaloDeCarta(Palo unPalo) {
        this.paloDeCarta = unPalo;
    }

    public void setValorDeCarta(int unValor) {
        if(unValor <= 12 && unValor >= 1 && unValor != 8 && unValor != 9){
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

        return envidoACalcular.calcularEnvido(this.getValorDeCarta(), unaCarta.getValorDeCarta());
    }
}
