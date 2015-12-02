package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Created by Fechee on 02/12/2015.
 */
public class HandlerBotonSalir implements EventHandler {

    BetaTestVentanas aplicacion;

    public HandlerBotonSalir(BetaTestVentanas aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(Event event) {
        aplicacion.elStage.close();
    }

}
