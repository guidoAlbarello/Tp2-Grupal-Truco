import fiuba.algo3.modelo.ManejadorDePuntaje;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 12/11/2015.
 */
public class ManejadorDePuntajeTest {
    @Test
    public void testPruebaDeModificacionYRetribucionDePuntajeCorrectamente(){
        String jugador1 = "Juan";
        String jugador2 = "Pedro";
        ManejadorDePuntaje manejadorDePuntaje = new ManejadorDePuntaje(jugador1, jugador2);

        int puntajeGanado;

        Assert.assertEquals(0, manejadorDePuntaje.getPuntaje(jugador1));
        Assert.assertEquals(0, manejadorDePuntaje.getPuntaje(jugador2));

        puntajeGanado = 3;
        manejadorDePuntaje.sumaPuntaje(jugador1, puntajeGanado);

        puntajeGanado = 5;
        manejadorDePuntaje.sumaPuntaje(jugador2, puntajeGanado);

        Assert.assertEquals(3, manejadorDePuntaje.getPuntaje(jugador1));
        Assert.assertEquals(5, manejadorDePuntaje.getPuntaje(jugador2));

        manejadorDePuntaje.sumaPuntaje(jugador1, puntajeGanado);

        puntajeGanado = 1;
        manejadorDePuntaje.sumaPuntaje(jugador2, puntajeGanado);

        Assert.assertEquals(8, manejadorDePuntaje.getPuntaje(jugador1));
        Assert.assertEquals(6, manejadorDePuntaje.getPuntaje(jugador2));
    }
}
