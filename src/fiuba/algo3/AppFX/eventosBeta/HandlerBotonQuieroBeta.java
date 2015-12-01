package fiuba.algo3.AppFX.eventosBeta;

import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.*;

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
            mensajeError.showMessageDialog(null,"no hay cantos en juego",
                    "JUGADA INVALIDA",JOptionPane.ERROR_MESSAGE);
        }
        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();
        //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
    }
}
