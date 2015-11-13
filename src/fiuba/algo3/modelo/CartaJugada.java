package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class CartaJugada extends Jugada {
    public JugadorEnRonda jugadorQueLaJugo;
    public Carta carta;

    public CartaJugada(JugadorEnRonda jugador, Carta carta) {
        jugadorQueLaJugo = jugador;
        this.carta = carta;
    }



    public void resolverEnMesa(Mesa mesa){
        mesa.resolverCartaJugada(this);
    }


    public JugadorEnRonda jugadorQueCanto() {
        return jugadorQueLaJugo;
    }

}
