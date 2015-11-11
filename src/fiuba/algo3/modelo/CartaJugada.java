package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class CartaJugada extends Jugada {
    public JugadorEnJuego jugadorQueLaJugo;
    public int valor;

    public CartaJugada(JugadorEnJuego jugador, int valor) {
        jugadorQueLaJugo = jugador;
        this.valor = valor;
    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverCartaJugada(this);
    }

    @Override
    public JugadorEnJuego jugadorQueCanto() {
        return jugadorQueLaJugo;
    }

}
