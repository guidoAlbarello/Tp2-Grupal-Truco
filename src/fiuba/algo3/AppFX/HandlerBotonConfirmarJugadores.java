package fiuba.algo3.AppFX;

import fiuba.algo3.manejoDeJugadores.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fechee on 28/11/2015.
 */

/*
public class HandlerBotonConfirmarJugadores implements EventHandler<ActionEvent> {

    public JuegoTruco juego;
    public List<TextField> textos = new ArrayList<TextField>();
    public List<String> nombres = new ArrayList<String>();


    public HandlerBotonConfirmarJugadores(List<HBox> contenedores, JuegoTruco juego){
        this.juego=juego;
        for (HBox contenedor : contenedores){
            TextField texto = ((TextField) contenedor.getChildren().get(1));
            textos.add(texto);
        }
    }


    private void setNombres(){
        for (TextField texto : textos){
            this.nombres.add(texto.getText());
        }
    }



    @Override
    public void handle(ActionEvent event) {
        setNombres();
        int tamanio = nombres.size();
        if (tamanio%2==0 & tamanio>0){
            for (String nombre : nombres){
                Jugador nuevo = new Jugador(nombre);
                nuevo.setJuego(this.juego.truco);
                this.juego.truco.agregarJugador(nuevo);
            }
            this.juego.truco.configurarManejadorDeTurnos();
            this.juego.truco.repartirCartasAJugadores();
            this.juego.generarMesaInicialJuego(tamanio);
            this.juego.mostrarMesa();
            this.juego.mostrarCartasParaJugador();
        }

    }





}
*/