package fiuba.algo3.Controles;

import fiuba.algo3.Modelo.Excepciones.NoEsUnJugadorArtificialError;
import fiuba.algo3.Modelo.ModeladoDeCarta.Carta;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;
import fiuba.algo3.Vista.BetaTestVentanas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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

            //verificarJugadaDeIa();
        }
    }

    private void verificarJugadaDeIa() {
        try {
            Jugador artificial = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual();
            if (aplicacion.getJuego().manejadorDeTurnos.vecesQueSePasoElTurno == 0 & artificial == aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual()){aplicacion.getCartaEnMesaDelJugadorEnPosicion(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion()).setImage(new Image("imagenes/huskar.jpg"));}
            else if (aplicacion.getJuego().manejadorDeTurnos.vecesQueSePasoElTurno==0 & aplicacion.hayIA){
                aplicacion.getCartaEnMesaDelJugadorEnPosicion(0).setImage(new Image("imagenes/huskar.jpg"));
                aplicacion.getCartaEnMesaDelJugadorEnPosicion(1).setImage(new Image("imagenes/huskar.jpg"));
            }

            int cantidadTiradas = artificial.getMano().getIndicesDeCartasJugadas().size();
            this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual().hacerJugada();
            if (aplicacion.getJuego().manejadorDeTurnos.vecesQueSePasoElTurno==0){aplicacion.getCartaEnMesaDelJugadorEnPosicion(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion()).setImage(new Image("imagenes/huskar.jpg"));}
            int cantidadTiradasDespuesDeTirar = artificial.getMano().getIndicesDeCartasJugadas().size();
            if (cantidadTiradas!=cantidadTiradasDespuesDeTirar){
                if (this.aplicacion.getJuego().manejadorDeTurnos.getJugadorConTurnoActual()!=artificial) {
                    int indiceUltimaCartaJugadaPorIA = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorAnteriorAlTurnoActual().getMano().getIndicesDeCartasJugadas().get(cantidadTiradasDespuesDeTirar-1);
                    Carta carta = this.aplicacion.getJuego().manejadorDeTurnos.getJugadorAnteriorAlTurnoActual().getMano().getCartasEnMano().get(indiceUltimaCartaJugadaPorIA);
                    String direccionCarta = "imagenes/" + carta.getValorDeCarta() + carta.getPaloDeCarta().getNombre() + ".jpg";
                    Image imagenCarta = new Image(direccionCarta);
                    aplicacion.getCartaEnMesaDelJugadorEnPosicion(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion()).setImage(imagenCarta);
                    aplicacion.actualizarCartasEnManoParaJugadorActual();
                    aplicacion.actualizarBotonesCartas();
                    aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
                    //verificarLimpiarCartasDeLaMesa();
                }else{
                    aplicacion.getCartaEnMesaDelJugadorEnPosicion(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion()).setImage(new Image("imagenes/huskar.jpg"));
                    verificarJugadaDeIa();
                }

            }else{
                //aplicacion.getCartaEnMesaDelJugadorEnPosicion(this.aplicacion.getJuego().manejadorDeTurnos.getNodoJugadorConTurnoActual().getAnterior().getPosicion()).setImage(new Image("imagenes/huskar.jpg"));
                //esta linea de arriba significa limpiar las cartas de mesa, pero solo sirve para 2 jguadores
                aplicacion.getBorderPane().setRight(this.aplicacion.contenedorDeJugadas());
                aplicacion.getBorderPane().setLeft(aplicacion.contenedorEstadoDeJuego());
                aplicacion.actualizarCartasEnManoParaJugadorActual();
                aplicacion.actualizarBotonesCartas();
            }

        }catch (NoEsUnJugadorArtificialError e){}
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