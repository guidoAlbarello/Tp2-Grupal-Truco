package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Created by Fechee on 02/12/2015.
 */
public class HandlerBotonMostrarCreditos implements EventHandler<ActionEvent> {
    BetaTestVentanas aplicacion;

    public HandlerBotonMostrarCreditos(BetaTestVentanas aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        VBox creditos = new VBox();
        creditos.setSpacing(20);
        creditos.setAlignment(Pos.CENTER);
        creditos.getChildren().add(new Label("Trabajo Practico Final - Algoritmos y Programacion III"));
        creditos.getChildren().add(new Label("Facultad de Ingenieria de la Universidad de Buenos Aires (FIUBA)"));
        creditos.getChildren().add(new Label());
        creditos.getChildren().add(new Label("INTEGRANTES:"));
        creditos.getChildren().add(new Label("Federico Ezequiel Bogovic"));
        creditos.getChildren().add(new Label("Guido Sergio Albarello"));
        creditos.getChildren().add(new Label("Jhon Anthony Valer Torrres"));
        creditos.getChildren().add(new Label());
        creditos.getChildren().add(new Label("AYUDANTE:"));
        creditos.getChildren().add(new Label("Matias Anastopulos"));

        creditos.getChildren().add(new Label());
        creditos.getChildren().add(new Label());
        creditos.getChildren().add(new Label("Segundo cuatrimestre 2015"));


        Button volver = new Button("Volver");
        Node medio = aplicacion.panel.getCenter();
        Node izq = aplicacion.panel.getLeft();
        Node der = aplicacion.panel.getRight();
        volver.setOnAction(new HandlerBotonVolverAVentanaAnterior(this.aplicacion,izq,medio,der));
        creditos.getChildren().add(volver);

        aplicacion.panel.setLeft(null);
        aplicacion.panel.setRight(null);
        aplicacion.panel.setCenter(creditos);
    }
}
