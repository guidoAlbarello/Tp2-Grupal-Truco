package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public abstract class Cantos {

    public Jugada jugarCarta(Carta carta,Jugador jugador){
        return null;
    }
    public abstract Jugada cantarEnvido(Jugador jugador);

    public abstract Jugada cantarRealEnvido(Jugador jugador);

    public abstract Jugada cantarFaltaEnvido(Jugador jugador);

    public abstract Jugada cantarFlor(Jugador jugador)throws Exception ;
}


