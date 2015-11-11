import fiuba.algo3.modelo.Carta;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Palo;
import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.modelo.Mazo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class MazoTest {

    @Test
    public void testMazoReparteBien(){
        Mazo unMazo = new Mazo();
        unMazo.mezclarMazo();
        Carta carta1 = unMazo.repartirUltimaCarta();
        Assert.assertEquals(39, unMazo.obtenerNumeroDeCartas());
        Carta carta2 = unMazo.repartirUltimaCarta();
        Assert.assertTrue(carta1.getPaloDeCarta()!=carta2.getPaloDeCarta() & carta1.getValorDeCarta()!=carta2.getValorDeCarta());
        Assert.assertEquals(38, unMazo.obtenerNumeroDeCartas());
    }


    @Test
    public void testMazoReparteUnaCartaYEstaDesapareceDelMazo(){
        Mazo unMazo = new Mazo();
        Carta carta1 = unMazo.repartirUltimaCarta();
        Palo palo = carta1.getPaloDeCarta();
        int valor = carta1.getValorDeCarta();
        for (Carta unaCarta : unMazo.getMazoDelJuego() ){
            Assert.assertFalse(unaCarta.getPaloDeCarta()==palo  &  unaCarta.getValorDeCarta()==valor);
        }
    }


    @Test
    public void testMazoReparteCartasAlJugadorCorrectamente(){
        Jugador pedro = new Jugador("pedro");
        Mazo unMazo = new Mazo();
        unMazo.mezclarMazo();
        unMazo.repartirCartasAJugador(pedro);
        Assert.assertEquals(3,pedro.getMano().getCartasEnMano().size());
    }

}
