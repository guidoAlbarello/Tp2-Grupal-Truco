package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

/**
 * Created by Fechee on 28/11/2015.
 */


public class HandlerBotonConfirmarConfiguracion implements EventHandler<ActionEvent> {
    BetaTestVentanas aplicacion;
    ChoiceBox selector;
    CheckBox conFlor;

    public HandlerBotonConfirmarConfiguracion(BetaTestVentanas juego, ChoiceBox selector, CheckBox conFlor ){
        this.aplicacion = juego;
        this.selector = selector;
        this.conFlor = conFlor;
    }

    @Override
    public void handle(ActionEvent event) {
        //if (selector.getSelectionModel().getSelectedIndex()==1){
        this.aplicacion.generarContenedoresSegunCantidadDeJugadores(selector.getSelectionModel().getSelectedIndex());
        this.aplicacion.setConFlor(conFlor.isSelected());
        this.aplicacion.panel.setCenter(this.aplicacion.nombrar);



            //this.aplicacion.panel.setCenter(this.aplicacion.inicializarMesaParaNuevaPartida());

        }
}

