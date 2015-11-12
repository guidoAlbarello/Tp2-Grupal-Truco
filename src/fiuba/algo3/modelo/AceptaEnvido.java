package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class AceptaEnvido extends Jugada {
    private Jugador jugadorQueLoCanto;

    public AceptaEnvido(Jugador jugador) {
        this.jugadorQueLoCanto = jugador;

    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverAceptaEnvido(this);
    }

    @Override
    public Jugador jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
}
