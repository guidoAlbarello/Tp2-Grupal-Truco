package fiuba.algo3;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoRealEnvido;
import fiuba.algo3.Modelo.Juego;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoRealEnvidoTest {
    private EstadoDeJuego estadoDeJuego;
    private Juego juego;
    @Before
    public void setup(){
        juego = new Juego();
        estadoDeJuego = new EstadoRealEnvido(juego);
    }
    @Test(expected = RuntimeException.class)
    public void seCantaEnvidoCuandoSeCantoUnRealEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.envido();}
    @Test(expected = RuntimeException.class)
    public void seCantaRealEnvidoCuandoSeCantoUnRealEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.realEnvido();}
    @Test(expected = RuntimeException.class)
    public void seCantaTrucoCuandoSeCantoUnRealEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.truco();}
    @Test(expected = RuntimeException.class)
    public void seCantaRetrucoCuandoSeCantooUnRealEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.retruco();}
    @Test(expected = RuntimeException.class)
    public void seCantaValeCuatroCuandoSeCantoUnRealEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.valeCuatro();}
    @Test(expected = RuntimeException.class)
    public void seVaAlMasoCuandoSeCantoUnRealEnvidoYSeLanzaUnaExcepcion(){estadoDeJuego.irseAlMaso();}

}
