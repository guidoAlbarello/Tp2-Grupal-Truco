package fiuba.algo3.modelo;

import fiuba.algo3.modelo.jugadasPosibles.AceptaEnvido;
import fiuba.algo3.modelo.jugadasPosibles.AceptaRealEnvido;
import fiuba.algo3.modelo.jugadasPosibles.Jugada;
import fiuba.algo3.modelo.jugadasPosibles.NoAceptaEnvido;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Jugador {

    private String nombreJugador;
    private Mano manoDelJugador;
    private JugadorEnRonda.Cantos cantosPosibles;
    private int puntaje;
    //private Cantos cantos;


    public Jugador(String nombre, JugadorEnRonda.Cantos cantosDeJuego) {
        this.nombreJugador = nombre;
        this.cantosPosibles = cantosDeJuego;
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

    public JugadorEnRonda.Cantos getCantosPosibles() {
        return this.cantosPosibles;
    }

    public Jugada hacerJugada() {
        //en lagun lado hay q darle la opcion par aelejir
        //return cantosPosibles.cantarEnvido() ;
        return null;
    }

    public int puntaje() {
        return this.puntaje;
    }

    public Jugada responderEnvio() {
        return new AceptaEnvido(this);
    }

    public Jugada responderRealEnvio() {
        return new AceptaRealEnvido(this);
    }

    public Jugada noAceptarEnvio() {
        return new NoAceptaEnvido(this);
    }

    public Jugada responderRealEnvido() {
        return new AceptaRealEnvido(this);
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


}
    /*public void jugarCarta(Carta unaCarta){
        this.manosGanadas.jugarCarta(unaCarta);
    }

    public void borrarMano(){
        this.manosGanadas.borrar();
    }
*/


