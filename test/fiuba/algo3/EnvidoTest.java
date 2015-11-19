package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 19/11/2015.
 */
public class EnvidoTest {
    @Test
    public void chequeoDeCalculoCorrectoDelEnvidoEntreDosCartas(){
        Palo unPalo = new PaloEspada();
        Palo otroPalo = new PaloBasto();
        Carta carta1 = new Carta(3, unPalo);
        Carta carta2 = new Carta(5, unPalo);
        Carta carta3 = new Carta(7, otroPalo);

        Envido envidoACalcular = new EnvidoCartasIgualPalo();
        Assert.assertEquals(28, envidoACalcular.calcularEnvido(carta1.getValorDeCarta(), carta2.getValorDeCarta()).getValorEnvido());

        envidoACalcular = new EnvidoCartasDiferentePalo();
        Assert.assertEquals(7, envidoACalcular.calcularEnvido(carta1.getValorDeCarta(), carta3.getValorDeCarta()).getValorEnvido());
    }
}
