package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class RealEnvido extends Jugada {
    private JugadorEnJuego jugadorQueLoCanto;

    public RealEnvido(JugadorEnJuego jugador){
        this.jugadorQueLoCanto = jugador;
    }

    public JugadorEnJuego jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
    public void resolverEnMesa(Mesa mesa){
        mesa.resolverRealEnvido(this);
    }

}
