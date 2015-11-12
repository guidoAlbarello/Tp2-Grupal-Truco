package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public abstract class Palo {

    public boolean esDelMismoPaloQue(Palo unPalo){
        return unPalo.decimeQuienSos(this);
    }

    protected abstract boolean decimeQuienSos(Palo palo);

    public abstract boolean esDelMismoPalo(PaloBasto unPalo);

    public abstract boolean esDelMismoPalo(PaloOro unPalo);

    public abstract boolean esDelMismoPalo(PaloCopa unPalo);

    public abstract boolean esDelMismoPalo(PaloEspada unPalo);


    public abstract int getValorDeHash();
}
