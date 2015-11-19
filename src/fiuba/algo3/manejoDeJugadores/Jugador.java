package fiuba.algo3.manejoDeJugadores;

/**
 * Created by Fechee on 18/11/2015.
 */
public class Jugador {

    private String nombreJugador;
    //private Mano manoDelJugador;
    private int manosGanadas;


    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        //this.manoDelJugador = new Mano();
        this.manosGanadas = 0; // esto quizas convenga estar en manejador de puntajes ???
    }


    public String getNombre() {
        return this.nombreJugador;
    }

    public int getManosGanadas() {
        return this.manosGanadas;
    }

    public void reiniciarManosGanadas() {this.manosGanadas=0;}

    public void ganarMano() { this.manosGanadas+=1; }

    //public void recibirCarta(Carta unaCarta) {  this.manoDelJugador.agregarCarta(unaCarta);   }

    //public int calcularEnvido() {}

    //public void cantarAlgo()



}
