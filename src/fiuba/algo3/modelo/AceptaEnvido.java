package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class AceptaEnvido extends Jugada {
    private JugadorEnJuego jugadorQueLoCanto;

    public AceptaEnvido(JugadorEnJuego jugador) {
        this.jugadorQueLoCanto = jugador;

    }

    public void resolverEnMesa(Mesa mesa){
        mesa.resolverAceptaEnvido(this);
    }

    @Override
    public JugadorEnJuego jugadorQueCanto() {
        return this.jugadorQueLoCanto;
    }
}
