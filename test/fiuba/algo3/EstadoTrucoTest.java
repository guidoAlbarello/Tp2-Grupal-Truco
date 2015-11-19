package fiuba.algo3;
import fiuba.algo3.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.EstadosDeJuego.EstadoTruco;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoTrucoTest {
    private EstadoDeJuego estadoDeJuego;
    @Before
    public void setup(){
        estadoDeJuego = new EstadoTruco();
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