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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by Fechee on 02/12/2015.
 */
public class HandlerBotonValoresDeCartas  implements EventHandler<ActionEvent> {

    BetaTestVentanas aplicacion;

    public HandlerBotonValoresDeCartas(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }


    @Override
    public void handle(ActionEvent event) {
        VBox valorDeCartas = new VBox();
        valorDeCartas.setSpacing(20);
        valorDeCartas.setAlignment(Pos.CENTER);
        valorDeCartas.getChildren().add(new Label("VALOR DE CARTAS"));
        valorDeCartas.getChildren().add(new ImageView(new Image("imagenes/valor_cartas.jpg")));
        Button volver = new Button("Volver");
        Node medio = aplicacion.panel.getCenter();
        Node izq = aplicacion.panel.getLeft();
        Node der = aplicacion.panel.getRight();
        volver.setOnAction(new HandlerBotonVolverAVentanaAnterior(this.aplicacion,izq,medio,der));
        valorDeCartas.getChildren().add(volver);

        aplicacion.panel.setLeft(null);
        aplicacion.panel.setRight(null);
        aplicacion.panel.setCenter(valorDeCartas);
    }
}
