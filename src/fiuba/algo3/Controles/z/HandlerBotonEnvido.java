package fiuba.algo3.Controles.z;

import fiuba.algo3.Modelo.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

import javax.swing.*;

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
            JOptionPane.showMessageDialog(null, "No se puede jugar Envido",
                    "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
        }
    }
}
