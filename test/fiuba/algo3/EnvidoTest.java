package fiuba.algo3;

import fiuba.algo3.Modelo.ModeladoDeCarta.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 19/11/2015.
 */
public class EnvidoTest {
    @Test
    public void chequeoDeCalculoCorrectoDelEnvidoEntreDosCartas(){
        Envido envidoACalcular = new EnvidoCartasIgualPalo();
        Assert.assertEquals(28, envidoACalcular.calcularEnvido(5,3).getValorEnvido());

        envidoACalcular = new EnvidoCartasDiferentePalo();
        Assert.assertEquals(7, envidoACalcular.calcularEnvido(7,3).getValorEnvido());
    }
}
