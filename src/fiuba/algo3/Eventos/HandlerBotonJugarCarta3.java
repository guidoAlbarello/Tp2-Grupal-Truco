package fiuba.algo3.Eventos;

import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugarCarta3 implements EventHandler {
    private Aplicacion aplicacion;

    public HandlerBotonJugarCarta3(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().jugarCartaEnPosicion(2);
        aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
    }
}
