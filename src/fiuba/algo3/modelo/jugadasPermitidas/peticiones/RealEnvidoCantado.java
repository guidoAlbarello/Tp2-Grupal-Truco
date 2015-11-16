package fiuba.algo3.modelo.jugadasPermitidas.peticiones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;

/**
 * Created by anthony on 10/11/2015.
 */
public class RealEnvidoCantado extends Jugada {
    private Jugador jugadorQueLoCanto;

    public RealEnvidoCantado(Jugador jugador){
        this.jugadorQueLoCanto = jugador;
    }

    public Jugador jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
    public void resolverEnMesa(Mesa mesa){
        mesa.resolverRealEnvido(this);
    }

}
