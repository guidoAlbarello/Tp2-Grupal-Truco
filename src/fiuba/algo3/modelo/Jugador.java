package fiuba.algo3.modelo;

/**
 * Created by Fechee on 10/11/2015.
 */
public class Jugador {

    private String nombre;
    private Mano mano;
    private int puntaje;
    private Cantos cantos;


    public Jugador(String nombre) {
        this.nombre = nombre;
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



    public void jugarCarta(Carta unaCarta){
        this.mano.jugarCarta(unaCarta);
    }

    public void borrarMano(){
        this.mano.borrar();
    }


}
