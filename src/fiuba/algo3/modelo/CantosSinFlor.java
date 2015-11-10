package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class CantosSinFlor extends Cantos {
    public CantosSinFlor(Mano unaMano) {
        super(unaMano);
    }


    public int calcularFlor(Mano unaMano) throws Exception{
        throw new Exception("Se esta jugando sin flor!");
        //TODO: CAMBIAR Y CREAR EXEPCION NUEVA
    }
}
