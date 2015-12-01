package fiuba.algo3.Modelo.manejoDeJugadores;

/**
 * Created by Fechee on 18/11/2015.
 */
public class NodoJugador {
    private NodoJugador siguiente;
    private NodoJugador anterior;
    private Jugador jugador;
    private Integer posicion;

    public NodoJugador(Jugador jugadorEnRonda) {
        siguiente = null;
        anterior = null;
        jugador = jugadorEnRonda;
    }

    public void setSiguiente(NodoJugador unNodo){
        this.siguiente=unNodo;
    }

    public NodoJugador getSiguiente(){
        return this.siguiente;
    }

    public NodoJugador getAnterior(){
        return this.anterior;
    }


    public void setAnterior(NodoJugador unNodo){
        this.anterior=unNodo;
    }


    public Jugador getJugador(){
        return this.jugador;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Integer getPosicion(){
        return this.posicion;
    }
}
