package fiuba.algo3.modelo;

/**
 * Created by Krion on 10/11/2015.
 */
public class EnvidoCartasDiferentePalo implements Envido {
    private int valorEnvido;

    @Override
    public Envido calcularEnvido(int valorUnaCarta, int valorOtraCarta) {
        if(valorUnaCarta < valorOtraCarta){
            this.valorEnvido = valorOtraCarta;
        }else{
            this.valorEnvido = valorUnaCarta;
        }
        return this;
    }

    public int getValorEnvido(){
        return this.valorEnvido;
    }
}