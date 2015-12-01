package fiuba.algo3;

import fiuba.algo3.Modelo.Juego.Mazo;
import fiuba.algo3.Modelo.ModeladoDeCarta.*;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fechee on 19/11/2015.
 */
public class MazoTests {

    @Test
    public void testMazoReparteBienCartasDiferentes(){
        Mazo unMazo = new Mazo();
        unMazo.mezclarMazo();
        Carta carta1 = unMazo.repartirUltimaCarta();
        Assert.assertEquals(39, unMazo.obtenerNumeroDeCartas());
        Carta carta2 = unMazo.repartirUltimaCarta();
        Assert.assertTrue(carta1.getPaloDeCarta()!=carta2.getPaloDeCarta() || carta1.getValorDeCarta()!=carta2.getValorDeCarta());
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
    public void testMazoReparteTresCartas(){
        //Cantos cantos = new CantosConFlor();
        Jugador pedro = new Jugador("pedro");
        Mazo unMazo = new Mazo();
        unMazo.mezclarMazo();
        unMazo.repartirCartasAJugador(pedro);
        Assert.assertEquals(3,pedro.getMano().getCartasEnMano().size());
    }

}
