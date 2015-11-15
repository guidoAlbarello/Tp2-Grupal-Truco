package fiuba.algo3.modelo;

import fiuba.algo3.modelo.jugadasPosibles.Jugada;

/**
 * Created by Krion on 15/11/2015.
 */
public abstract class Cantos {
    public abstract Jugada cantarEnvido(Jugador jugador);

    public abstract Jugada cantarRealEnvido(Jugador jugador);

    public abstract Jugada cantarFaltaEnvido(Jugador jugador);

    public abstract Jugada cantarFlor(Jugador jugador);

    public abstract Jugada cantarTruco(Jugador jugador);

    public abstract Jugada cantarReTruco(Jugador jugador);

    public abstract Jugada cantarValeCuatro(Jugador jugador);
}

