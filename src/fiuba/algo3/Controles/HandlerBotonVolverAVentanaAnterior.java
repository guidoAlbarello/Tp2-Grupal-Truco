package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

/**
 * Created by Fechee on 02/12/2015.
 */
public class HandlerBotonVolverAVentanaAnterior implements EventHandler<ActionEvent> {
    Node izq,medio,der;
    BetaTestVentanas aplicacion;

    public HandlerBotonVolverAVentanaAnterior(BetaTestVentanas aplicacion, Node izq, Node medio, Node der){
        this.aplicacion=aplicacion;
        this.izq=izq;
        this.medio=medio;
        this.der=der;
    }

    @Override
    public void handle(ActionEvent event) {
        aplicacion.getBorderPane().setLeft(izq);
        aplicacion.getBorderPane().setCenter(medio);
        aplicacion.getBorderPane().setRight(der);
    }
}
