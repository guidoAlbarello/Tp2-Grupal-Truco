package fiuba.algo3.Controles.z;

import fiuba.algo3.Modelo.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.*;

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
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().noQuiero();
            aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
            aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "No hay ningun canto en juego",
                    "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
        }
    }
}
