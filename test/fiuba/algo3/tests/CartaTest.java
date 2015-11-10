import fiuba.algo3.modelo.Carta;
import fiuba.algo3.modelo.Palo;
import fiuba.algo3.modelo.PaloEspada;
import fiuba.algo3.modelo.excepciones.ValorDeCartaInvalidoError;
import org.junit.Assert;
import org.junit.Test;


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
}
