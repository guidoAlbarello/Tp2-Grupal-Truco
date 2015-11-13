package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;

/**
 * Created by Fechee on 10/11/2015.
 */
public class CantosSinFlor extends Cantos {

    @Override
    public Jugada cantarEnvido(Jugador jugador) {
        return new EnvidoCantado(jugador);
    }

    @Override
    public Jugada cantarRealEnvido(Jugador jugador) {
        return new RealEnvido(jugador);
    }

    @Override
    public Jugada cantarFaltaEnvido(Jugador jugador) {
        return new FaltaEnvido(jugador);
    }

    @Override
    public Jugada cantarFlor(Jugador jugador){
        throw new NoSeEstaJugandoConFlorError();
    }

}
