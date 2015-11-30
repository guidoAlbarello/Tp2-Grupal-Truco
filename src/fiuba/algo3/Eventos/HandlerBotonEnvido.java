package fiuba.algo3.Eventos;


import fiuba.algo3.aplicacionAnthony.Aplicacion;
import javafx.event.EventHandler;

import javafx.event.ActionEvent;


/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonEnvido implements EventHandler <ActionEvent> {
    private Aplicacion aplicacion;

    public HandlerBotonEnvido(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        this.aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadasEnvido());
    }

   /* public HandlerBotonEnvido(Aplicacion aplicacion){
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
