package fiuba.algo3.Eventos;


import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugadasFlor implements EventHandler {
    private Aplicacion aplicacion;
    public HandlerBotonJugadasFlor(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {

        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadasFlor());
    }
}
