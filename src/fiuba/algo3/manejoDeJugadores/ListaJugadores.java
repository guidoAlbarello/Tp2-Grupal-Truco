package fiuba.algo3.manejoDeJugadores;

/**
 * Created by Fechee on 18/11/2015.
 */
public class ListaJugadores {

    protected NodoJugador primero;
    protected NodoJugador ultimo;
    public int tamanio;


    public ListaJugadores() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }


    public boolean isEmpty() {
        return primero == null;
    }

    public NodoJugador getPrimero() {
        return this.primero;
    }

    public NodoJugador getUltimo() { return this.ultimo; }

    public int getTamanio() {
        return this.tamanio;
    }

    public Jugador getJugadorEnPosicion(Integer pos) {
        NodoJugador actual = this.primero;
        for (int i = 0; i < pos; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getJugador();
    }


    public void agregarUltimo(Jugador jugador) {

        NodoJugador nuevo = new NodoJugador(jugador);
        if (primero == null) {
            nuevo.setAnterior(nuevo);
            nuevo.setSiguiente(nuevo);
            primero = nuevo;
            ultimo = primero;
        } else {
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            nuevo.setSiguiente(primero);
            ultimo = nuevo;
        }
        tamanio++;
    }


    public void reiniciarManosGanadasDeTodosLosJugadores() {
        NodoJugador nodoActual = this.primero;
        Jugador jugadorActual = nodoActual.getJugador();
        for (int i = 0; i < this.tamanio; i++) {
            jugadorActual.reiniciarManosGanadas();
            nodoActual = nodoActual.getSiguiente();
            jugadorActual = nodoActual.getJugador();
        }
    }

    /*
    public void sacarCartas() {
        NodoJugador nodoActual = this.primero;
        Jugador jugadorActual = nodoActual.getJugador();
        for (int i = 0 ; i< this.tamanio ; i++){
            jugadorActual.getMano().getCartasEnMano().clear();
            jugadorActual.getMano().resetearIndicesDeCartasEnMesa();
            nodoActual= nodoActual.getSiguiente();
            jugadorActual=nodoActual.getJugador();
        }
    }*/

}
