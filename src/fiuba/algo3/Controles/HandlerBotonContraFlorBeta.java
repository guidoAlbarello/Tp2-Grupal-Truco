package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonContraFlorBeta implements EventHandler {
    private BetaTestVentanas aplicacion;
    public HandlerBotonContraFlorBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();
        //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    }
}
