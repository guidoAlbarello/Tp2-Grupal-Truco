package fiuba.algo3.modelo.JugadasOpcional;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import fiuba.algo3.modelo.jugadasPosibles.SeJuegaConFlor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krion on 16/11/2015.
 */
public class JugadaInicial extends Jugada {
    private List<Class> respuestasPosibles;

    public JugadaInicial(Jugador unJugador, int numeroDeMano, SeJuegaConFlor seJuegaConFlor) {
        if(numeroDeMano == 1) {
            try{
                seJuegaConFlor.getSiHayJugadaFlor();
                this.respuestasPosibles.add(CantoFlor.class);
            }catch(NoSeEstaJugandoConFlorError e){}


            this.respuestasPosibles.add(CantoEnvido.class);
            this.respuestasPosibles.add(CantoRealEnvido.class);
            this.respuestasPosibles.add(CantoFaltaEnvido.class);
        }

        this.respuestasPosibles.add(CantoTruco.class);
    }

    @Override
    public List<Class> getJugadasPosibles() {
        return this.respuestasPosibles;
    }

    @Override
    public boolean esUnaJugadaValida(Jugada unaJugada) {
        return this.respuestasPosibles.contains(unaJugada.getClass());
    }
}