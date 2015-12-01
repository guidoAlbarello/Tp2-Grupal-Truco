package fiuba.algo3.AppFX;

import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Fechee on 28/11/2015.
 */
public class HandlerNuevaPartida implements EventHandler<ActionEvent> {

    BetaTestVentanas aplicacion;

    public HandlerNuevaPartida(BetaTestVentanas juego){
        this.aplicacion=juego;
    }

    @Override
    public void handle(ActionEvent event) {
        this.aplicacion.panel.setRight(null);
        this.aplicacion.panel.setLeft(null);
        this.aplicacion.panel.setCenter(this.aplicacion.generarPanelDeConfiguracion());



        /*
        this.juego.resetearConfiguracion();
        this.juego.limpiarContenedorPrincipal();
        this.juego.generarPanelDeConfiguracion();
        this.juego.mostrarPanelInicialDeJugaodres();*/
    }



}
