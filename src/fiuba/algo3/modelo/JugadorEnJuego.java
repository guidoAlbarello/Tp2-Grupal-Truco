package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class JugadorEnJuego {

    private Jugador jugador;
    private int manosGanadas;

    public JugadorEnJuego(Jugador jugador){
        manosGanadas = 0;
        this.jugador = jugador;
    }

    public int manosGanadas(){
        return this.manosGanadas;
    }
    public void setManosGanadas(int numero){
        this.manosGanadas = numero;
    }
    public void incrementarManosGanadas(){
        this.manosGanadas += 1;
    }


    /*public void jugarEnvio(Mesa mesa){
        EnvidoCantado envido = new EnvidoCantado(this);
        mesa.resolverJugada(envido);

    }*/
    public int puntaje(){return jugador.puntaje();}

    public Jugada responderEnvio() {
        return new AceptaEnvido(this);
    }

    public int calcularEnvido() {
        return 5;
    }

    public void sumaPuntaje(int puntaje) {
        this.jugador.sumarPuntos(puntaje);
    }

    public Jugada responderRealEnvido() {
        AceptaRealEnvido aceptaRealEnvido = new AceptaRealEnvido(this);
        return aceptaRealEnvido;
    }

    public Jugada jugar() {
        return jugador.hacerJugada(this);
    }

    public CartaJugada responderCarta(CartaJugada cartaJugada) {
        return new CartaJugada(this,cartaJugada.valor + 1);
    }

    public String nombre() {return this.jugador.getNombre();}

    public CartaJugada cantarCarta(int valor){
        return new CartaJugada(this,valor);
    }
}
