package fiuba.algo3;

import fiuba.algo3.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.EstadosDeJuego.EstadoPrimeraMano;
import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.ModeladoDeCarta.Palo;
import fiuba.algo3.ModeladoDeCarta.PaloEspada;
import fiuba.algo3.manejoDeJugadores.Jugador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 19/11/2015.
 */
public class JuegoTest {
    private Juego juego;
    private EstadoDeJuego estadoDeJuego;
    private Carta carta;
    private CartaJugada cartaJugada;
    private Jugador jugador;
    private Mesa mesaDeJuego;

    @Before
    public void setup(){
        juego = new Juego();
        estadoDeJuego = new EstadoPrimeraMano(juego);
        juego.setEstadoDeJuego(estadoDeJuego);
        Palo unPalo = new PaloEspada();
        carta = new Carta(2, unPalo);
        jugador = new Jugador("nombre");
        cartaJugada = new CartaJugada(carta,jugador);
        mesaDeJuego = new Mesa();

    }

    @Test
    public void seJuegaUnaCartaEnEstadoPrimeraManoYEstaSeguardaEnMesa(){
        juego.jugarCarta(cartaJugada);
        Assert.assertTrue(juego.mesaDelJuego().listaDeCartasJugadas().size() == 1);
    }

}
