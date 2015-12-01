package fiuba.algo3;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoValeCuatro;
import fiuba.algo3.Modelo.Juego;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoValeCuatroTest {
    private EstadoDeJuego estadoDeJuego;
    private Juego juego;
    @Before
    public void setup(){
        juego = new Juego();
        estadoDeJuego = new EstadoValeCuatro(juego);
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