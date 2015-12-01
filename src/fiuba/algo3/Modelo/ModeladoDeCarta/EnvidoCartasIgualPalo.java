package fiuba.algo3.Modelo.ModeladoDeCarta;

/**
 * Created by Krion on 19/11/2015.
 */
public class EnvidoCartasIgualPalo implements Envido {
    private int valorEnvido;
    private static final int VALOR_EXTRA_ENVIDO = 20;

    @Override
    public Envido calcularEnvido(int valorUnaCarta, int valorOtraCarta) {
        this.valorEnvido = valorOtraCarta + valorUnaCarta + 20;
        return this;
    }

    public int getValorEnvido(){
        return this.valorEnvido;
    }
}
