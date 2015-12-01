package fiuba.algo3.Controles.z;


import fiuba.algo3.Modelo.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugadasTruco implements EventHandler {
    private Aplicacion aplicacion;

    public HandlerBotonJugadasTruco(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadasTruco());
    }
}
