package fiuba.algo3.Modelo.manejoDeJugadores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Fechee on 19/11/2015.
 */
public class Equipo {
    private String nombre;
    private int puntaje;
    private List<Jugador> jugadores;
    private int manosGanadas;

    public Equipo(String nombre){
        this.puntaje=0;
        this.nombre=nombre;
        this.jugadores = new ArrayList<Jugador>();
        this.manosGanadas = 0;
    }

    public void agregarJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }

    public void sumarPuntos(Integer puntos){
        this.puntaje+=puntos;
    }

    public String getNombre(){ return this.nombre;  }

    public int getPuntaje(){ return this.puntaje;  }

    public void setNombre(String nombre) {  this.nombre = nombre;  }

    public List<Jugador> getJugadores(){  return this.jugadores;  }

    public void ganarMano() { this.manosGanadas+=1; }

    public void reiniciarManosGanadas() { this.manosGanadas = 0; }

    public Integer getManosGanadas(){ return this.manosGanadas; }

    public Jugador jugadorConEnvidoMayorEnEquipo(){
        Iterator<Jugador> iterador = jugadores.iterator();
        Jugador jugadorMaximoEnvido = iterador.next();
        while ( iterador.hasNext()) {
            Jugador jugador = iterador.next();
            if ( jugadorMaximoEnvido.getMano().obtenerEnvido().getValorEnvido() < jugador.getMano().obtenerEnvido().getValorEnvido())
                jugadorMaximoEnvido = jugador;
        }
        return jugadorMaximoEnvido;
    }

}
