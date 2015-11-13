package fiuba.algo3.modelo;

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
