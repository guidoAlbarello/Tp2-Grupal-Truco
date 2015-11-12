import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.excepciones.ValorDeCartaInvalidoError;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Krion on 10/11/2015.
 */
public class CartaTest {
    @Test(expected = ValorDeCartaInvalidoError.class)
    public void testCreacionDeCartaNoExitosa(){
        Palo unPalo = new PaloEspada();
        Carta cartaMalCreada = new Carta(23, unPalo );
    }

    @Test
    public void testCreacionDeCartaExitosa(){
        Palo unPalo = new PaloEspada();
        Carta cartaBienCreada = new Carta(1, unPalo );
        Assert.assertEquals(1, cartaBienCreada.getValorDeCarta());
    }

    @Test
    public void testChequeoDeCalculoDelEnvidoEntreDosCartas(){
        Palo unPalo = new PaloEspada();
        Carta cartaNueva1 = new Carta(5, unPalo);
        Carta cartaNueva2 = new Carta(7, unPalo);

        Assert.assertEquals(32, cartaNueva1.calcularEnvidoCon(cartaNueva2).getValorEnvido());

        Palo otroPalo = new PaloBasto();
        Carta cartaNueva3 = new Carta(2, otroPalo);

        Assert.assertEquals(5, cartaNueva1.calcularEnvidoCon(cartaNueva3).getValorEnvido());
        Assert.assertEquals(7, cartaNueva3.calcularEnvidoCon(cartaNueva2).getValorEnvido());
    }

    @Test
    public void testChequearQueElHashCodeElegidoEsUnico(){
        List<Palo> palosPosibles = new ArrayList<>();
        palosPosibles.add ( new PaloEspada() );
        palosPosibles.add ( new PaloBasto() );
        palosPosibles.add ( new PaloCopa() );
        palosPosibles.add ( new PaloOro() );

        List<Integer> valoresPosibles = new ArrayList<>();
        valoresPosibles.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 10, 11, 12));

        List<Integer> valoresHashCode = new ArrayList<>();
        for(Palo unPalo : palosPosibles){
            for(Integer unValor : valoresPosibles){
                Carta unaCarta = new Carta(unValor, unPalo);
                valoresHashCode.add(unaCarta.hashCode());
            }
        }

        boolean ningunHashCodeRepetido = true;
        Iterator<Integer> iteradorValoresHashCode = valoresHashCode.iterator();
        int hashCodeAnterior = iteradorValoresHashCode.next();
        while(iteradorValoresHashCode.hasNext()){
            int hashCodeTmp = iteradorValoresHashCode.next();
            if(hashCodeTmp == hashCodeAnterior)
                ningunHashCodeRepetido = false;
            hashCodeAnterior = hashCodeTmp;
        }

        Assert.assertTrue(ningunHashCodeRepetido);

    }

    @Test
    public void testCheckearValorDePoderDeLasCartas(){
        Palo paloBasto = new PaloBasto();
        Palo paloCopa = new PaloCopa();
        Palo paloEspada = new PaloEspada();
        Palo paloOro = new PaloOro();

        Carta carta1 = new Carta(1, paloBasto);
        Carta carta2 = new Carta(1, paloEspada);
        Carta carta3 = new Carta(1, paloCopa);
        Carta carta4 = new Carta(1, paloOro);
        Carta carta5 = new Carta(7, paloOro);
        Carta carta6 = new Carta(7, paloEspada);
        Carta carta7 = new Carta(2, paloBasto);
        Carta carta8 = new Carta(3, paloCopa);
        Carta carta9 = new Carta(12, paloBasto);
        Carta carta10 = new Carta(4, paloEspada);

        Assert.assertTrue(carta1.getValorDePoder() < carta2.getValorDePoder());
        Assert.assertTrue(carta2.getValorDePoder() > carta3.getValorDePoder());
        Assert.assertTrue(carta3.getValorDePoder() > carta10.getValorDePoder());
        Assert.assertTrue(carta4.getValorDePoder() < carta7.getValorDePoder());
        Assert.assertTrue(carta5.getValorDePoder() < carta8.getValorDePoder());
        Assert.assertTrue(carta6.getValorDePoder() > carta5.getValorDePoder());
        Assert.assertTrue(carta7.getValorDePoder() > carta9.getValorDePoder());
        Assert.assertTrue(carta8.getValorDePoder() < carta1.getValorDePoder());
        Assert.assertTrue(carta9.getValorDePoder() > carta10.getValorDePoder());
        Assert.assertTrue(carta10.getValorDePoder() < carta2.getValorDePoder());
    }
}
