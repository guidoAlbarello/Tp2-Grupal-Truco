package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class CartaJugada extends Jugada {
    public Jugador jugadorQueLaJugo;
    public int valor;

    public CartaJugada(Jugador jugador, int valor) {
        jugadorQueLaJugo = jugador;
        this.valor = valor;
    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverCartaJugada(this);
    }

    @Override
    public Jugador jugadorQueCanto() {
        return jugadorQueLaJugo;
    }

}
