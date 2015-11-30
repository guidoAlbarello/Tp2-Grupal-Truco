package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;
import fiuba.algo3.InteligenciaArtificial.DecisionSegunEstado;

public interface EstadoDeJuego {
    public void flor();
    public void contraFlor();
    public void contraFlorAlResto();
    public void envido();
    public void realEnvido();
    public void faltaEnvido();
    public void truco();
    public void retruco();
    public void valeCuatro();
    public void quiero();
    public void noQuiero();
    public void irseAlMaso();
    public int puntosSiSeQuiere();
    public void jugarCarta(CartaJugada cartaJugada);

    void elegirJugadaJugadorArtificial(DecisionSegunEstado decisionSegunEstado);
}
