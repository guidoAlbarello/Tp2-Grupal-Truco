package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Jugador {

    private String nombre;
    private Mano mano;
    private int puntaje;
    private Cantos cantos;
    //private Cantos cantos;


    public Jugador(String nombre,Cantos cantosDeJuego) {
        this.nombre = nombre;
        this.cantos = cantosDeJuego;
        this.mano = new Mano();
    }



    public void recibirCarta(Carta unaCarta){
        this.mano.agregarCarta(unaCarta);
    }

    public void sumarPuntos(int unPuntaje){
        this.puntaje+=unPuntaje;
    }


    public String getNombre() {
        return this.nombre;
    }

    public Mano getMano(){
        return this.mano;
    }

    public int puntaje() {//agregue este metodo "Anthony"
        return puntaje;
    }

    public Jugada hacerJugada(JugadorEnJuego jugadorEnJuego) {
        //en lagun lado hay q darle la opcion par aelejir
        return cantos.cantarEnvido(jugadorEnJuego);
    }

    /*public void jugarCarta(Carta unaCarta){
        this.manosGanadas.jugarCarta(unaCarta);
    }

    public void borrarMano(){
        this.manosGanadas.borrar();
    }
*/

}
