package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class EnvidoCantado extends Respuesta {
    private JugadorJugando jugadorQueLoCanto;
    public EnvidoCantado(JugadorJugando jugador) {
        jugadorQueLoCanto = jugador;
    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverEnvido(this);
    }

    public JugadorJugando jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
}
