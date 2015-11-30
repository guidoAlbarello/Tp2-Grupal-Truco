package fiuba.algo3.Eventos;

import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonNoQuiero implements EventHandler<ActionEvent> {
    private Aplicacion aplicacion;
    public HandlerBotonNoQuiero(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().noQuiero();
        aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
    }
}
