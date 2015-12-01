package fiuba.algo3.AppFX.eventosBeta;

import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonTrucoBeta implements EventHandler<ActionEvent> {
    private BetaTestVentanas aplicacion;
    public HandlerBotonTrucoBeta(BetaTestVentanas aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().truco();
        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    }
}
