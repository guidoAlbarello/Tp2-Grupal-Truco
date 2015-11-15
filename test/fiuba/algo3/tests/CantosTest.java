import fiuba.algo3.modelo.JuegoTruco;
import fiuba.algo3.modelo.JugadorEnRonda;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJuego;
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
        JugadorEnRonda.Cantos cantos = new JuegoTruco.CantosSinFlor();
        Jugador unJugador = new Jugador("Juan", cantos);
        unJugador.getCantosPosibles().cantarFlor(unJugador);
    }

    @Test
    public void testChequeoDeQueSePuedaCantarFlorCorrectamenteCuandoSeJuegaConFlor(){
        JugadorEnRonda.Cantos cantos = new ManejadorDeJuego.CantosConFlor();
        Jugador unJugador = new Jugador("Juan", cantos);
        Assert.assertEquals(null, unJugador.getCantosPosibles().cantarFlor(unJugador));
    }
}
