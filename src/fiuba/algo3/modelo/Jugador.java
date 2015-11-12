package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Jugador {

    private String nombreJugador;
    private Mano manoDelJugador;
    private Cantos cantosPosibles;
    private int puntaje;
    //private Cantos cantos;


    public Jugador(String nombre,Cantos cantosDeJuego) {
        this.nombreJugador = nombre;
        this.cantosPosibles = cantosDeJuego;
        this.manoDelJugador = new Mano();
        this.puntaje = 0;
    }



    public void recibirCarta(Carta unaCarta){
        this.manoDelJugador.agregarCarta(unaCarta);
    }

    public String getNombre() {
        return this.nombreJugador;
    }

    public Mano getMano(){
        return this.manoDelJugador;
    }
    public Cantos getCantosPosibles(){return this.cantosPosibles;}

    public Jugada hacerJugada(){
        //en lagun lado hay q darle la opcion par aelejir
        //return cantosPosibles.cantarEnvido() ;
        return null;
    }

    public CartaJugada responderCarta(CartaJugada unaCrtaJugada) {
        return null;
    }

    public void incrementarManosGanadas() {

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


    //agregue yo fede

    public void jugarCarta(Integer indiceDeCarta) {
        this.manoDelJugador.jugarCarta(indiceDeCarta);
    }

    public Carta getCartaJugada(){
        return this.manoDelJugador.getCartaJugada();
    }



    /*public void jugarCarta(Carta unaCarta){
        this.manosGanadas.jugarCarta(unaCarta);
    }

    public void borrarMano(){
        this.manosGanadas.borrar();
    }
*/

}
