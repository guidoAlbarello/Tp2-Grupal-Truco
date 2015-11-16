package fiuba.algo3.modelo.manejadoresDeSituaciones;

import fiuba.algo3.modelo.JugadorEnRonda;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by anthony on 10/11/2015.
 */
public class ManejadorDeTurnos {

    private JugadorEnRonda jugador1;
    private JugadorEnRonda jugador2;
    private JugadorEnRonda jugadorQueTieneElTurno;
    private JugadorEnRonda jugadorMano;
    private JugadorEnRonda jugadorTurnoEnMano;
    private LinkedList<JugadorEnRonda> listaDeJugadores ;
    private int posicionDeTurnoDeJugadrEnLista;

    public ManejadorDeTurnos(JugadorEnRonda jugador1, JugadorEnRonda jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorMano = jugador1;
        this.jugadorTurnoEnMano = this.jugadorMano;

    }
//nuevo contructor
    public ManejadorDeTurnos(LinkedList<JugadorEnRonda> listaDeJugadores) {
        this.listaDeJugadores = ordenarListaDeJugadoresPorEquipos(listaDeJugadores);
        this.posicionDeTurnoDeJugadrEnLista = 0; //lo inicalizo asi por las dudas;
    }

    private LinkedList<JugadorEnRonda> ordenarListaDeJugadoresPorEquipos(LinkedList<JugadorEnRonda> listaDeJugadores){
        LinkedList<JugadorEnRonda> nuevaListaOrdenadaPorEquipos = new LinkedList<>();
        int posicionEquipo1 = 0;
        int posicionEquipo2 = 1;
        while (!listaDeJugadores.isEmpty()){
            JugadorEnRonda jugador =listaDeJugadores.get(0);//agarro el primero d ela lista
            if ( jugador.getEquipo() == 1) {
                nuevaListaOrdenadaPorEquipos.add(posicionEquipo1, jugador);
                posicionEquipo1 += 2;
            }else{
                nuevaListaOrdenadaPorEquipos.add(posicionEquipo2, jugador);
                posicionEquipo2 += 2;
            }

        }
        return nuevaListaOrdenadaPorEquipos;
    }
    public JugadorEnRonda getJugadorQueTieneElTurno(){
        return this.jugadorQueTieneElTurno;
    }
    public void avanzarUnTurno(){
        if ( posicionDeTurnoDeJugadrEnLista < listaDeJugadores.size())
            this.posicionDeTurnoDeJugadrEnLista ++;
        else
            this.posicionDeTurnoDeJugadrEnLista = 0;// voy a la primera posicion

        this.jugadorQueTieneElTurno = listaDeJugadores.get(posicionDeTurnoDeJugadrEnLista);
    }
    public void retrocederUnTurno(){
        if ( posicionDeTurnoDeJugadrEnLista > 0)
            this.posicionDeTurnoDeJugadrEnLista --;
        else
            this.posicionDeTurnoDeJugadrEnLista = listaDeJugadores.size() - 1;// paso a la ultima posicion

        this.jugadorQueTieneElTurno = listaDeJugadores.get(posicionDeTurnoDeJugadrEnLista);
    }

// hasta aca agregue




    // aca me falta a logica para manejar los turnos
    public JugadorEnRonda getJugadorTurnoEnMano() {
        return this.jugadorTurnoEnMano;
    }
    public void pasarTurnoEnMano(){
        if (jugadorTurnoEnMano.getJugador().getNombre().equals(this.jugador1.getJugador().getNombre()))
            jugadorTurnoEnMano = jugador2;
        else
            jugadorTurnoEnMano = jugador1;
    }
    public void pasarJugadorMano(){
        if (jugadorMano.getJugador().getNombre().equals(this.jugador1.getJugador().getNombre()))
            jugadorMano = jugador2;
        else
            jugadorMano = jugador1;
    }
    public JugadorEnRonda getJugadorMano() {
        return this.jugadorMano;
    }


    public void setJugadorMano(JugadorEnRonda jugadorMano) {
        int posicionEnLista = 0;
        boolean jugadorEncontrado = false;
        String nombreJugador = jugadorMano.getJugador().getNombre();
        JugadorEnRonda jugadorBuscado = null;
        Iterator<JugadorEnRonda> iterador = listaDeJugadores.iterator();
        while ( iterador.hasNext() && !jugadorEncontrado){
            jugadorBuscado = iterador.next();
            if (jugadorBuscado.getJugador().getNombre().equals(nombreJugador))
                jugadorEncontrado = true;
            posicionEnLista ++;
        }
        this.jugadorMano = jugadorBuscado;
        this.posicionDeTurnoDeJugadrEnLista = posicionEnLista;
    }

}
