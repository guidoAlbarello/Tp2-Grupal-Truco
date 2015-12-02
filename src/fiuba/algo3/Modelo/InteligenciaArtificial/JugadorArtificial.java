package fiuba.algo3.Modelo.InteligenciaArtificial;

import fiuba.algo3.Modelo.Juego.Juego;
import fiuba.algo3.Modelo.manejoDeJugadores.Jugador;

/**
 * Created by Krion on 29/11/2015.
 */
public class JugadorArtificial extends Jugador{
    private MotorDeIA cerebroJugador;
    public JugadorArtificial(String nombre) {
        super(nombre);
    }

    public void setJuego(Juego juego){
        this.juego = juego;
        cerebroJugador = new MotorDeIA(this, this.getJuego().getMesaDelJuego());
    }

    public boolean esUnJugadorIA(){
        return true;
    }

    public void hacerJugada(){
        cerebroJugador.elegirJugada(this.getJuego().getEstadoDeJuego());
    }

    public void elegirCarta(int factorDeAzar) {
        Jugador jugadorQueJugoLaCartaMasAlta = this.getJuego().getMesaDelJuego().getCartaGanadora().getJugador();
        int indiceCartaAJugar;
        if((this.esDelMismoEquipoQue(jugadorQueJugoLaCartaMasAlta) && factorDeAzar > 90) || factorDeAzar < 33)
            indiceCartaAJugar = this.getMano().getIndiceCartaMasBaja();
        else
            indiceCartaAJugar = this.getMano().getIndiceCartaMasAlta();
        this.jugarCartaEnPosicion(indiceCartaAJugar);

    }

    private boolean esDelMismoEquipoQue(Jugador unJugador) {
        return this.getEquipo().getJugadores().contains(unJugador);
    }

}
