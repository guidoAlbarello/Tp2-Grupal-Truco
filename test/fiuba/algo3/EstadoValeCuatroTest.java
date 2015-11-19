package fiuba.algo3;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoValeCuatroTest {
    private EstadoDeJuego estadoDeJuego;
    @Before
    public void setup(){
        estadoDeJuego = new EstadoValeCuatro();
    }
    @Test(expected = RuntimeException.class)
    public void seCantaTrucoCuandoYaSeCantoUnValeCuatroYSeLanzaUnaExcepcion(){estadoDeJuego.truco();}
    @Test(expected = RuntimeException.class)
    public void seCantaValeCuatroCuandoYaSeCantoUnValeCuatroYSeLanzaUnaExcepcion(){estadoDeJuego.valeCuatro();}
    @Test(expected = RuntimeException.class)
    public void seCantaRetrucoCuandoYaSeCantoUnValeCuatroYSeLanzaUnaExcepcion(){estadoDeJuego.retruco();}
    @Test(expected = RuntimeException.class)
    public void seVaAlMasoCuandoSeCantoUnValeCuatroYSeLanzaUnaExcepcion(){estadoDeJuego.irseAlMaso();}
}