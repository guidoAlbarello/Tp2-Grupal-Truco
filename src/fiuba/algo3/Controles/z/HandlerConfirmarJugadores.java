package fiuba.algo3.Controles.z;

import fiuba.algo3.Modelo.InteligenciaArtificial.JugadorArtificial;
import fiuba.algo3.Modelo.Aplicacion;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerConfirmarJugadores implements EventHandler{
    public Aplicacion aplicacion;
    public List<TextField> textos = new ArrayList<TextField>();
    public List<String> nombres = new ArrayList<String>();
    public List<CheckBox> jugadoresSonHumanos;
    public LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
    public HandlerConfirmarJugadores(ArrayList<HBox> contenedores, Aplicacion aplicacion) {
        this.aplicacion=aplicacion;
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
    public void handle(Event event) {
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
        this.aplicacion.getBorderPane().setCenter(this.aplicacion.cuadriculaDeJuego());
        this.aplicacion.getBorderPane().setLeft(this.aplicacion.contenedorEstadoDeJuego());
        this.aplicacion.getBorderPane().setRight(this.aplicacion.contenedorDeJugadas());
    }
}
