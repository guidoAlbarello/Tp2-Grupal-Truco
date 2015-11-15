package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import fiuba.algo3.modelo.jugadasPosibles.*;
import fiuba.algo3.modelo.jugadasPosibles.peticiones.*;

/**
 * Created by Krion on 15/11/2015.
 */
public class CantosSinFlor extends Cantos{
    @Override
    public Jugada cantarEnvido(Jugador unJugador){
        return new EnvidoCantado(unJugador);
    }

    @Override
    public Jugada cantarRealEnvido(Jugador unJugador){
        return new RealEnvidoCantado(unJugador);
    }

    @Override
    public Jugada cantarFaltaEnvido(Jugador unJugador){
        return new FaltaEnvidoCantado(unJugador);
    }

    @Override
    public Jugada cantarFlor(Jugador unJugador){
        throw new NoSeEstaJugandoConFlorError();
    }

    @Override
    public Jugada cantarTruco(Jugador unJugador){
        return new TrucoCantado(unJugador);
    }

    @Override
    public Jugada cantarReTruco(Jugador unJugador){
        return new ReTrucoCantado(unJugador);
    }

    @Override
    public Jugada cantarValeCuatro(Jugador unJugador){
        return new ValeCuatroCantado(unJugador);
    }
}
