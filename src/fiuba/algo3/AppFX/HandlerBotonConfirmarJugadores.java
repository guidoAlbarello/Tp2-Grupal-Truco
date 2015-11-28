package fiuba.algo3.AppFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fechee on 28/11/2015.
 */
public class HandlerBotonConfirmarJugadores implements EventHandler<ActionEvent> {

    public JuegoTruco juego;
    //public List<TextField> textos = new ArrayList<TextField>();
    public List<String> nombres = new ArrayList<String>();


    public HandlerBotonConfirmarJugadores(List<HBox> contenedores, JuegoTruco juego){
        this.juego=juego;
        for (HBox contenedor : contenedores){
            TextField texto = ((TextField) contenedor.getChildren().get(1));
            this.nombres.add(texto.getText());
        }
    }

    @Override
    public void handle(ActionEvent event) {

        if (nombres.size()%2==0 & nombres.size()>0){
            //TODO AGREGAR JUGADORES
        }

    }





}
