import fiuba.algo3.modelo.Cantos;
import fiuba.algo3.modelo.CantosConFlor;
import fiuba.algo3.modelo.CantosSinFlor;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 13/11/2015.
 */
public class CantosTest {
    @Test(expected = NoSeEstaJugandoConFlorError.class)
    public void testChequeoDeErrorAlCantarFlorCuandoSeJuegaSinFlor(){
        Cantos cantos = new CantosSinFlor();
        Jugador unJugador = new Jugador("Juan", cantos);
        unJugador.getCantosPosibles().cantarFlor(unJugador);
    }

    @Test
    public void testChequeoDeQueSePuedaCantarFlorCorrectamenteCuandoSeJuegaConFlor(){
        Cantos cantos = new CantosConFlor();
        Jugador unJugador = new Jugador("Juan", cantos);
        Assert.assertEquals(null, unJugador.getCantosPosibles().cantarFlor(unJugador));
    }
}
