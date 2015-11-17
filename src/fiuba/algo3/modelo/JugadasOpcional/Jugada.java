package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

import java.util.List;

/**
 * Created by Krion on 16/11/2015.
 */
public abstract class Jugada {
    private Jugador jugadorQueLoCanto;
    private int valorDeJugada;

    public int getValorDeJugada(){
        return this.valorDeJugada;
    }

    public void setValorDeJugada(int unValor){
        this.valorDeJugada = unValor;
    }

    public Jugador getJugadorQueLoCanto(){
        return this.jugadorQueLoCanto;
    }

    public void setJugadorQueLoCanto(Jugador unJugador){
        this.jugadorQueLoCanto = unJugador;
    }

    public abstract List<Class> getJugadasPosibles();

    public abstract boolean esUnaJugadaValida(Jugada unaJugada);

    public abstract void resolverEnManejadorDeJugadas(ManejadorDeJugadas manejadorDeJugadas);
}
