package fiuba.algo3.Controles.z;

import fiuba.algo3.Modelo.Aplicacion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerConfirmarConfiguracion implements EventHandler {
    Aplicacion aplicacion;
    ChoiceBox selector;
    CheckBox conFlor;

    public HandlerConfirmarConfiguracion(Aplicacion aplicacion, ChoiceBox selector, CheckBox conFlor) {
        this.aplicacion = aplicacion;
        this.selector = selector;
        this.conFlor = conFlor;
    }

    @Override
    public void handle(Event event) {
        //if (selector.getSelectionModel().getSelectedIndex()==1){
        this.aplicacion.generarContenedoresSegunCantidadDeJugadores(selector.getSelectionModel().getSelectedIndex());
        this.aplicacion.setConFlor(conFlor.isSelected());
        this.aplicacion.getBorderPane().setCenter(this.aplicacion.nombrar);



        //this.aplicacion.panel.setCenter(this.aplicacion.inicializarMesaParaNuevaPartida());

    }


    }


