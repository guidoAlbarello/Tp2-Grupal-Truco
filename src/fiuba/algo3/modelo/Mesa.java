package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class Mesa {
    private final int puntajeMaximo = 30;
    private JugadorEnJuego jugador2;
    private JugadorEnJuego jugador1;

    private ManejadorDeTurnos manejadorDeTurnos;

    public Mesa(){
        jugador1 = new JugadorEnJuego("jugador1");
        jugador2 = new JugadorEnJuego("jugador2");

        manejadorDeTurnos = new ManejadorDeTurnos(jugador1,jugador2);
    }
    public JugadorEnJuego getJugador1() {
        return jugador1;
    }
    public JugadorEnJuego getJugador2() {
        return jugador2;
    }
//ptueba
    public void comenzarJuego(){
        while (jugador1.puntaje()< puntajeMaximo || jugador2.puntaje()<puntajeMaximo){
            this.comenzarRonda();
        }
    }
    public void comenzarRonda() {
        this.jugador1.setManosGanadas(0);
        this.jugador2.setManosGanadas(0);
        while (jugador1.puntaje()== 0 && jugador2.puntaje()==0){
            comenzarMano();
        }
    }

    public  void comenzarMano() {
        JugadorEnJuego jugador = manejadorDeTurnos.darJugadorQueInicia();
        Jugada respuesta = jugador.jugar();
        this.resolverJugada(respuesta);
    }
    public void resolverCartaJugada(CartaJugada cartaJugada){
        JugadorEnJuego jugador = manejadorDeTurnos.jugadorContrario(cartaJugada.jugadorQueLaJugo);
        CartaJugada cartaRespuesta = jugador.responderCarta(cartaJugada);
        JugadorEnJuego jugadorGanador = this.compararCartas(cartaJugada,cartaRespuesta);
        jugadorGanador.incrementarManosGanadas();//suma 1 por q gano la manosGanadas  solo con cartas

    }

    private JugadorEnJuego compararCartas(CartaJugada cartaJugada, CartaJugada cartaRespuesta) {
        return jugador1;
    }

    public void resolverEnvido(EnvidoCantado envido) {
        JugadorEnJuego jugador = manejadorDeTurnos.jugadorContrario(envido.jugadorQueCanto());
        Jugada respuesta = jugador.responderEnvio();
        this.resolverJugada(respuesta);

    }

    public void resolverJugada(Jugada respuesta) {
        respuesta.resolverEnMesa(this);
    }

    public void resolverAceptaEnvido(AceptaEnvido aceptaEnvido) {
        JugadorEnJuego jugadorQueCantoEnvido = manejadorDeTurnos.jugadorContrario(aceptaEnvido.jugadorQueCanto());
        JugadorEnJuego jugadorGanador = this.compararTantos(jugador1,jugador2);
        jugadorGanador.sumaPuntaje(2);// se suman 2 puntos por acepto envido

    }

    public void resolverRealEnvido(RealEnvido realEnvido){
        JugadorEnJuego jugador = manejadorDeTurnos.jugadorContrario(realEnvido.jugadorQueCanto());
        Jugada respuesta = jugador.responderRealEnvido();
        this.resolverJugada(respuesta);
    }

    public void resolverAceptaRealEnvido(AceptaRealEnvido aceptaRealEnvido) {
        JugadorEnJuego jugador = manejadorDeTurnos.jugadorContrario(aceptaRealEnvido.jugadorQueCanto());
        int tantos1 = jugador.calcularEnvido();
        int tantos2 = aceptaRealEnvido.jugadorQueCanto().calcularEnvido();
        JugadorEnJuego jugadorGanador = this.compararTantos(jugador,aceptaRealEnvido.jugadorQueCanto());
        jugadorGanador.sumaPuntaje(4);// se suman 4 puntos por acepto real envido
    }
    private JugadorEnJuego compararTantos(JugadorEnJuego jugador1, JugadorEnJuego jugador2) {
        if (jugador1.calcularEnvido()>= jugador2.calcularEnvido())
            return jugador1;
        else
            return jugador2;
    }


}

