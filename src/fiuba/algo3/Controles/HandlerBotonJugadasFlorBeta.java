package fiuba.algo3.Controles;


import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;

import javax.swing.*;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugadasFlorBeta implements EventHandler {
    private BetaTestVentanas aplicacion;
    public HandlerBotonJugadasFlorBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().flor();
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "No se puede jugar Flor",
                    "JUGADA INVALIDA: JUEGO SIN FLOR", JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual()
                        .getNombre() +" canto flor y nadie mas tenia",
                "JUGADOR SUMA 3 PUNTOS POR FLOR", JOptionPane.WARNING_MESSAGE);

        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    }
}
