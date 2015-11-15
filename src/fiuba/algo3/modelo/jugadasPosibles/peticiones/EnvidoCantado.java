package fiuba.algo3.modelo.jugadasPosibles.peticiones;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Mesa;
import fiuba.algo3.modelo.jugadasPosibles.Jugada;

/**
 * Created by anthony on 10/11/2015.
 */
public class EnvidoCantado extends Jugada {
    private Jugador jugadorQueLoCanto;
    public EnvidoCantado(Jugador jugador) {
        jugadorQueLoCanto = jugador;
    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverEnvido(this);
    }



}
