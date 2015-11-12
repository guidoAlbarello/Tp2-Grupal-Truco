import fiuba.algo3.modelo.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 12/11/2015.
 */
public class PaloTest {
    @Test
    public void testChequeoDeSiUnPaloEsElMismoQueOtro(){
        Palo paloBasto = new PaloBasto();
        Palo paloCopa = new PaloCopa();
        Palo paloEspada = new PaloEspada();
        Palo paloOro = new PaloOro();

        Assert.assertTrue(paloBasto.esDelMismoPaloQue(paloBasto));
        Assert.assertTrue(paloCopa.esDelMismoPaloQue(paloCopa));
        Assert.assertTrue(paloOro.esDelMismoPaloQue(paloOro));
        Assert.assertTrue(paloEspada.esDelMismoPaloQue(paloEspada));

        Assert.assertFalse(paloBasto.esDelMismoPaloQue(paloCopa));
        Assert.assertFalse(paloEspada.esDelMismoPaloQue(paloOro));
        Assert.assertFalse(paloCopa.esDelMismoPaloQue(paloEspada));
        Assert.assertFalse(paloOro.esDelMismoPaloQue(paloCopa));
    }
}
