package fiuba.algo3.manejoDeJugadores;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fechee on 19/11/2015.
 */
public class Equipo {
    private String nombre;
    private int puntaje;
    private List<Jugador> jugadores;

    public Equipo(String nombre){
        this.puntaje=0;
        this.nombre=nombre;
        this.jugadores = new ArrayList<Jugador>();
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

}
