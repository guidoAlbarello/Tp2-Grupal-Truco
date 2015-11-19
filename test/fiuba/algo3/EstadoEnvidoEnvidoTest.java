package fiuba.algo3;

import fiuba.algo3.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.EstadosDeJuego.EstadoEnvido;
import fiuba.algo3.EstadosDeJuego.EstadoEnvidoEnvido;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 19/11/2015.
 */
public class EstadoEnvidoEnvidoTest {
    private EstadoDeJuego estadoDeJuego;
    private Juego juego;
    @Before
    public void setup(){
        juego = new Juego();
        estadoDeJuego = new EstadoEnvidoEnvido(juego);
    }
    @Test(expected = RuntimeException.class)
    public void seCantaEnvidoCuandoSeCantoUnEnvidoEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.envido();}
    @Test(expected = RuntimeException.class)
    public void seCantaTrucoCuandoSeCantoUnEnvidoEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.truco();}
    @Test(expected = RuntimeException.class)
    public void seCantaRetrucoCuandoSeCantoUnEnvidoEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.retruco();}
    @Test(expected = RuntimeException.class)
    public void seCantaValeCuatroCuandoSeCantoUnEnvidoEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.valeCuatro();}
    @Test(expected = RuntimeException.class)
    public void seVaAlMasoCuandoSeCantoUnEnvidoEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.irseAlMaso();}
}
