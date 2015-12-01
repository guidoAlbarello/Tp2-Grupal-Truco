package fiuba.algo3.Modelo.ModeladoDeCarta;

import fiuba.algo3.Modelo.Excepciones.ValorDeCartaInvalidoError;

import java.util.*;

/**
 * Created by anthony on 19/11/2015.
 */
public class Carta {
    private int valorDeCarta;
    private Palo paloDeCarta;
    private TipoDeCarta tipoDeCarta;
    private static final Map<Carta, Integer> asociacionDePoderDeCartas;

    static{
        Map<Carta, Integer> mapTmp = new HashMap<>();
        inicializarDiccionario(mapTmp);
        asociacionDePoderDeCartas = mapTmp;
    }

    private static void inicializarDiccionario(Map<Carta, Integer> mapTmp) {

        List<Palo> palosPosibles = new ArrayList<>();
        palosPosibles.add ( new PaloEspada() );
        palosPosibles.add ( new PaloBasto() );
        palosPosibles.add ( new PaloCopa() );
        palosPosibles.add ( new PaloOro() );

        List<Integer> valoresPosibles = new ArrayList<>();
        valoresPosibles.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 10, 11, 12));

        List<Integer> valoresDePoderDeCartas = inicializarValoresDePoderDeCartas();

        int i = 0;
        for(Palo unPalo : palosPosibles){
            for(Integer unValor : valoresPosibles){
                Carta unaCarta = new Carta(unValor, unPalo);
                Integer valorDePoderDeUnaCarta = valoresDePoderDeCartas.get(i);
                mapTmp.put(unaCarta, valorDePoderDeUnaCarta);
                i++;
            }
        }
    }

    private static List<Integer> inicializarValoresDePoderDeCartas() {
        List<Integer> valoresDePoderDeCartas = new ArrayList<>();
        valoresDePoderDeCartas.add(100);
        valoresDePoderDeCartas.add(40);
        valoresDePoderDeCartas.add(50);
        valoresDePoderDeCartas.add(4);
        valoresDePoderDeCartas.add(5);
        valoresDePoderDeCartas.add(6);
        valoresDePoderDeCartas.add(80);
        valoresDePoderDeCartas.add(10);
        valoresDePoderDeCartas.add(11);
        valoresDePoderDeCartas.add(12);

        valoresDePoderDeCartas.add(90);
        valoresDePoderDeCartas.add(40);
        valoresDePoderDeCartas.add(50);
        valoresDePoderDeCartas.add(4);
        valoresDePoderDeCartas.add(5);
        valoresDePoderDeCartas.add(6);
        valoresDePoderDeCartas.add(7);
        valoresDePoderDeCartas.add(10);
        valoresDePoderDeCartas.add(11);
        valoresDePoderDeCartas.add(12);

        valoresDePoderDeCartas.add(20);
        valoresDePoderDeCartas.add(40);
        valoresDePoderDeCartas.add(50);
        valoresDePoderDeCartas.add(4);
        valoresDePoderDeCartas.add(5);
        valoresDePoderDeCartas.add(6);
        valoresDePoderDeCartas.add(7);
        valoresDePoderDeCartas.add(10);
        valoresDePoderDeCartas.add(11);
        valoresDePoderDeCartas.add(12);

        valoresDePoderDeCartas.add(30);
        valoresDePoderDeCartas.add(40);
        valoresDePoderDeCartas.add(50);
        valoresDePoderDeCartas.add(4);
        valoresDePoderDeCartas.add(5);
        valoresDePoderDeCartas.add(6);
        valoresDePoderDeCartas.add(70);
        valoresDePoderDeCartas.add(10);
        valoresDePoderDeCartas.add(11);
        valoresDePoderDeCartas.add(12);

        return valoresDePoderDeCartas;
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
        return this.valorDeCarta;
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

    public int getValorDePoder() {
        return asociacionDePoderDeCartas.get(this);
    }
}
