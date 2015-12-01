package fiuba.algo3.Controles.z;

import fiuba.algo3.Modelo.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

import javax.swing.*;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonMazo implements EventHandler {
    private Aplicacion aplicacion;
    public HandlerBotonMazo(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        try {
            this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().meVoyAlMaso();
            this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
            aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "No podes irte a mazo hay canto en curso",
                    "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
        }
    }
}
