package fiuba.algo3.modelo;

import fiuba.algo3.modelo.jugadasPosibles.*;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeTurnos;

import java.util.LinkedList;

/**
 * Created by anthony on 10/11/2015.
 */
public class Mesa {
    private final int PUNTAJE_MAXIMO = 30;
    private JugadorEnRonda jugadorEnRonda1;
    private JugadorEnRonda jugadorEnRonda2;
    private ManejadorDeTurnos manejadorDeTurnos;
    private LinkedList<CartaJugada> cartasEnMesa;
    private int puntosEnJuegoDeLaRonda;

    public Mesa(JugadorEnRonda jugadorEnRonda1, JugadorEnRonda jugadorEnRonda2, ManejadorDeTurnos manejadorDeTurnos) {
        this.puntosEnJuegoDeLaRonda = 1;
        this.jugadorEnRonda1 = jugadorEnRonda1;
        this.jugadorEnRonda2 = jugadorEnRonda2;
        this.manejadorDeTurnos = manejadorDeTurnos;
        this.cartasEnMesa = new LinkedList<>();
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
        JugadorEnRonda jugadorGanador = this.compararTantos(jugadorEnRonda1, jugadorEnRonda2);
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
            cartasEnMesa.add(cartaJugada);
        if (cartasEnMesa.size() == 2){
            JugadorEnRonda jugadorGanaMano = this.compararCartas(); //---------ACA tambien cambie cartasEnMesa que recibe compararCartas
            jugadorGanaMano.aumentarManosGanadas();
            cartasEnMesa.clear();
        }
            manejadorDeTurnos.pasarTurnoEnMano();//paso al siguiente jugador por q entest caso coomo son 2
            Jugador jugador = manejadorDeTurnos.getJugadorTurnoEnMano().getJugador();
            Jugada jugada = jugador.hacerJugada();
            this.resolverJugada(jugada);
    }

    public JugadorEnRonda compararCartas() {    /////------SAQUE CARTASENMESA QUE RECIBIA, PORQUE ES UN ATRIBUTO DE LA CLASE!!!  LO HICE PUBLICO PARA PODER TESTEAR
        Carta carta0 = this.cartasEnMesa.get(0).carta;
        Carta carta1 = this.cartasEnMesa.get(1).carta;
        if (carta0.getValorDePoder() > carta1.getValorDePoder())
            return this.cartasEnMesa.get(0).jugadorQueCanto();
        else
            return this.cartasEnMesa.get(1).jugadorQueCanto();
    }






    //Agrego metodos para probar tests

    public JugadorEnRonda getGanadorDeRonda(){
        if (jugadorEnRonda1.getManosGanadas()>jugadorEnRonda2.getManosGanadas()){
            return jugadorEnRonda1;
        }else{return jugadorEnRonda2;}
    }


    public boolean terminoLaRonda(){   ///------    N O   C O N T E M P L A   3   E M P A R D E S!!   Y SOLO FUNCIONA PARA 2 JUGADORES
        boolean termino;
        this.manejadorDeTurnos.pasarTurnoEnMano();
        termino = this.manejadorDeTurnos.getJugadorTurnoEnMano().getJugador().getMano().getCartasRestantesEnMano()==0;
        if (!termino) {
            this.manejadorDeTurnos.pasarTurnoEnMano(); //vuelvo al jugador que tenia el turno original
            return false;
        }
        return true;
    }


    public void setPuntosEnJuego(Integer puntosAgregare){
        this.puntosEnJuegoDeLaRonda=puntosAgregare;
    }

    public Integer getPuntosEnJuego(){
        return this.puntosEnJuegoDeLaRonda;
    }

    public void resetearPuntosEnJuego(){
        this.puntosEnJuegoDeLaRonda=0;
    }

    public boolean terminoLaMano(){
        return (this.cartasEnMesa.size()%2==0);
    }


    public void seJuegaUnaCarta(Integer indiceDeLaCarta){
        JugadorEnRonda jugadorConTurnoActual = this.manejadorDeTurnos.getJugadorTurnoEnMano();
        jugadorConTurnoActual.getJugador().getMano().jugarCarta(indiceDeLaCarta);
        CartaJugada cartaQueSeJugo = new CartaJugada(jugadorConTurnoActual,jugadorConTurnoActual.getJugador().getMano().getCartaJugada());
        this.cartasEnMesa.add(cartaQueSeJugo);
    }

}
