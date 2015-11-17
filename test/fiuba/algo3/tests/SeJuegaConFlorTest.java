import fiuba.algo3.modelo.JugadasOpcional.CantoFlor;
import fiuba.algo3.modelo.JugadasOpcional.Jugada;
import fiuba.algo3.modelo.JugadasOpcional.JugadaInicial;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.NoExisteLaJugadaError;
import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import fiuba.algo3.modelo.jugadasPosibles.ConFlor;
import fiuba.algo3.modelo.jugadasPosibles.JugadaPosible;
import fiuba.algo3.modelo.jugadasPosibles.SeJuegaConFlor;
import fiuba.algo3.modelo.jugadasPosibles.SinFlor;
import org.junit.Assert;
import org.junit.Test;
 /**
 * Created by Krion on 13/11/2015.
 */
public class SeJuegaConFlorTest {
    @Test(expected = NoExisteLaJugadaError.class)
    public void testChequeoDeErrorAlCantarFlorCuandoSeJuegaSinFlor(){
        SeJuegaConFlor seJuegaConFlor = new SinFlor();
        Jugador unJugador = new Jugador("Juan");
        Jugada jugadaInicial = new JugadaInicial(unJugador, 1, seJuegaConFlor);
        JugadaPosible jugadaPosible = new JugadaPosible(jugadaInicial);
        jugadaPosible.setNuevaJugada(new CantoFlor(unJugador));
    }

    @Test
    public void testChequeoDeQueSePuedaCantarFlorCorrectamenteCuandoSeJuegaConFlor(){
        SeJuegaConFlor seJuegaConFlor = new ConFlor();
        Jugador unJugador = new Jugador("Juan");
        Jugada jugadaInicial = new JugadaInicial(unJugador, 1, seJuegaConFlor);
        JugadaPosible jugadaPosible = new JugadaPosible(jugadaInicial);
        jugadaPosible.setNuevaJugada(new CantoFlor(unJugador));
        Assert.assertTrue(jugadaPosible.esUnaJugadaValida(new CantoFlor(unJugador)));
    }
}