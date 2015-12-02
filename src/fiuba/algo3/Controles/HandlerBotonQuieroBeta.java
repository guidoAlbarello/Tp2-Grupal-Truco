package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.*;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonQuieroBeta implements EventHandler<ActionEvent> {
    private BetaTestVentanas aplicacion;
    public HandlerBotonQuieroBeta(BetaTestVentanas aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().quiero();
        }catch (RuntimeException e){
            JOptionPane mensajeError = new JOptionPane();
            mensajeError.showMessageDialog(null, "no hay cantos en juego",
                    "JUGADA INVALIDA", JOptionPane.ERROR_MESSAGE);
        }
        if (this.aplicacion.getJuego().hayGanador()) {
            aplicacion.getBorderPane().setLeft(null);
            aplicacion.getBorderPane().setRight(null);
            aplicacion.mostrarGanador(aplicacion.getJuego().ganador);
        }else {
            aplicacion.actualizarCartasEnManoParaJugadorActual();
            aplicacion.actualizarBotonesCartas();
            //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
            aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        }
    }
}
