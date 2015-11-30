package fiuba.algo3.AppFX;

import fiuba.algo3.manejoDeJugadores.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by Fechee on 28/11/2015.
 **/
/*
public class HandlerBotonTirarCarta implements EventHandler<ActionEvent> {
    private JuegoTruco juego;
    private Integer indiceDeCarta;
    private String nombreDeLaCarta;
    private Jugador conTurnoActual;


    public HandlerBotonTirarCarta(JuegoTruco juego, Integer indiceDeCarta,String nombreDeLaCarta){
        this.juego=juego;
        this.indiceDeCarta = indiceDeCarta;
        this.nombreDeLaCarta = nombreDeLaCarta;
        this.conTurnoActual = this.juego.truco.manejadorDeTurnos.getJugadorConTurnoActual();
    }

    private int getPosicionDelJugador(){
        for (int i = 0 ; i < this.juego.truco.getJugadores().getTamanio() ; i++) {
            if (this.juego.truco.getJugadores().getJugadorEnPosicion(i).equals(conTurnoActual)){
                return i;
            }
        }
        return 0;
    }


    @Override
    public void handle(ActionEvent event) {
        conTurnoActual.jugarCartaEnPosicion(indiceDeCarta);
        ((Button)this.juego.jugadoresMostrados.get(getPosicionDelJugador()).getChildren().get(1)).setText(nombreDeLaCarta);
        //TODO: ACTUALIZAR MESA, MOSTRAR CARTAS DEL OTRO JUGADOR O MOSTRAR PUNTAJE
    }
}
*/