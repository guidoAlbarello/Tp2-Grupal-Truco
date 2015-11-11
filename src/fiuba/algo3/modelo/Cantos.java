package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public abstract class Cantos {


    public abstract Jugada cantarEnvido(JugadorEnJuego jugador);

    public abstract Jugada cantarRealEnvido(JugadorEnJuego jugador);

    public abstract Jugada cantarFaltaEnvio(JugadorEnJuego jugador);

    public abstract Jugada cantarFlor(JugadorEnJuego jugador)throws Exception ;
}


