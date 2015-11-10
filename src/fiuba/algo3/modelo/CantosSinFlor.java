package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class CantosSinFlor extends Cantos {

    public void cantarEnvido(Mano unaMano){
    }

    public void cantarFlor(Mano unaMano) throws Exception {
        throw new Exception("Se esta jugando SIN Flor!!");
    }
}
