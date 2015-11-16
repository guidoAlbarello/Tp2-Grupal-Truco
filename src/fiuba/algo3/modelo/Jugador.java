package fiuba.algo3.modelo;

import fiuba.algo3.modelo.jugadasPosibles.*;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones.AceptaEnvido;
import fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones.AceptaRealEnvido;
import fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones.NoAceptaEnvido;

import java.util.List;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Jugador {

    private String nombreJugador;
    private Mano manoDelJugador;
    private JugadaPosible jugadaPosible;
    private int puntaje;
    //private Cantos cantos;


    public Jugador(String nombre, SeJuegaConFlor seJuegaConFlor) {
        this.nombreJugador = nombre;
        jugadaPosible = new JugadaDePeticion(seJuegaConFlor);
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

   /* public Cantos getCantosPosibles() {
        return this.cantosPosibles;
    }*/

    public Jugada hacerJugada() {
        List<String> jugadasDisponibles = this.jugadaPosible.getJugadasPosibles();
        Jugada jugadaRealizada = this.elegirJugada(jugadasDisponibles);
        return jugadaRealizada;
    }

    private Jugada elegirJugada(List<String> unaNuevaJugada) {
        return null;
    }

    public Jugada seleccionarJugada(String nuevaJugada){
        Jugada jugadaNueva = this.jugadaPosible.hacerJugada(nuevaJugada, this);
        this.jugadaPosible = new JugadaDeRespuestaAPeticion(this.jugadaPosible.getSeJuegaConFlor());
        return jugadaNueva;
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


