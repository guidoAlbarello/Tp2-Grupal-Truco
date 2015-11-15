package fiuba.algo3.modelo;

import fiuba.algo3.modelo.jugadasPosibles.Jugada;

/**
 * Created by anthony on 12/11/2015.
 */
public class JugadorEnRonda {
    private Jugador jugadorEnRonda;
    private int puntosGanadosEnRonda;
    private int manosGanadas;
    public int getManosGanadas;

    public JugadorEnRonda(Jugador jugador) {
        this.jugadorEnRonda = jugador;
        this.puntosGanadosEnRonda = 0;
        this.manosGanadas = 0;
    }

    public int getPuntosGanadosEnRonda(){return this.puntosGanadosEnRonda;}

    public Jugador getJugador() {
        return jugadorEnRonda;
    }

    public int getManosGanadas() {
        return this.manosGanadas;
    }

    public void actualizarPuntajeDeJugador() {
        this.getJugador().sumaPuntaje(this.puntosGanadosEnRonda);
    }

    public void inicializarParaNuevaRonda() {
        this.puntosGanadosEnRonda = 0;
        this.manosGanadas = 0;
    }

    public void sumaPuntajeEnRonda(int puntajeEnRonda) {
        this.puntosGanadosEnRonda += puntajeEnRonda;
    }

    public void aumentarManosGanadas() {
        this.manosGanadas+=1;           ///------- YO FEDE EDITE PARA TESTEAR MESA   nota: antes este metodo no hacia nada
    }

    /**
     * Created by Fechee on 10/11/2015.
     */
    public abstract static class Cantos {

        public Jugada jugarCarta(Carta carta,Jugador jugador){
            return null;
        }
        public abstract Jugada cantarEnvido(Jugador jugador);

        public abstract Jugada cantarRealEnvido(Jugador jugador);

        public abstract Jugada cantarFaltaEnvido(Jugador jugador);

        public abstract Jugada cantarFlor(Jugador jugador);
    }
}
