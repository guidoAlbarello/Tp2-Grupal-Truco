package fiuba.algo3.AppFX.eventosBeta;

import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.*;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonRetrucoBeta implements EventHandler<ActionEvent> {
    private BetaTestVentanas aplicacion;
    public HandlerBotonRetrucoBeta(BetaTestVentanas aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().retruco();
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "No se puede jugar Retruco",
                    "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
        }
        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
       // aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    }
}
