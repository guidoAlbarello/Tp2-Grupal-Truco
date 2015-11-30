package fiuba.algo3.InteligenciaArtificial;

import fiuba.algo3.EstadosDeJuego.EstadoDeJuego;
import fiuba.algo3.Mesa;

/**
 * Created by Krion on 30/11/2015.
 */
public class MotorDeIA {
    private DecisionSegunEstado decisionSegunEstado;

    public MotorDeIA(JugadorArtificial unJugador, Mesa mesaDeJuego){
        this.decisionSegunEstado = new DecisionSegunEstado(unJugador, mesaDeJuego);
    }
    public void elegirJugada(EstadoDeJuego estadoDeJuegoActual){
       estadoDeJuegoActual.elegirJugadaJugadorArtificial(decisionSegunEstado);
    }
}
