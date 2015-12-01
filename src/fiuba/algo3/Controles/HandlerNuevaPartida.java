package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
