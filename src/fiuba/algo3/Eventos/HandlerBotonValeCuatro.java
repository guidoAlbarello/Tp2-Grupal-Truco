package fiuba.algo3.Eventos;

import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonValeCuatro implements EventHandler<ActionEvent> {
    private  Aplicacion aplicacion;
    public HandlerBotonValeCuatro(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
    }
}
