import fiuba.algo3.modelo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 11/11/2015.
 */
public class TrucoTest {
    private Cantos cantos;
    private Jugador jugador1;
    private Jugador jugador2;
    private Palo basto;
    private Palo espada;
    private Palo copa;
    private Palo oro;

    @Before
    public void setup(){
        cantos = new CantosConFlor();
        jugador1 = new Jugador("jugador1",cantos);
        jugador2 = new Jugador("jugador2",cantos);
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

        jugador1.recibirCarta(carta7espada);
        jugador1.recibirCarta(carta6espada);
        jugador1.recibirCarta(carta4oro);

        jugador2.recibirCarta(carta5oro);
        jugador2.recibirCarta(carta1basto);
        jugador2.recibirCarta(carta1copa);

        Mesa mesa = new Mesa(jugador1,jugador2);
        mesa.resolverJugada(jugador1.getCantosPosibles().cantarEnvido(jugador1));
        Assert.assertTrue(jugador1.puntaje() == 2);
    }

    @Test
    public void jugadorCantaEnvidoCon6YGanaEnvidoOtroJugadorCon7(){
        Carta carta7espada = new Carta(7,espada);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugador1.recibirCarta(carta6espada);
        jugador1.recibirCarta(carta1basto);
        jugador1.recibirCarta(carta4oro);

        jugador2.recibirCarta(carta5oro);
        jugador2.recibirCarta(carta7espada);
        jugador2.recibirCarta(carta1copa);

        Mesa mesa = new Mesa(jugador1,jugador2);
        mesa.resolverJugada(jugador1.getCantosPosibles().cantarEnvido(jugador1));
        Assert.assertTrue(jugador2.puntaje() == 2);
    }
    @Test
    public void siSeCantaEnvidoYSonIgualesGanaJugadorMano(){
        Carta carta6basto = new Carta(6,basto);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugador1.recibirCarta(carta6espada);
        jugador1.recibirCarta(carta1basto);
        jugador1.recibirCarta(carta4oro);

        jugador2.recibirCarta(carta5oro);
        jugador2.recibirCarta(carta6basto);
        jugador2.recibirCarta(carta1copa);

        Mesa mesa = new Mesa(jugador1,jugador2);
        mesa.resolverJugada(jugador1.getCantosPosibles().cantarEnvido(jugador1));//jugador 1 es mano por q es el que inicia la jugada
        Assert.assertTrue(jugador1.puntaje() == 2);
    }

    @Test
    public void jugadorCantaEnvidoYElOtroNoAceptaEntoncesSuma1Punto(){
        Carta carta7espada = new Carta(7,espada);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugador1.recibirCarta(carta7espada);
        jugador1.recibirCarta(carta6espada);
        jugador1.recibirCarta(carta4oro);

        jugador2.recibirCarta(carta5oro);
        jugador2.recibirCarta(carta1basto);
        jugador2.recibirCarta(carta1copa);

        Mesa mesa = new Mesa(jugador1,jugador2);
        mesa.resolverJugada(jugador1.noAceptarEnvio());
        Assert.assertTrue(jugador2.puntaje() == 1);
    }

    @Test
    public void jugadorCantaRealEnvidoCon33YGanaRealEnvido(){
        Carta carta7espada = new Carta(7,espada);
        Carta carta6espada = new Carta(6,espada);
        Carta carta4oro = new Carta(4,oro);
        Carta carta5oro = new Carta(5,oro);
        Carta carta1basto = new Carta(1,basto);
        Carta carta1copa = new Carta(1,copa);

        jugador1.recibirCarta(carta7espada);
        jugador1.recibirCarta(carta6espada);
        jugador1.recibirCarta(carta4oro);

        jugador2.recibirCarta(carta5oro);
        jugador2.recibirCarta(carta1basto);
        jugador2.recibirCarta(carta1copa);

        Mesa mesa = new Mesa(jugador1,jugador2);
        mesa.resolverJugada(jugador1.getCantosPosibles().cantarRealEnvido(jugador1));
        Assert.assertTrue(jugador1.puntaje() == 4);
    }
}
