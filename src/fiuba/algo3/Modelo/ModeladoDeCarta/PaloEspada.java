package fiuba.algo3.Modelo.ModeladoDeCarta;

/**
 * Created by Krion on 19/11/2015.
 */
public class PaloEspada extends Palo {
    @Override
    public boolean decimeQuienSos(Palo unPalo){
        return unPalo.esDelMismoPalo(this);
    }

    @Override
    public boolean esDelMismoPalo(PaloEspada unPalo){
        return true;
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
        return false;
    }

    @Override
    public int getValorDeHash(){
        return 0;
    }


    public String getNombre() {
        return "Espada";
    }


}
