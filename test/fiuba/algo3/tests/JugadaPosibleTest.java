import fiuba.algo3.modelo.JugadasOpcional.*;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.JugadorEnRonda;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPosibles.*;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeTurnos;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 15/11/2015.
 */
public class JugadaPosibleTest {
    @Test
    public void testHacerUnaJugada() {
        Jugador unJugador = new Jugador("Juan");
        Jugador otroJugador = new Jugador("Pepe");
        JugadorEnRonda jugadorEnRonda1 = new JugadorEnRonda(unJugador);
        JugadorEnRonda jugadorEnRonda2 = new JugadorEnRonda(otroJugador);
        ManejadorDeTurnos manejadorDeTurnos = new ManejadorDeTurnos(jugadorEnRonda1, jugadorEnRonda2);
        Mesa mesa = new Mesa(jugadorEnRonda1, jugadorEnRonda2, manejadorDeTurnos);
        ManejadorDeJugadas manejadorDeJugadas = new ManejadorDeJugadas(jugadorEnRonda1, jugadorEnRonda2, manejadorDeTurnos, mesa);

        Jugada jugadaInicial = new JugadaInicial(unJugador, 1, new ConFlor());
        JugadaPosible jugadaPosible = new JugadaPosible(jugadaInicial, manejadorDeJugadas);

        Jugada nuevoEnvido = new CantoEnvido(unJugador);
        jugadaPosible.setNuevaJugada(nuevoEnvido);

        jugadaPosible.resolverJugada();

        Jugada decisionJugada = new QuieroEnvido(unJugador);
        jugadaPosible.setNuevaJugada(decisionJugada);

        jugadaPosible.resolverJugada();

        JugadaInicial otraJugada = new JugadaInicial(unJugador, 1, new ConFlor());


        Assert.assertFalse(jugadaPosible.getJugadasPosibles().contains(CantoEnvido.class));
        Assert.assertFalse(jugadaPosible.getJugadasPosibles().contains(CantoRealEnvido.class));
        Assert.assertFalse(jugadaPosible.getJugadasPosibles().contains(CantoFaltaEnvido.class));
        Assert.assertFalse(jugadaPosible.getJugadasPosibles().contains(CantoFlor.class));
        Assert.assertTrue(jugadaPosible.getJugadasPosibles().contains(CantoTruco.class));


    }
}
