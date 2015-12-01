package fiuba.algo3.AppFX;

import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import fiuba.algo3.InteligenciaArtificial.JugadorArtificial;
import fiuba.algo3.manejoDeJugadores.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fechee on 28/11/2015.
 */


public class HandlerBotonConfirmarJugadores implements EventHandler<ActionEvent> {

    public BetaTestVentanas aplicacion;
    public List<TextField> textos = new ArrayList<TextField>();
    public List<String> nombres = new ArrayList<String>();
    public LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
    public List<CheckBox> jugadoresSonHumanos;


    public HandlerBotonConfirmarJugadores(List<HBox> contenedores, BetaTestVentanas juego){
        this.aplicacion=juego;
        this.jugadoresSonHumanos = new ArrayList<>();
        for (HBox contenedor : contenedores){
            TextField texto = ((TextField) contenedor.getChildren().get(1));
            textos.add(texto);
            jugadoresSonHumanos.add((CheckBox) contenedor.getChildren().get(3));
        }
    }


    private void setNombres(){
        int i = 0;
        for (TextField texto : textos){
            i++;
            String nombreParaAgregar = texto.getText();
            if (nombreParaAgregar.equals("")){
                nombreParaAgregar=("Jugador"+i);
            }
            this.nombres.add(nombreParaAgregar);
        }
    }



    @Override
    public void handle(ActionEvent event) {
        setNombres();
        int contador = 0;
        for (String nombre : nombres){
            if(jugadoresSonHumanos.get(contador).isSelected()) {
                Jugador nuevoJugador = new Jugador(nombre);
                this.jugadores.addLast(nuevoJugador);
            } else{
                JugadorArtificial nuevoJugador = new JugadorArtificial(nombre);
                this.jugadores.addLast(nuevoJugador);
            }
            contador++;
        }
        this.aplicacion.inicializarJuego(this.jugadores);
        this.aplicacion.panel.setCenter(this.aplicacion.inicializarMesaParaNuevaPartida());
        this.aplicacion.panel.setLeft(this.aplicacion.contenedorEstadoDeJuego());
        this.aplicacion.panel.setRight(this.aplicacion.contenedorDeJugadas());
    }


}
