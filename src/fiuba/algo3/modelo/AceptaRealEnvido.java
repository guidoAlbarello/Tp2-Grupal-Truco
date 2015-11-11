package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class AceptaRealEnvido extends Respuesta {
    private JugadorJugando jugadorQueCanta;

    public AceptaRealEnvido(JugadorJugando jugador) {
        this.jugadorQueCanta = jugador;
    }

    @Override
    public JugadorJugando jugadorQueCanto() {
        return this.jugadorQueCanta;
    }
    public void resolverEnMesa(Mesa mesa){
        mesa.resolverAceptaRealEnvido(this);
    }

}
