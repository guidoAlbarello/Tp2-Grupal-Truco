package fiuba.algo3.modelo;

import fiuba.algo3.modelo.JugadasOpcional.CartaJugada;
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

    public JugadorEnRonda compararTantos(JugadorEnRonda jugadorEnRonda1, JugadorEnRonda jugadorEnRonda2) {
        if (jugadorEnRonda1.getJugador().calcularEnvido() == jugadorEnRonda2.getJugador().calcularEnvido()){
            return manejadorDeTurnos.getJugadorMano();
        }
        if (jugadorEnRonda1.getJugador().calcularEnvido()> jugadorEnRonda2.getJugador().calcularEnvido())
            return jugadorEnRonda1;
        else
            return jugadorEnRonda2;
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
        Integer cartasEnManoDelJugadorActual = this.manejadorDeTurnos.getJugadorTurnoEnMano().getJugador().getMano().getCartasRestantesEnMano();
        this.manejadorDeTurnos.pasarTurnoEnMano();
        Integer cartasEnManoDelOtroJugador = this.manejadorDeTurnos.getJugadorTurnoEnMano().getJugador().getMano().getCartasRestantesEnMano();
        termino = (cartasEnManoDelJugadorActual==0 & cartasEnManoDelOtroJugador==0);
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

    public void agregarCartaEnMesa(CartaJugada unaCartaJugada) {
        this.cartasEnMesa.add(unaCartaJugada);
    }

    public LinkedList<CartaJugada> getCartasEnMesa() {
        return this.cartasEnMesa;
    }

    public void limpiarMesa() {
        this.cartasEnMesa.clear();
    }
}
