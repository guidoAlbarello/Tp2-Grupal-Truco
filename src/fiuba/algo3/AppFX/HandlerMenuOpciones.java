package fiuba.algo3.AppFX;

import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Created by Krion on 30/11/2015.
 */
public class HandlerMenuOpciones implements EventHandler<ActionEvent> {

    public HandlerMenuOpciones(Aplicacion unaAplicacion) {

    }

    @Override
    public void handle(ActionEvent event) {
        Stage stage = new Stage();

        stage.show();
    }
}
