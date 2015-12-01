package fiuba.algo3;

import fiuba.algo3.Modelo.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.Modelo.EstadosDeJuego.EstadoRetruco;
import fiuba.algo3.Modelo.Juego.Juego;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anthony on 18/11/2015.
 */
public class EstadoRetrucoTest {
    private EstadoDeJuego estadoDeJuego;
    private Juego juego;
    @Before
    public void setup(){
        juego = new Juego();
        estadoDeJuego = new EstadoRetruco(juego);
    }
    @Test(expected = RuntimeException.class)
    public void seCantaTrucoCuandoYaSeCantoUnRetrucoYSeLanzaUnaExcepcion(){estadoDeJuego.truco();}
    @Test(expected = RuntimeException.class)
    public void seCantaRetrucoCuandoYaSeCantoUnRetrucoYSeLanzaUnaExcepcion(){estadoDeJuego.retruco();}
    @Test(expected = RuntimeException.class)
    public void seVaAlMasoCuandoSeCantoUnRetrucoYSeLanzaUnaExcepcion(){estadoDeJuego.irseAlMaso();}
}
