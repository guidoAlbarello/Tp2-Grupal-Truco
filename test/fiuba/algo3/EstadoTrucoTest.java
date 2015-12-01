package fiuba.algo3;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoTruco;
import fiuba.algo3.Modelo.Juego.Juego;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoTrucoTest {
    private EstadoDeJuego estadoDeJuego;
    private Juego juego;
    @Before
    public void setup(){
        juego = new Juego();
        estadoDeJuego = new EstadoTruco(juego);
    }
    @Test(expected = RuntimeException.class)
    public void seCantaTrucoCuandoSeCantoUnTrucoYSeLanzaUnaExcepcion(){estadoDeJuego.truco();}
    @Test(expected = RuntimeException.class)
    public void seCantaRetrucoCuandoNoSeCantoUnTrucoYSeLanzaUnaExcepcion(){estadoDeJuego.realEnvido();}
    @Test(expected = RuntimeException.class)
    public void seCantaValeCuatroCuandoNoSeCantoUnTrucoYSeLanzaUnaExcepcion(){estadoDeJuego.valeCuatro();}
    @Test(expected = RuntimeException.class)
    public void seVaAlMasoCuandoSeCantoUnTrucoYSeLanzaUnaExcepcion(){estadoDeJuego.irseAlMaso();}
}