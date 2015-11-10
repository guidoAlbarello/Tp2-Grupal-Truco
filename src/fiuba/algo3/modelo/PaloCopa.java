package fiuba.algo3.modelo;

/**
 * Created by Krion on 10/11/2015.
 */
public class PaloCopa extends Palo{

    @Override
    public boolean decimeQuienSos(Palo unPalo){
        return unPalo.esDelMismoPalo(this);
    }

    @Override
    public boolean esDelMismoPalo(PaloEspada unPalo){
        return false;
    }

    @Override
    public boolean esDelMismoPalo(PaloOro unPalo){
        return false;
    }

    @Override
    public boolean esDelMismoPalo(PaloBasto unPalo){
        return false;
    }

    @Override
    public boolean esDelMismoPalo(PaloCopa unPalo){
        return true;
    }
}
