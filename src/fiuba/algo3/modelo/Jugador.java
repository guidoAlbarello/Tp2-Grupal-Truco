package fiuba.algo3.modelo;

import fiuba.algo3.modelo.jugadasPosibles.*;




import java.util.List;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Jugador {

    private String nombreJugador;
    private Mano manoDelJugador;
    private int puntaje;
    //private Cantos cantos;


    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        this.manoDelJugador = new Mano();
        this.puntaje = 0;
    }

    public void recibirCarta(Carta unaCarta) {
        this.manoDelJugador.agregarCarta(unaCarta);
    }

    public String getNombre() {
        return this.nombreJugador;
    }

    public Mano getMano() {
        return this.manoDelJugador;
    }

    public int calcularEnvido() {
        return manoDelJugador.obtenerEnvido().getValorEnvido();
    }

    public void sumaPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int calcularFlor() {
        return this.manoDelJugador.calcularFlor();
    }
}


