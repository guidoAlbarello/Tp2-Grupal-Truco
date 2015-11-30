package fiuba.algo3.Eventos;

import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonEnvido implements EventHandler {
    private Aplicacion aplicacion;

    public HandlerBotonEnvido(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().envido();
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    }
}
