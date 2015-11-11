package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class AceptaEnvido extends Respuesta {
    private JugadorJugando jugadorQueLoCanto;

    public AceptaEnvido(JugadorJugando jugador) {
        this.jugadorQueLoCanto = jugador;

    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverAceptaEnvido(this);
    }

    @Override
    public JugadorJugando jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
}
