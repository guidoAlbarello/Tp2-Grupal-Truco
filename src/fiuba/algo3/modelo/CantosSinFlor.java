package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class CantosSinFlor extends Cantos {

    @Override
    public Jugada cantarEnvido(JugadorEnJuego jugador) {
        return new EnvidoCantado(jugador);
    }

    @Override
    public Jugada cantarRealEnvido(JugadorEnJuego jugador) {
        return new RealEnvido(jugador);
    }

    @Override
    public Jugada cantarFaltaEnvio(JugadorEnJuego jugador) {
        return new FaltaEnvido(jugador);
    }

    @Override
    public Jugada cantarFlor(JugadorEnJuego jugador) throws Exception {
        return null;
    }

}
