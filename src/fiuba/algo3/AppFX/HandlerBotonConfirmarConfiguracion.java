package fiuba.algo3.AppFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

import java.util.List;

/**
 * Created by Fechee on 28/11/2015.
 */
public class HandlerBotonConfirmarConfiguracion implements EventHandler<ActionEvent> {
    JuegoTruco juego;
    ChoiceBox selector;

    public HandlerBotonConfirmarConfiguracion(JuegoTruco juego, ChoiceBox selector ){
        this.juego = juego;
        this.selector = selector;
    }

    @Override
    public void handle(ActionEvent event) {
        this.juego.resetearConfigJugadores();
        List<HBox> contenedores = this.juego.generarContenedoresSegunCantidadDeJugadores(selector.getSelectionModel().getSelectedIndex());
        this.juego.configJugadores.getChildren().addAll(contenedores);
        this.juego.limpiarContenedorPrincipal();
        Button confirmarJugadores = new Button("Confirmar");
        confirmarJugadores.setOnAction(new HandlerBotonConfirmarJugadores(contenedores,juego));
        this.juego.mostrarConfigNombresDeJugadores(confirmarJugadores);
    }
}
