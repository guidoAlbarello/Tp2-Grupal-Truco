package fiuba.algo3.AppFX.eventosBeta;

import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

import javax.swing.*;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonFaltaEnvidoBeta implements EventHandler {
    private BetaTestVentanas aplicacion;
    public HandlerBotonFaltaEnvidoBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(Event event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().faltaEnvido();
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, "No se puede jugar FaltaEnvido",
                    "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
        }
            aplicacion.actualizarCartasEnManoParaJugadorActual();
            aplicacion.actualizarBotonesCartas();
            aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
            //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    }

}
