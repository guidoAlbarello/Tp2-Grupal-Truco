package fiuba.algo3.modelo;

/**
 * Created by Fechee on 14/11/2015.
 */
public class ReTrucoAceptado extends Jugada {
    public ReTrucoAceptado(Jugador jugador) {
        super();
    }


    public Jugador jugadorQueCanto() {
        return null;
    }

    @Override
    public void resolverEnMesa(Mesa mesa) {
        mesa.setPuntosEnJuego(2);
    }
}
