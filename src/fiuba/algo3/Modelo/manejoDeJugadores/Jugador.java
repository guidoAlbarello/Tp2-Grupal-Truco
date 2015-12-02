package fiuba.algo3.Modelo.manejoDeJugadores;

import fiuba.algo3.Modelo.ModeladoDeCarta.CartaJugada;
import fiuba.algo3.Modelo.Excepciones.NoEsUnJugadorArtificialError;
import fiuba.algo3.Modelo.Juego.Juego;
import fiuba.algo3.Modelo.Juego.Mano;
import fiuba.algo3.Modelo.ModeladoDeCarta.Carta;

/**
 * Created by Fechee on 18/11/2015.
 */
public class Jugador {

    private String nombreJugador;
    private Mano manoDelJugador;
    private Equipo equipo;
    private Juego juego;


    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        this.manoDelJugador = new Mano();
    }

    public void setJuego(Juego nuevoJuego){ this.juego = nuevoJuego;}

    public Mano getMano(){  return this.manoDelJugador;  }

    public String getNombre() {
        return this.nombreJugador;
    }

    public void recibirCarta(Carta unaCarta) {  this.manoDelJugador.agregarCarta(unaCarta);   }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo() {  return this.equipo;  }

    public void envido() {
        this.juego.seCantaEnvido();
    }

    public void noQuiero() {
        this.juego.noQuiero();
    }

    public void jugarCarta(CartaJugada cartaDeJugador) {
        this.juego.jugarCarta(cartaDeJugador);
    }

    public void jugarCartaEnPosicion(int indiceDeLaCarta){
        this.juego.jugarCarta(new CartaJugada(this.manoDelJugador.jugarCarta(indiceDeLaCarta),this));
    }

    public void hacerJugada(){
        throw new NoEsUnJugadorArtificialError();
    }

    public void truco() {
        this.juego.seCantaTruco();
    }

    public void quiero() {
        this.juego.quiero();
    }

    public void realEnvido() {
        this.juego.seCantaRealEnvido();
    }

    public void faltaEnvido() {this.juego.seCantaFaltaEnvido();}

    public void retruco() {
        this.juego.seCantaRetruco();
    }

    public void valeCuatro() {
        this.juego.seCantaValeCuatro();
    }

    public void meVoyAlMaso() {
        this.juego.meVoyAlMaso();
    }

    public void flor() {
        this.juego.seCantaFlor();
    }

    public Juego getJuego() {
        return juego;
    }

    public void inicializarCerebroJugador() {

    }
}



