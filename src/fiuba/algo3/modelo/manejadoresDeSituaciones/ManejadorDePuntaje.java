package fiuba.algo3.modelo.manejadoresDeSituaciones;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anthony on 11/11/2015.
 */
public class ManejadorDePuntaje {
    private Map<String, Integer> puntajesDelJuego;

    public ManejadorDePuntaje(String nombreJugador1, String nombreJugador2){
        this.puntajesDelJuego = new HashMap<>();
        this.puntajesDelJuego.put(nombreJugador1, 0);
        this.puntajesDelJuego.put(nombreJugador2, 0);
    }

    public int getPuntaje(String nombreUnJugador) {
        return this.puntajesDelJuego.get(nombreUnJugador);
    }

    public void sumaPuntaje(String unNombre, int puntajeGanado) {
        this.puntajesDelJuego.put(unNombre, this.puntajesDelJuego.get(unNombre) + puntajeGanado);
    }
}
