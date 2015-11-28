package fiuba.algo3.AppFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Fechee on 28/11/2015.
 */
public class HandlerBotonTirarCarta implements EventHandler<ActionEvent> {
    private JuegoTruco juego;
    private Integer indiceDeCarta;


    public HandlerBotonTirarCarta(JuegoTruco juego, Integer indiceDeCarta){
        this.juego=juego;
        this.indiceDeCarta = indiceDeCarta;
    }


    @Override
    public void handle(ActionEvent event) {
        //TODO
    }
}
