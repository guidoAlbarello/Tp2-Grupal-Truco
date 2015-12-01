package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonMazoBeta implements EventHandler {
    private BetaTestVentanas aplicacion;
    public HandlerBotonMazoBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().meVoyAlMaso();
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        aplicacion.actualizarCartasEnManoParaJugadorActual();
        //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    }
}
