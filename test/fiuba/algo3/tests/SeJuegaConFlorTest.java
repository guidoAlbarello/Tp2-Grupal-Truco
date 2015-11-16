import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import fiuba.algo3.modelo.jugadasPermitidas.peticiones.FlorCantada;
import fiuba.algo3.modelo.jugadasPosibles.ConFlor;
import fiuba.algo3.modelo.jugadasPosibles.SeJuegaConFlor;
import fiuba.algo3.modelo.jugadasPosibles.SinFlor;
import org.junit.Assert;
import org.junit.Test;
 /**
 * Created by Krion on 13/11/2015.
 */
public class SeJuegaConFlorTest {
    @Test(expected = NoSeEstaJugandoConFlorError.class)
    public void testChequeoDeErrorAlCantarFlorCuandoSeJuegaSinFlor(){
        SeJuegaConFlor seJuegaConFlor = new SinFlor();
        Jugador unJugador = new Jugador("Juan", seJuegaConFlor);
        unJugador.seleccionarJugada("FlorCantada");
    }

    @Test
    public void testChequeoDeQueSePuedaCantarFlorCorrectamenteCuandoSeJuegaConFlor(){
        SeJuegaConFlor seJuegaConFlor = new ConFlor();
        Jugador unJugador = new Jugador("Juan", seJuegaConFlor);
        Assert.assertEquals(FlorCantada.class.getName(), unJugador.seleccionarJugada("FlorCantada").getClass().getName());
    }
}