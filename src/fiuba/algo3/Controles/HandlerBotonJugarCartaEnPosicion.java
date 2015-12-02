package fiuba.algo3.Controles;

import fiuba.algo3.Vista.BetaTestVentanas;
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

        aplicacion.getCartaEnMesaDelJugadorEnPosicion(this.aplicacion.getJuego().manejadorDeTurnos.getPosicionDelJugadorConTurnoActual()).setImage(this.imagen);
        aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().jugarCartaEnPosicion(this.posicion);


        if (this.aplicacion.getJuego().hayGanador()) {
            aplicacion.getBorderPane().setLeft(null);
            aplicacion.getBorderPane().setRight(null);
            aplicacion.mostrarGanador(aplicacion.getJuego().ganador);
        }else {


            verificarLimpiarCartasDeLaMesa();


            aplicacion.actualizarCartasEnManoParaJugadorActual();
            aplicacion.actualizarBotonesCartas();


            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
            aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        }
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