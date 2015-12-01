package fiuba.algo3.Controles;


import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;


/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugadasEnvidoBeta implements EventHandler <ActionEvent> {
    private BetaTestVentanas aplicacion;

    public HandlerBotonJugadasEnvidoBeta(BetaTestVentanas aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadasEnvido());
    }

}