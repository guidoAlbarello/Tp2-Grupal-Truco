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
        manejadorDeTurnos = new ManejadorDeTurnos();
    }
    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }


    public void comenzarJuego(){
        while (manejadorDePuntaje.getPuntaje(jugador1.getNombre()) < PUNTAJE_MAXIMO || manejadorDePuntaje.getPuntaje(jugador2.getNombre()) < PUNTAJE_MAXIMO){
            this.comenzarRonda();
        }
    }
    public void comenzarRonda() {
        this.manejadorDePuntaje.setManosGanadas(jugador1.getNombre(),0);
        this.manejadorDePuntaje.setManosGanadas(jugador2.getNombre(),0);
        while (manejadorDePuntaje.getPuntaje(jugador1.getNombre())== 0 && manejadorDePuntaje.getPuntaje(jugador2.getNombre())==0){
            comenzarMano();
        }
    }

    public  void comenzarMano() {
        Jugador jugador = manejadorDeTurnos.darJugadorQueInicia();
        Jugada respuesta = jugador.hacerJugada();
        this.resolverJugada(respuesta);
    }

    public void resolverCartaJugada(CartaJugada cartaJugada){
        Jugador jugador = manejadorDeTurnos.jugadorContrario(cartaJugada.jugadorQueLaJugo);
        CartaJugada cartaRespuesta = jugador.responderCarta(cartaJugada);
        Jugador jugadorGanador = this.compararCartas(cartaJugada,cartaRespuesta);
        jugadorGanador.incrementarManosGanadas();//suma 1 por q gano la manosGanadas  solo con cartas

    }

    private Jugador compararCartas(CartaJugada cartaJugada, CartaJugada cartaRespuesta) {
        return jugador1;
    }

    public void resolverEnvido(EnvidoCantado envido) {
        Jugador jugador = manejadorDeTurnos.jugadorContrario(envido.jugadorQueCanto());
        Jugada jugadaDelJugador = jugador.responderEnvio();
        this.resolverJugada(respuesta);

    }

    public void resolverJugada(Jugada respuesta) {
        respuesta.resolverEnMesa(this);
    }

    public void resolverAceptaEnvido(AceptaEnvido aceptaEnvido) {
        Jugador jugadorQueCantoEnvido = manejadorDeTurnos.jugadorContrario(aceptaEnvido.jugadorQueCanto());
        Jugador jugadorGanador = this.compararTantos(jugador1,jugador2);
        manejadorDePuntaje.sumaPuntaje(jugadorGanador.getNombre(), 2);// se suman 2 puntos por acepto envido

    }

    public void resolverRealEnvido(RealEnvido realEnvido){
        Jugador jugador = manejadorDeTurnos.jugadorContrario(realEnvido.jugadorQueCanto());
        Jugada respuesta = jugador.responderRealEnvido();
        this.resolverJugada(respuesta);
    }

    public void resolverAceptaRealEnvido(AceptaRealEnvido aceptaRealEnvido) {
        Jugador jugador = manejadorDeTurnos.jugadorContrario(aceptaRealEnvido.jugadorQueCanto());
        int tantos1 = jugador.calcularEnvido();
        int tantos2 = aceptaRealEnvido.jugadorQueCanto().calcularEnvido();
        Jugador jugadorGanador = this.compararTantos(jugador,aceptaRealEnvido.jugadorQueCanto());
        jugadorGanador.sumaPuntaje(4);// se suman 4 puntos por acepto real envido
    }
    private Jugador compararTantos(Jugador jugador1, Jugador jugador2) {
        if (jugador1.calcularEnvido()>= jugador2.calcularEnvido())
            return jugador1;
        else
            return jugador2;
    }


}

