package fiuba.algo3.Eventos;

import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonEnvido implements EventHandler {
    private Aplicacion aplicacion;

    public HandlerBotonEnvido(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().envido();
            aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
            aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
        }catch (RuntimeException e){
            Stage dialogo = new Stage();
            dialogo.initModality(Modality.WINDOW_MODAL);
            //dialogo.setScene(new Scene(VBoxBuilder.create().children()));
        }
    }
}
