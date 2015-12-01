package fiuba.algo3.AppFX.eventosBeta;


import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;


/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugadasEnvidoBeta implements EventHandler <ActionEvent> {
    private BetaTestVentanas aplicacion;

    public HandlerBotonJugadasEnvidoBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        //this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadasEnvido());
    }

   /* public HandlerBotonJugadasEnvido(Aplicacion aplicacion){
        this.contenedorDeJugadas = contenedorDeJugadas;
        this.panel = panel;
    }
    @Override
    public void handle(ActionEvent event) {
        this.contenedorDeJugadas = this.cambiarEstadoJugadaEnvido();
        this.panel.setLeft(contenedorDeJugadas);
    }

    private VBox cambiarEstadoJugadaEnvido() {
        System.out.print("hola");
        Button botonRealEnvido = new Button("RealEnvido");
        VBox nuevasJuagdas = new VBox(botonRealEnvido);
        return nuevasJuagdas;
    }*/
}
