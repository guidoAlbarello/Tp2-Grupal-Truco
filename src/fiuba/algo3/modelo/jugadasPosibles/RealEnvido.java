package fiuba.algo3.modelo.jugadasPosibles;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;

/**
 * Created by anthony on 10/11/2015.
 */
public class RealEnvido extends Jugada {
    private Jugador jugadorQueLoCanto;

    public RealEnvido(Jugador jugador){
        this.jugadorQueLoCanto = jugador;
    }

    public Jugador jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
    public void resolverEnMesa(Mesa mesa){
        mesa.resolverRealEnvido(this);
    }

}
