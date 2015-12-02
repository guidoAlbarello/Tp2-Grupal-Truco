package fiuba.algo3.Controles;

import fiuba.algo3.Modelo.Excepciones.NoEsUnJugadorArtificialError;
import fiuba.algo3.Modelo.ModeladoDeCarta.Carta;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;
import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

import javax.swing.*;

/**
 * Created by anthony on 30/11/2015.
 */
public class HandlerBotonQuieroBeta implements EventHandler<ActionEvent> {
    private BetaTestVentanas aplicacion;
    private Image imagen;

    public HandlerBotonQuieroBeta(BetaTestVentanas aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().quiero();
        }catch (RuntimeException e){
            JOptionPane mensajeError = new JOptionPane();
            mensajeError.showMessageDialog(null, "no hay cantos en juego",
                    "JUGADA INVALIDA", JOptionPane.ERROR_MESSAGE);
        }
        if (this.aplicacion.getJuego().hayGanador()) {
            aplicacion.getBorderPane().setLeft(null);
            aplicacion.getBorderPane().setRight(null);
            aplicacion.mostrarGanador(aplicacion.getJuego().ganador);
        }else {
            aplicacion.actualizarCartasEnManoParaJugadorActual();
            aplicacion.actualizarBotonesCartas();
            //aplicacion.getBorderPane().setCenter(aplicacion.cuadriculaDeJuego());
            aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
            aplicacion.getBorderPane().setRight(aplicacion.contenedorDeJugadas());

            //verificarJugadaDeIa();
        }
    }

/*
    private void verificarJugadaDeIa() {
        try {
            Jugador artificial = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual();
            int cantidadTiradas = artificial.getMano().getIndicesDeCartasJugadas().size();
            this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().hacerJugada();
            int cantidadTiradasDespuesDeTirar = artificial.getMano().getIndicesDeCartasJugadas().size();
            if (cantidadTiradas!=cantidadTiradasDespuesDeTirar){
                if (this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual()!=artificial) {
                    int indiceUltimaCartaJugadaPorIA = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorAnteriorAlTurnoActual().getMano().getIndicesDeCartasJugadas().get(cantidadTiradasDespuesDeTirar-1);
                    Carta carta = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorAnteriorAlTurnoActual().getMano().getCartasEnMano().get(indiceUltimaCartaJugadaPorIA);
                    String direccionCarta = "imagenes/" + carta.getValorDeCarta() + carta.getPaloDeCarta().getNombre() + ".jpg";
                    imagen = new Image(direccionCarta);
                    aplicacion.getCartaEnMesaDelJugadorEnPosicion(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion()).setImage(imagen);
                    aplicacion.actualizarCartasEnManoParaJugadorActual();
                    aplicacion.actualizarBotonesCartas();
                    aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
                    verificarLimpiarCartasDeLaMesa();
                }else{verificarJugadaDeIa();}

            }else{
                aplicacion.getBorderPane().setRight(this.aplicacion.contenedorDeJugadas());
                aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
                aplicacion.actualizarCartasEnManoParaJugadorActual();
                aplicacion.actualizarBotonesCartas();
            }

        }catch (NoEsUnJugadorArtificialError e){}
    }
*/

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
