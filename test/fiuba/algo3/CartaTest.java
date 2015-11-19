package fiuba.algo3;

import fiuba.algo3.Excepciones.ValorDeCartaInvalidoError;
import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.ModeladoDeCarta.Palo;
import fiuba.algo3.ModeladoDeCarta.PaloEspada;
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
}
