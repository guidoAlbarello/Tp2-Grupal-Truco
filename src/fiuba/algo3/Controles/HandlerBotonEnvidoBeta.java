package fiuba.algo3.Controles;

import fiuba.algo3.Modelo.Excepciones.NoEsUnJugadorArtificialError;
import fiuba.algo3.Modelo.ModeladoDeCarta.Carta;
import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import javax.swing.*;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonEnvidoBeta implements EventHandler {
    private BetaTestVentanas aplicacion;

    public HandlerBotonEnvidoBeta(BetaTestVentanas aplicacion){
        this.aplicacion = aplicacion;
    }
    @Override
    public void handle(Event event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().envido();
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "No se puede jugar Envido",
                    "JUGADA INVALIDA", JOptionPane.WARNING_MESSAGE);
        }




        aplicacion.actualizarCartasEnManoParaJugadorActual();
        aplicacion.actualizarBotonesCartas();
        aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());
        //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
        aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());


       // verificarJugadaDeIa();
    }


  /*  private void verificarJugadaDeIa() {
        try {
            this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().hacerJugada();
                int indiceDelIndiceDeLaUltimaCartaJugadaPorIA = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorAnteriorAlTurnoActual().getMano().getIndicesDeCartasJugadas().size()-1;
                int indiceUltimaCartaJugadaPorIA = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorAnteriorAlTurnoActual().getMano().getIndicesDeCartasJugadas().get(indiceDelIndiceDeLaUltimaCartaJugadaPorIA);
                Carta carta = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorAnteriorAlTurnoActual().getMano().getCartasEnMano().get(indiceUltimaCartaJugadaPorIA);
                String direccionCarta = "imagenes/"+carta.getValorDeCarta()+carta.getPaloDeCarta().getNombre()+".jpg";
                Image imagenCarta = new Image(direccionCarta);
                aplicacion.getCartaEnMesaDelJugadorEnPosicion(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion()).setImage(imagenCarta);
                aplicacion.actualizarCartasEnManoParaJugadorActual();
                aplicacion.actualizarBotonesCartas();
                aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());


        }catch (NoEsUnJugadorArtificialError e){}
    }*/
}
