import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.jugadasPosibles.ConFlor;
import fiuba.algo3.modelo.jugadasPosibles.SeJuegaConFlor;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeTurnos;
import fiuba.algo3.modelo.palosPosibles.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 11/11/2015.
 */
public class TrucoTest {
    private SeJuegaConFlor seJuegaConFlor;
    private Jugador jugador1;
    private Jugador jugador2;
    private JugadorEnRonda jugadorEnRonda1;
    private JugadorEnRonda jugadorEnRonda2;
    private ManejadorDeTurnos manejadorDeTurnos;
    private Palo basto;
    private Palo espada;
    private Palo copa;
    private Palo oro;

    @Before
    public void setup(){
        seJuegaConFlor = new ConFlor();
        jugador1 = new Jugador("jugador1",seJuegaConFlor);
        jugador2 = new Jugador("jugador2",seJuegaConFlor);
        jugadorEnRonda1 = new JugadorEnRonda(jugador1);
        jugadorEnRonda2 = new JugadorEnRonda(jugador2);
        manejadorDeTurnos = new ManejadorDeTurnos(jugadorEnRonda1,jugadorEnRonda2);
        basto = new PaloBasto();
        espada = new PaloEspada();
        copa = new PaloCopa();
        oro = new PaloOro();
    }

    @Test
    public void jugadorCantaEnvidoCon33YGanaEnvido(){
        Carta carta7espada = new Carta(7,espada);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugadorEnRonda1.getJugador().getMano().agregarCarta(carta7espada);
        jugadorEnRonda1.getJugador().getMano().agregarCarta(carta6espada);
        jugadorEnRonda1.getJugador().getMano().agregarCarta(carta4oro);

        jugadorEnRonda2.getJugador().getMano().agregarCarta(carta5oro);
        jugadorEnRonda2.getJugador().getMano().agregarCarta(carta1basto);
        jugadorEnRonda2.getJugador().getMano().agregarCarta(carta1copa);

        Mesa mesa = new Mesa(jugadorEnRonda1,jugadorEnRonda2,manejadorDeTurnos);
        mesa.resolverJugada(jugadorEnRonda1.getJugador().seleccionarJugada("EnvidoCantado"));
        Assert.assertTrue(jugadorEnRonda1.getPuntosGanadosEnRonda() == 2);
    }

    @Test
    public void jugadorCantaEnvidoCon6YGanaEnvidoOtroJugadorCon7(){
        Carta carta7espada = new Carta(7,espada);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugadorEnRonda1.getJugador().getMano().agregarCarta(carta1copa);
        jugadorEnRonda1.getJugador().getMano().agregarCarta(carta6espada);
        jugadorEnRonda1.getJugador().getMano().agregarCarta(carta4oro);

        jugadorEnRonda2.getJugador().getMano().agregarCarta(carta5oro);
        jugadorEnRonda2.getJugador().getMano().agregarCarta(carta1basto);
        jugadorEnRonda2.getJugador().getMano().agregarCarta(carta7espada);

        Mesa mesa = new Mesa(jugadorEnRonda1,jugadorEnRonda2,manejadorDeTurnos);
        mesa.resolverJugada(jugadorEnRonda1.getJugador().seleccionarJugada("EnvidoCantado"));
        Assert.assertTrue(jugadorEnRonda2.getPuntosGanadosEnRonda() == 2);
    }
    @Test
    public void siSeCantaEnvidoYSonIgualesGanaJugadorMano(){
        Carta carta6basto = new Carta(6,basto);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugador1.getMano().agregarCarta(carta6espada);
        jugador1.getMano().agregarCarta(carta1basto);
        jugador1.getMano().agregarCarta(carta4oro);

        jugador2.getMano().agregarCarta(carta5oro);
        jugador2.getMano().agregarCarta(carta6basto);
        jugador2.getMano().agregarCarta(carta1copa);

        Mesa mesa = new Mesa(jugadorEnRonda1,jugadorEnRonda2,manejadorDeTurnos);
        mesa.resolverJugada(jugadorEnRonda1.getJugador().seleccionarJugada("EnvidoCantado"));//jugador 1 es mano por q es el que inicia la jugada
        Assert.assertTrue(jugadorEnRonda1.getPuntosGanadosEnRonda() == 2);
    }

    @Test
    public void jugadorCantaEnvidoYElOtroNoAceptaEntoncesSuma1Punto(){
        Carta carta7espada = new Carta(7,espada);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugador1.getMano().agregarCarta(carta7espada);
        jugador1.getMano().agregarCarta(carta6espada);
        jugador1.getMano().agregarCarta(carta4oro);

        jugador2.getMano().agregarCarta(carta5oro);
        jugador2.getMano().agregarCarta(carta1basto);
        jugador2.getMano().agregarCarta(carta1copa);

        Mesa mesa = new Mesa(jugadorEnRonda1,jugadorEnRonda2,manejadorDeTurnos);
        mesa.resolverJugada(jugadorEnRonda1.getJugador().noAceptarEnvio());
        Assert.assertTrue(jugadorEnRonda2.getPuntosGanadosEnRonda() == 1);
    }

    @Test
    public void jugadorCantaRealEnvidoCon33YGanaRealEnvido(){
        Carta carta7espada = new Carta(7,espada);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugador1.getMano().agregarCarta(carta7espada);
        jugador1.getMano().agregarCarta(carta6espada);
        jugador1.getMano().agregarCarta(carta4oro);

        jugador2.getMano().agregarCarta(carta5oro);
        jugador2.getMano().agregarCarta(carta1basto);
        jugador2.getMano().agregarCarta(carta1copa);

        Mesa mesa = new Mesa(jugadorEnRonda1,jugadorEnRonda2,manejadorDeTurnos);
        mesa.resolverJugada(jugadorEnRonda1.getJugador().seleccionarJugada("RealEnvidoCantado"));
        Assert.assertTrue(jugadorEnRonda1.getPuntosGanadosEnRonda() == 4);
    }


}

