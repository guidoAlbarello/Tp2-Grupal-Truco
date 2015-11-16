package fiuba.algo3.modelo.jugadasPosibles;


import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.NoExisteLaJugadaError;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;

import java.util.List;

/**
 * Created by Krion on 15/11/2015.
 */
public abstract class JugadaPosible {
    public abstract List<String> getJugadasPosibles();

    public Jugada hacerJugada(String unaJugadaNueva, Jugador unJugador) {
        return (Jugada) crearClase(unaJugadaNueva, unJugador);
    }

    public abstract int compararNombresJugadas(String unaNuevaJugada);

    protected abstract Object crearClase(String unaJugadaNueva, Jugador unJugador);

    public abstract SeJuegaConFlor getSeJuegaConFlor();
}
