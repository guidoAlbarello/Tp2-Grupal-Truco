package fiuba.algo3;

import fiuba.algo3.Excepciones.NoHayFlorEnLaManoError;
import fiuba.algo3.ModeladoDeCarta.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 19/11/2015.
 */
public class ManoTest {
    @Test
    public void testCalculoDeEnvidoEnLaManoDeCartas(){
        Mano manoNueva = new Mano();

        Palo unPalo = new PaloEspada();
        Palo otroPalo = new PaloBasto();

        Carta carta1 = new Carta(3, otroPalo);
        Carta carta2 = new Carta(6, unPalo);
        Carta carta3 = new Carta(5, unPalo);

        manoNueva.agregarCarta(carta1);
        manoNueva.agregarCarta(carta2);
        manoNueva.agregarCarta(carta3);

        Envido envidoMaximo= manoNueva.obtenerEnvido();

        Assert.assertEquals(31, envidoMaximo.getValorEnvido());
    }

    @Test
    public void testCalculoDeFlorEnLaMano(){
        Mano manoNueva = new Mano();

        Palo unPalo = new PaloEspada();

        Carta carta1 = new Carta(3, unPalo);
        Carta carta2 = new Carta(6, unPalo);
        Carta carta3 = new Carta(5, unPalo);

        manoNueva.agregarCarta(carta1);
        manoNueva.agregarCarta(carta2);
        manoNueva.agregarCarta(carta3);

        int valorFlor = manoNueva.calcularFlor();

        Assert.assertEquals(34, valorFlor);
    }

    @Test(expected = NoHayFlorEnLaManoError.class)
    public void testCalculoDeEnvidoEnLaManoDeCartasCuandoNoHay3CartasDelMismoPalo(){
        Mano manoNueva = new Mano();

        Palo unPalo = new PaloEspada();
        Palo otroPalo = new PaloBasto();

        Carta carta1 = new Carta(3, unPalo);
        Carta carta2 = new Carta(6, unPalo);
        Carta carta3 = new Carta(5, otroPalo);

        manoNueva.agregarCarta(carta1);
        manoNueva.agregarCarta(carta2);
        manoNueva.agregarCarta(carta3);

        int valorFlor = manoNueva.calcularFlor();
    }
}
