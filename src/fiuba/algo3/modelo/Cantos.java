package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public abstract class Cantos {
    private Jugador jugador;
    public abstract Jugada cantarEnvido(Mano unaMano);

    public abstract Jugada cantarRealEnvido(Mano unaMano);

    public abstract Jugada cantarFaltaEnvio(Mano unMano);

    public abstract void cantarFlor(Mano unaMano)throws Exception ;
}


