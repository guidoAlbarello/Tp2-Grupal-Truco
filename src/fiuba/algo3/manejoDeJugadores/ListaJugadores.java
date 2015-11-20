package fiuba.algo3.manejoDeJugadores;

import fiuba.algo3.Mazo;

/**
 * Created by Fechee on 18/11/2015.
 */
public class ListaJugadores {

    protected NodoJugador primero;
    protected NodoJugador ultimo;
    public int tamanio;
    private Equipo equipo1,equipo2;


    public ListaJugadores() {
        primero = null;
        ultimo = null;
        tamanio = 0;
        equipo1= new Equipo("Equipo 1");
        equipo2= new Equipo("Equipo 2");
    }

    public ListaJugadores(String nombre1, String nombre2) {
        primero = null;
        ultimo = null;
        tamanio = 0;
        equipo1= new Equipo(nombre1);
        equipo2= new Equipo(nombre2);
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
        configurarEquipoParaUnJugador(jugador);
    }



    private void configurarEquipoParaUnJugador(Jugador jugador) {
        if (tamanio%2 == 0){
            jugador.setEquipo(equipo2);
            equipo2.agregarJugador(jugador);
        }
        else{
            jugador.setEquipo(equipo1);
            equipo2.agregarJugador(jugador);
            }
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
