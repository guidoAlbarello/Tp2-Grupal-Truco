package fiuba.algo3.Eventos;

import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

import javax.swing.*;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugarCarta2 implements EventHandler {
    private Aplicacion aplicacion;

    public HandlerBotonJugarCarta2(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
try {
    aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().jugarCartaEnPosicion(1);
    aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
    aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
}catch (RuntimeException e){
    JOptionPane.showMessageDialog(null, "No se puede jugar carta falta aceptar canto",
            "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
}
    }
}
