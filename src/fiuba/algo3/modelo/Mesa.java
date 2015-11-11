package fiuba.algo3.modelo;

/**
 * Created by anthony on 10/11/2015.
 */
public class Mesa {
    private JugadorJugando jugador2;
    private JugadorJugando jugador1;

    private ManejadorDeTurnos manejadorDeTurnos;

    public Mesa(){
        jugador1 = new JugadorJugando("jugador1");
        jugador2 = new JugadorJugando("jugador2");

        manejadorDeTurnos = new ManejadorDeTurnos(jugador1,jugador2);
    }
    public JugadorJugando getJugador1() {
        return jugador1;
    }

    public JugadorJugando getJugador2() {
        return jugador2;
    }



    public  void comenzarMano(){
        JugadorJugando jugador = manejadorDeTurnos.darJugadorQueInicia();
        Respuesta respuesta = jugador.jugar();
        this.resolverJugada(respuesta);
    }
    public void resolverCartaJugada(CartaJugada cartaJugada){
        JugadorJugando jugador = manejadorDeTurnos.jugadorContrario(cartaJugada.jugadorQueLaJugo);
        CartaJugada cartaRespuesta = jugador.responderCarta(cartaJugada);
        JugadorJugando jugadorGanador = this.compararCartas(cartaJugada,cartaRespuesta);
        jugadorGanador.incrementarMano();//suma 1 por q gano la mano  solo con cartas

    }

    private JugadorJugando compararCartas(CartaJugada cartaJugada, CartaJugada cartaRespuesta) {
        return jugador1;
    }

    public void resolverEnvido(EnvidoCantado envido) {
        JugadorJugando jugador = manejadorDeTurnos.jugadorContrario(envido.jugadorQueCanto());
        Respuesta respuesta = jugador.responderEnvio();
        this.resolverJugada(respuesta);

    }

    public void resolverJugada(Respuesta respuesta) {
        respuesta.resolverEnMesa(this);
    }

    public void resolverAceptaEnvido(AceptaEnvido aceptaEnvido) {
        JugadorJugando jugadorQueCantoEnvido = manejadorDeTurnos.jugadorContrario(aceptaEnvido.jugadorQueCanto());
        JugadorJugando jugadorGanador = this.compararTantos(jugador1,jugador2);
        jugadorGanador.sumaPuntaje(2);// se suman 2 puntos por acepto envido

    }

    public void resolverRealEnvido(RealEnvido realEnvido){
        JugadorJugando jugador = manejadorDeTurnos.jugadorContrario(realEnvido.jugadorQueCanto());
        Respuesta respuesta = jugador.responderRealEnvido();
        this.resolverJugada(respuesta);
    }

    public void resolverAceptaRealEnvido(AceptaRealEnvido aceptaRealEnvido) {
        JugadorJugando jugador = manejadorDeTurnos.jugadorContrario(aceptaRealEnvido.jugadorQueCanto());
        int tantos1 = jugador.calcularEnvido();
        int tantos2 = aceptaRealEnvido.jugadorQueCanto().calcularEnvido();
        JugadorJugando jugadorGanador = this.compararTantos(jugador,aceptaRealEnvido.jugadorQueCanto());
        jugadorGanador.sumaPuntaje(4);// se suman 4 puntos por acepto real envido
    }
    private JugadorJugando compararTantos(JugadorJugando jugador1, JugadorJugando jugador2) {
        if (jugador1.calcularEnvido()>= jugador2.calcularEnvido())
            return jugador1;
        else
            return jugador2;
    }

    public void comenzarRonda() {
        this.jugador1.setMano(0);
        this.jugador2.setMano(0);
        while (jugador1.puntaje()== 0 && jugador2.puntaje()==0){
            comenzarMano();
        }
    }
}

