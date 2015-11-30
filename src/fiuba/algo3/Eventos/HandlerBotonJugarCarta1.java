package fiuba.algo3.Eventos;

import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

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

        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().jugarCartaEnPosicion(0);
        aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());


    }
}
