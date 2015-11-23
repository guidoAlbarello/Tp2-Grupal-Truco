package fiuba.algo3.manejoDeJugadores;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.Juego;
import fiuba.algo3.Mano;
import fiuba.algo3.ModeladoDeCarta.Carta;

/**
 * Created by Fechee on 18/11/2015.
 */
public class Jugador {

    private String nombreJugador;
    private Mano manoDelJugador;
    private Equipo equipo;
    private Juego juego;


    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        this.manoDelJugador = new Mano();
        //this.manosGanadas = 0; // esto quizas convenga estar en manejador de puntajes ???
    }

    public void setJuego(Juego nuevoJuego){ this.juego = nuevoJuego;}

    public Mano getMano(){  return this.manoDelJugador;  }

    public String getNombre() {
        return this.nombreJugador;
    }

   // public int getManosGanadas() {        return this.manosGanadas;    }

   // public void reiniciarManosGanadas() {this.manosGanadas=0;}



    public void recibirCarta(Carta unaCarta) {  this.manoDelJugador.agregarCarta(unaCarta);   }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo() {  return this.equipo;  }

    public void envido() {
        this.juego.seCantaEnvido();
    }

    public void noQuiero() {
        this.juego.noQuiero();
    }

    public void jugarCarta(CartaJugada cartaDeJugador) {
        this.juego.jugarCarta(cartaDeJugador);
    }

    public void jugarCartaEnPosicion(int indiceDeLaCarta){
        this.juego.jugarCarta(new CartaJugada(this.manoDelJugador.jugarCarta(indiceDeLaCarta),this));
    }

    public void truco() {
        this.juego.seCantaTruco();
    }

    public void quiero() {
        this.juego.quiero();
    }

    public void realEnvido() {
        this.juego.seCantaRealEnvido();
    }

    public void retruco() {
        this.juego.seCantaRetruco();
    }

    public void valeCuatro() {
        this.juego.seCantaValeCuatro();
    }


    //public int calcularEnvido() {}

    //public void cantarAlgo()



}
