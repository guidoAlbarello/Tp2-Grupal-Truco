package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class CartaJugada extends Respuesta {
    public JugadorJugando jugadorQueLaJugo;
    public int valor;

    public CartaJugada(JugadorJugando jugador, int valor) {
        jugadorQueLaJugo = jugador;
        this.valor = valor;
    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverCartaJugada(this);
    }

    @Override
    public JugadorJugando jugadorQueCanto() {
        return jugadorQueLaJugo;
    }

}
