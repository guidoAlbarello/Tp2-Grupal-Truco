package fiuba.algo3.AppFX.beta;

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

        //pausa

        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().jugarCartaEnPosicion(this.posicion);
        verificarLimpiarCartasDeLaMesa();


        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();


        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());

    }





    private void verificarLimpiarCartasDeLaMesa() {
        if (aplicacion.manoActual != this.aplicacion.getJuego().manejadorDeTurnos.getManoActual() & (aplicacion.getJuego().manejadorDeTurnos.vecesQueSePasoElTurno == 1 )){
            if (aplicacion.getJuego().manejadorDeTurnos.vecesQueSePasoElTurno == 1 & (aplicacion.rondaActual == this.aplicacion.getJuego().manejadorDeTurnos.getRondaActual()) ) {
                aplicacion.inicializarImagenesDeCartasEnMesa(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion() + 1, imagen);
            }else if (aplicacion.getJuego().manejadorDeTurnos.vecesQueSePasoElTurno == 1 & aplicacion.rondaActual != this.aplicacion.getJuego().manejadorDeTurnos.getRondaActual()){
                aplicacion.inicializarImagenesDeCartasEnMesa(5, null);
                aplicacion.inicializarImagenesDeCartasEnMesa(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion() + 1, imagen);
            }




            aplicacion.manoActual = this.aplicacion.getJuego().manejadorDeTurnos.getManoActual();
        }
    }
}