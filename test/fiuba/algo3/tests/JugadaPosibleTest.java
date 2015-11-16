import fiuba.algo3.modelo.jugadasPosibles.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Krion on 15/11/2015.
 */
public class JugadaPosibleTest {
    @Test
    public void testMostrarLasOpcionesDeJugadasPosibleARealizar(){
        SeJuegaConFlor seJuegaConFlor = new ConFlor();
        JugadaPosible jugadaPosible = new JugadaDePeticion(seJuegaConFlor);

        Assert.assertTrue(jugadaPosible.compararNombresJugadas("CartaJugada") >=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("EnvidoCantado") >=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("RealEnvidoCantado") >=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("FaltaEnvidoCantado") >=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("FlorCantada") >=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("TrucoCantado") >=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("ReTrucoCantado") >=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("ValeCuatroCantado") >=0);

        Assert.assertFalse(jugadaPosible.compararNombresJugadas("AceptaEnvido") >=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("AceptaRealEnvido") >=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("NoAceptaEnvido") >=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("ReTrucoAceptado")  >=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("TrucoAceptado") >=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("ValeCuatroAceptado") >=0);

        jugadaPosible = new JugadaDeRespuestaAPeticion(jugadaPosible.getSeJuegaConFlor());

        Assert.assertFalse(jugadaPosible.compararNombresJugadas("EnvidoCantado") >=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("RealEnvidoCantado") >=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("FaltaEnvidoCantado")>=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("FlorCantada")>=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("TrucoCantado")>=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("ReTrucoCantado")>=0);
        Assert.assertFalse(jugadaPosible.compararNombresJugadas("ValeCuatroCantado")>=0);

        Assert.assertTrue(jugadaPosible.compararNombresJugadas("CartaJugada")>=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("AceptaEnvido")>=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("AceptaRealEnvido")>=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("NoAceptaEnvido")>=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("ReTrucoAceptado")>=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("TrucoAceptado")>=0);
        Assert.assertTrue(jugadaPosible.compararNombresJugadas("ValeCuatroAceptado")>=0);
    }
}
