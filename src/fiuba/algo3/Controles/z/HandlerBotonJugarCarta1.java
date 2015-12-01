package fiuba.algo3.Controles.z;

import fiuba.algo3.Modelo.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

import javax.swing.*;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugarCarta1 implements EventHandler {
    private Aplicacion aplicacion;

    public HandlerBotonJugarCarta1(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().jugarCartaEnPosicion(0);
            aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
            aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "No se puede jugar carta falta aceptar canto",
                    "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
        }

    }
}
