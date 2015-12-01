package fiuba.algo3.Controles.z;

import fiuba.algo3.Modelo.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerNuevoJuego implements EventHandler {
    private Aplicacion aplicacion;

    public HandlerNuevoJuego(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        this.aplicacion.getBorderPane().setCenter(this.aplicacion.generarPanelDeConfiguracion());
    }
}
