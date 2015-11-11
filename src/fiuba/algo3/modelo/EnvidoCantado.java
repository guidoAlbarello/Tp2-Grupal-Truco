package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class EnvidoCantado extends Jugada {
    private JugadorEnJuego jugadorQueLoCanto;
    public EnvidoCantado(JugadorEnJuego jugador) {
        jugadorQueLoCanto = jugador;
    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverEnvido(this);
    }

    public JugadorEnJuego jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
}
