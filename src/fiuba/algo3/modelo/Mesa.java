package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class Mesa {
    private final int PUNTAJE_MAXIMO = 30;
    private Jugador jugador2;
    private Jugador jugador1;
    private ManejadorDePuntaje manejadorDePuntaje;

    private ManejadorDeTurnos manejadorDeTurnos;

    public Mesa(Jugador jugador1,Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        manejadorDeTurnos = new ManejadorDeTurnos(jugador1,jugador2);

    }
    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }
    public ManejadorDeTurnos getManejadorDeTurnos(){return this.manejadorDeTurnos;}

    public void comenzarJuego(){
        while (manejadorDePuntaje.getPuntaje(jugador1.getNombre()) < PUNTAJE_MAXIMO || manejadorDePuntaje.getPuntaje(jugador2.getNombre()) < PUNTAJE_MAXIMO){
            this.comenzarRonda();
        }
    }
    public void comenzarRonda() {
       // this.manejadorDePuntaje.setManosGanadas(jugador1.getNombre(),0);
        //this.manejadorDePuntaje.setManosGanadas(jugador2.getNombre(),0);
        while (manejadorDePuntaje.getPuntaje(jugador1.getNombre())== 0 && manejadorDePuntaje.getPuntaje(jugador2.getNombre())==0){
            comenzarMano(jugador1, jugador2);
        }
    }

    public  void comenzarMano(Jugador jugador1, Jugador jugador2) {
        Jugador jugador = manejadorDeTurnos.jugadorMano();
        Jugada respuesta = jugador.hacerJugada();
        this.resolverJugada(respuesta);
    }

    public void resolverCartaJugada(CartaJugada cartaJugada){
        Jugador jugador = manejadorDeTurnos.jugadorTurnoEnMano();
        CartaJugada cartaRespuesta = jugador.responderCarta(cartaJugada);
        Jugador jugadorGanador = this.compararCartas(cartaJugada,cartaRespuesta);
        jugadorGanador.incrementarManosGanadas();//suma 1 por q gano la manosGanadas  solo con cartas

    }

    public Jugador compararCartas(CartaJugada cartaJugada, CartaJugada cartaRespuesta) {
        return jugador1;
    }

    public void resolverEnvido(EnvidoCantado envido) {
        Jugador jugador = manejadorDeTurnos.jugadorTurnoEnMano();
        Jugada jugadaDelJugador = jugador.responderEnvio();
        this.resolverJugada(jugadaDelJugador);
        manejadorDeTurnos.pasarTurnoEnMano();
    }

    public void resolverJugada(Jugada respuesta) {
        respuesta.resolverEnMesa(this);
    }

    public void resolverAceptaEnvido(AceptaEnvido aceptaEnvido) {
        Jugador jugadorQueCantoEnvido = manejadorDeTurnos.jugadorTurnoEnMano();
        Jugador jugadorGanador = this.compararTantos(jugador1,jugador2);
        jugadorGanador.sumaPuntaje(2);// se suman 2 puntos por acepto envido
        manejadorDeTurnos.pasarTurnoEnMano();
    }

    public void resolverRealEnvido(RealEnvido realEnvido){
        Jugador jugador = manejadorDeTurnos.jugadorTurnoEnMano();
        Jugada respuesta = jugador.responderRealEnvido();
        this.resolverJugada(respuesta);
    }

    public void resolverAceptaRealEnvido(AceptaRealEnvido aceptaRealEnvido) {
        Jugador jugadorQueCantoEnvido = manejadorDeTurnos.jugadorTurnoEnMano();
        Jugador jugadorGanador = this.compararTantos(jugador1,jugador2);
        jugadorGanador.sumaPuntaje(4);// se suman 4 puntos por acepto envido
        manejadorDeTurnos.pasarTurnoEnMano();
    }
    private Jugador compararTantos(Jugador jugador1, Jugador jugador2) {
        if (jugador1.calcularEnvido() == jugador2.calcularEnvido()){
            return manejadorDeTurnos.jugadorMano();
        }
        if (jugador1.calcularEnvido()> jugador2.calcularEnvido())
            return jugador1;
        else
            return jugador2;
    }


    public void resolverNoAceptaEnvido(NoAceptaEnvido noAceptaEnvido) {
        manejadorDeTurnos.pasarTurnoEnMano();
        Jugador jugador = manejadorDeTurnos.jugadorTurnoEnMano();
        jugador.sumaPuntaje(1);//no se acepta envido entonces el otro jugador suma 1
    }
}

