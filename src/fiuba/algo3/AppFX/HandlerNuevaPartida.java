package fiuba.algo3.AppFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

/**
 * Created by Fechee on 28/11/2015.
 */
public class HandlerNuevaPartida implements EventHandler<ActionEvent> {

    JuegoTruco juego;

    public HandlerNuevaPartida(JuegoTruco juego){
        this.juego=juego;
    }

    @Override
    public void handle(ActionEvent event) {
        this.juego.resetearConfiguracion();
        this.juego.limpiarContenedorPrincipal();
        this.juego.generarPanelInicialDeJugadores();
        this.juego.mostrarPanelInicialDeJugaodres();
    }
}
