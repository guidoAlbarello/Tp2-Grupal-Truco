package fiuba.algo3.AppFX.eventosBeta;

import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonFaltaEnvidoBeta implements EventHandler {
    private BetaTestVentanas aplicacion;
    public HandlerBotonFaltaEnvidoBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(Event event) {
        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().faltaEnvido();
        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
    }
}
