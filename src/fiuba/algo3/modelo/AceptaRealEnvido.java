package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class AceptaRealEnvido extends Jugada {
    private Jugador jugadorQueCanta;

    public AceptaRealEnvido(Jugador jugador) {
        this.jugadorQueCanta = jugador;
    }


    public Jugador jugadorQueCanto() {
        return this.jugadorQueCanta;
    }
    public void resolverEnMesa(Mesa mesa){
        mesa.resolverAceptaRealEnvido(this);
    }

}
