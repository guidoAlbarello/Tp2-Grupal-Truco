package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class JugadorJugando {
    private String nombre;
    private int puntaje;
    private int manosGanadas;
    public JugadorJugando(){
        nombre = "";
        puntaje = 0;
        manosGanadas = 0;
    }
    public JugadorJugando(String nombre){
        this.nombre = nombre;
        puntaje = 0;
        manosGanadas = 0;
    }


    public int mano(){
        return this.manosGanadas;
    }
    public void setMano(int numero){
        this.manosGanadas = numero;
    }

    public void incrementarMano(){
        this.manosGanadas += 1;
    }


    /*public void jugarEnvio(Mesa mesa){
        EnvidoCantado envido = new EnvidoCantado(this);
        mesa.resolverJugada(envido);

    }*/
    public int puntaje(){return puntaje;}

    public Respuesta responderEnvio() {
        return new AceptaEnvido(this);
    }

    public int calcularEnvido() {
        return 5;
    }

    public void sumaPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public Respuesta responderRealEnvido() {
        AceptaRealEnvido aceptaRealEnvido = new AceptaRealEnvido(this);
        return aceptaRealEnvido;
    }

    public Respuesta jugar() {
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
