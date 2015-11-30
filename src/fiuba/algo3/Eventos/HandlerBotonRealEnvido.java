package fiuba.algo3.Eventos;

import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonRealEnvido implements EventHandler {
    private Aplicacion aplicacion;
    public HandlerBotonRealEnvido(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(Event event) {
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
    }
}
