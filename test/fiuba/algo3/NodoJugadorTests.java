package fiuba.algo3;

import fiuba.algo3.manejoDeJugadores.Jugador;
import fiuba.algo3.manejoDeJugadores.NodoJugador;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Fechee on 18/11/2015.
 */
public class NodoJugadorTests {

    @Test
    public void testComprobacionDeGettersYSetters(){
        NodoJugador primerNodo = new NodoJugador(new Jugador("Jugador del primer nodo"));
        NodoJugador segundoNodo = new NodoJugador(new Jugador("Jugador del segundo nodo"));


        // configuro los nodos con el "formato" de una lista circular de tamaño 2
        primerNodo.setSiguiente(segundoNodo);
        primerNodo.setAnterior(segundoNodo);

        segundoNodo.setSiguiente(primerNodo);
        segundoNodo.setAnterior(primerNodo);


        Assert.assertEquals(segundoNodo.getSiguiente(),primerNodo);
        Assert.assertEquals(primerNodo.getSiguiente(),segundoNodo);

        Assert.assertEquals(segundoNodo,segundoNodo.getSiguiente().getSiguiente());
        Assert.assertEquals(primerNodo,primerNodo.getSiguiente().getSiguiente());

    }
}
