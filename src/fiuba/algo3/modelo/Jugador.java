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


    public Jugador(String nombre) {
        this.nombre = nombre;
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

    /*public void jugarCarta(Carta unaCarta){
        this.manosGanadas.jugarCarta(unaCarta);
    }

    public void borrarMano(){
        this.manosGanadas.borrar();
    }
*/

}
