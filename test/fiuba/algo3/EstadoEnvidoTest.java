package fiuba.algo3;

import fiuba.algo3.Modelo.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoEnvido;
import fiuba.algo3.Modelo.Juego.Juego;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoEnvidoTest {
    private EstadoDeJuego estadoDeJuego;
    private Juego juego;
    @Before
    public void setup(){
        juego = new Juego();
        estadoDeJuego = new EstadoEnvido(juego);
    }
    @Test(expected = RuntimeException.class)
    public void seCantaTrucoCuandoSeCantoUnEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.truco();}
    @Test(expected = RuntimeException.class)
    public void seCantaRetrucoCuandoSeCantoUnEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.retruco();}
    @Test(expected = RuntimeException.class)
    public void seCantaValeCuatroCuandoSeCantoUnEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.valeCuatro();}
    @Test(expected = RuntimeException.class)
    public void seVaAlMasoCuandoSeCantoUnEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.irseAlMaso();}

}