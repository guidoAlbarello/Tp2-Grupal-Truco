package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class AceptaRealEnvido extends Jugada {
    private JugadorEnJuego jugadorQueCanta;

    public AceptaRealEnvido(JugadorEnJuego jugador) {
        this.jugadorQueCanta = jugador;
    }

    @Override
    public JugadorEnJuego jugadorQueCanto() {
        return this.jugadorQueCanta;
    }
    public void resolverEnMesa(Mesa mesa){
        mesa.resolverAceptaRealEnvido(this);
    }

}
