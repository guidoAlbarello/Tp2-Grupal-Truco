package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.*;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonNoQuieroBeta implements EventHandler<ActionEvent> {
    private BetaTestVentanas aplicacion;
    public HandlerBotonNoQuieroBeta(BetaTestVentanas aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().noQuiero();
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "no se canto ninguna jugada",
                    "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
        }
        if (this.aplicacion.getJuego().hayGanador()) {
            aplicacion.getBorderPane().setLeft(null);
            aplicacion.getBorderPane().setRight(null);
            aplicacion.mostrarGanador(aplicacion.getJuego().ganador);
        }else {
            aplicacion.actualizarCartasEnManoParaJugadorActual();
            aplicacion.actualizarBotonesCartas();
            //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
            aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
        }
    }
}
