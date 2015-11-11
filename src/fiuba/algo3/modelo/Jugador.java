package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Jugador {

    private String nombreJugador;
    private Mano manoDelJugador;
    private Cantos cantosPosibles;
    //private Cantos cantos;


    public Jugador(String nombre,Cantos cantosDeJuego) {
        this.nombreJugador = nombre;
        this.cantosPosibles = cantosDeJuego;
        this.manoDelJugador = new Mano();
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

    public Jugada hacerJugada(){
        //en lagun lado hay q darle la opcion par aelejir
        //return cantosPosibles.cantarEnvido() ;
    }

    public CartaJugada responderCarta(CartaJugada unaCrtaJugada) {
        return null;
    }

    public void incrementarManosGanadas() {

    }

    /*public void jugarCarta(Carta unaCarta){
        this.manosGanadas.jugarCarta(unaCarta);
    }

    public void borrarMano(){
        this.manosGanadas.borrar();
    }
*/

}
