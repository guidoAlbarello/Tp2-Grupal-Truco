package fiuba.algo3;

import fiuba.algo3.Modelo.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoFaltaEnvido;
import fiuba.algo3.Modelo.Juego.Juego;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoFaltaEnvidoTest {
    private EstadoDeJuego estadoDeJuego;
    private Juego juego;
    @Before
    public void setup(){

        juego = new Juego();
        estadoDeJuego = new EstadoFaltaEnvido(juego);
    }
    @Test(expected = RuntimeException.class)
    public void seCantaEnvidoCuandoSeCantoUnFaltaEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.envido();}
    @Test(expected = RuntimeException.class)
    public void seCantaRealEnvidoCuandoSeCantoUnFaltaEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.realEnvido();}
    @Test(expected = RuntimeException.class)
    public void seCantaTrucoCuandoSeCantoUnFaltaEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.truco();}
    @Test(expected = RuntimeException.class)
    public void seCantaRetrucoCuandoSeCantoUnFaltaEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.retruco();}
    @Test(expected = RuntimeException.class)
    public void seCantaValeCuatroCuandoSeCantoUnFaltaEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.valeCuatro();}
    @Test(expected = RuntimeException.class)
    public void seVaAlMasoCuandoSeCantoUnFaltaEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.irseAlMaso();}
}