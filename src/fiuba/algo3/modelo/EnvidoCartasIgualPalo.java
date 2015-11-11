package fiuba.algo3.modelo;

/**
 * Created by Krion on 10/11/2015.
 */
public class EnvidoCartasIgualPalo implements Envido {
    private int valorEnvido;
    private final int VALOR_EXTRA_ENVIDO = 20;

    @Override
    public Envido calcularEnvido(int valorUnaCarta, int valorOtraCarta) {
        this.valorEnvido = valorOtraCarta + valorUnaCarta + 20;
        return this;
    }

    public int getValorEnvido(){
        return this.valorEnvido;
    }
}

