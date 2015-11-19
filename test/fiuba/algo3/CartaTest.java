package fiuba.algo3;

import fiuba.algo3.Excepciones.ValorDeCartaInvalidoError;
import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.ModeladoDeCarta.Palo;
import fiuba.algo3.ModeladoDeCarta.PaloBasto;
import fiuba.algo3.ModeladoDeCarta.PaloEspada;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 19/11/2015.
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

}
