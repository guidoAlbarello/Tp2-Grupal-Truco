package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class JugadorJugando {

    private Jugador jugador;
    private String nombre;
    private int puntaje;
    private int manosGanadas;
    public JugadorJugando(String nombre){
        nombre = "";
        puntaje = 0;
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
        this.puntaje += puntaje;
    }

    public Jugada responderRealEnvido() {
        AceptaRealEnvido aceptaRealEnvido = new AceptaRealEnvido(this);
        return aceptaRealEnvido;
    }

    public Jugada jugar() {
        return new EnvidoCantado(this);
    }

    public CartaJugada responderCarta(CartaJugada cartaJugada) {
        return new CartaJugada(this,cartaJugada.valor + 1);
    }

    public String nombre() {
        return this.nombre;
    }

    public CartaJugada jugarCarta(int valor){
        return new CartaJugada(this,valor);
    }
}
