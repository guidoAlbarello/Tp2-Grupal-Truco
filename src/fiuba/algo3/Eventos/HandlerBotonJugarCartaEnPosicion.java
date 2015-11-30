package fiuba.algo3.Eventos;

import fiuba.algo3.AppFX.beta.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

/**
 * Created by anthony on 29/11/2015.
 */
public class HandlerBotonJugarCartaEnPosicion implements EventHandler {
    private Integer posicion;
    private BetaTestVentanas aplicacion;
    private Image imagen;

    public HandlerBotonJugarCartaEnPosicion(Integer posicion,BetaTestVentanas aplicacion, Image imagen){
        this.posicion = posicion;
        this.aplicacion = aplicacion;
        this.imagen = imagen;
    }


    @Override
    public void handle(Event event) {
        aplicacion.getContenedorCartaJugador(this.aplicacion.getJuego().manejadorDeTurnos.getPosicionDelJugadorConTurnoActual()).setImage(this.imagen);

        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().jugarCartaEnPosicion(this.posicion);
        verificarLimpiarCartasDeLaMesa();


        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();


        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());

    }




    private void verificarLimpiarCartasDeLaMesa() {
        if (aplicacion.manoActual != this.aplicacion.getJuego().manejadorDeTurnos.getManoActual()){
            aplicacion.inicializarImagenesDeCartasEnMesa(aplicacion.verticalMedio);

            aplicacion.manoActual = this.aplicacion.getJuego().manejadorDeTurnos.getManoActual();
        }
    }
}