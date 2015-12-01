package fiuba.algo3.Controles;


import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugadasFlorBeta implements EventHandler {
    private BetaTestVentanas aplicacion;
    public HandlerBotonJugadasFlorBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadasFlor());
    }
}
