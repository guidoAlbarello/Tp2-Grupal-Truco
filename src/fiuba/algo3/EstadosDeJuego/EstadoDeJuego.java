package fiuba.algo3.EstadosDeJuego;

import fiuba.algo3.CartaJugada;

public interface EstadoDeJuego {
    //despues habria q agregar todo lo de flor o sin flor
    public void envido();
    public void realEnvido();
    public void faltaEnvido();
    public void truco();
    public void retruco();
    public void valeCuatro();
    public void quiero();
    public void noQuiero();
    public void irseAlMaso();
    public int puntosDeEstado();

    void jugarCarta(CartaJugada cartaJugada);
}
