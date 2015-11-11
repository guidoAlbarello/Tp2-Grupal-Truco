package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class CantosSinFlor extends Cantos {

    public Jugada cantarEnvido(Mano unaMano){
        return null;
    }

    public Jugada cantarRealEnvido(Mano unaMano){
        return null;
    }

    public Jugada cantarFaltaEnvio(Mano unMano){
        return null;
    }

    public void cantarFlor(Mano unaMano) throws Exception {
        throw new Exception("Se esta jugando SIN Flor!!");
    }
}
