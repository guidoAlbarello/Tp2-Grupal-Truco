package fiuba.algo3.Controles;


import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugadasTrucoBeta implements EventHandler {
    private BetaTestVentanas aplicacion;

    public HandlerBotonJugadasTrucoBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadasTruco());
    }
}
