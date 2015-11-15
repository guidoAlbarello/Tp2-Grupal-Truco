import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.jugadasPosibles.peticiones.FlorCantada;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJuego;
import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import fiuba.algo3.modelo.palosPosibles.Palo;
import fiuba.algo3.modelo.palosPosibles.PaloEspada;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 13/11/2015.
 */
public class CantosTest {
    @Test(expected = NoSeEstaJugandoConFlorError.class)
    public void testChequeoDeErrorAlCantarFlorCuandoSeJuegaSinFlor(){
        Cantos cantoNuevo = new CantosSinFlor();
        Jugador unJugador = new Jugador("Juan", cantoNuevo);
        unJugador.getCantosPosibles().cantarFlor(unJugador);
    }

    @Test
    public void testChequeoDeQueSePuedaCantarFlorCorrectamenteCuandoSeJuegaConFlor(){
        Cantos cantos = new CantosConFlor();
        Jugador unJugador = new Jugador("Juan", cantos);
        Assert.assertEquals(FlorCantada.class,unJugador.getCantosPosibles().cantarFlor(unJugador).getClass());
    }
}
