package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class Mesa {
    private final int PUNTAJE_MAXIMO = 30;
    private JugadorEnRonda jugadorEnRonda1;
    private JugadorEnRonda jugadorEnRonda2;
    private ManejadorDeTurnos manejadorDeTurnos;

    public Mesa(JugadorEnRonda jugadorEnRonda1, JugadorEnRonda jugadorEnRonda2, ManejadorDeTurnos manejadorDeTurnos) {
        this.jugadorEnRonda1 = jugadorEnRonda1;
        this.jugadorEnRonda2 = jugadorEnRonda2;
        this.manejadorDeTurnos = manejadorDeTurnos;
    }

    public void resolverEnvido(EnvidoCantado envido) {
        manejadorDeTurnos.pasarTurnoEnMano();
        Jugador jugadorQueLeTocaResponder = manejadorDeTurnos.getJugadorTurnoEnMano().getJugador();
        Jugada jugadaDelJugador = jugadorQueLeTocaResponder.responderEnvio();
        this.resolverJugada(jugadaDelJugador);
    }

    public void resolverJugada(Jugada respuesta) {
        respuesta.resolverEnMesa(this);
    }

    public void resolverAceptaEnvido(AceptaEnvido aceptaEnvido) {
        JugadorEnRonda jugadorGanador = this.compararTantos(jugadorEnRonda1,jugadorEnRonda2);
        jugadorGanador.sumaPuntajeEnRonda(2);// se suman 2 puntos por acepto envido
    }
    
    private JugadorEnRonda compararTantos(JugadorEnRonda jugadorEnRonda1, JugadorEnRonda jugadorEnRonda2) {
        if (jugadorEnRonda1.getJugador().calcularEnvido() == jugadorEnRonda2.getJugador().calcularEnvido()){
            return manejadorDeTurnos.getJugadorMano();
        }
        if (jugadorEnRonda1.getJugador().calcularEnvido()> jugadorEnRonda2.getJugador().calcularEnvido())
            return jugadorEnRonda1;
        else
            return jugadorEnRonda2;
    }

    public Jugador compararCartas(CartaJugada cartaJugada, CartaJugada cartaRespuesta) {
        return null;
    }

    public void resolverRealEnvido(RealEnvido realEnvido){
        manejadorDeTurnos.pasarTurnoEnMano();
        Jugador jugador = manejadorDeTurnos.getJugadorTurnoEnMano().getJugador();
        Jugada respuesta = jugador.responderRealEnvido();
        this.resolverJugada(respuesta);
    }

    public void resolverAceptaRealEnvido(AceptaRealEnvido aceptaRealEnvido) {
        JugadorEnRonda jugadorGanador = this.compararTantos(jugadorEnRonda1,jugadorEnRonda2);
        jugadorGanador.sumaPuntajeEnRonda(4);// se suman 4 puntos por acepto envido
    }

    public void resolverNoAceptaEnvido(NoAceptaEnvido noAceptaEnvido) {
        manejadorDeTurnos.pasarTurnoEnMano();
        JugadorEnRonda jugador = manejadorDeTurnos.getJugadorTurnoEnMano();
        jugador.sumaPuntajeEnRonda(1);//no se acepta envido entonces el otro jugador suma 1
    }
    public void resolverCartaJugada(CartaJugada cartaJugada){
        Jugador jugador = manejadorDeTurnos.getJugadorTurnoEnMano().getJugador();
        CartaJugada cartaRespuesta = jugador.responderCarta(cartaJugada);
        Jugador jugadorGanador = this.compararCartas(cartaJugada,cartaRespuesta);
        jugadorGanador.incrementarManosGanadas();//suma 1 por q gano la manosGanadas  solo con cartas

    }
}
