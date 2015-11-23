package fiuba.algo3.manejoDeJugadores;

import fiuba.algo3.Juego;
import fiuba.algo3.Mesa;

/**
 * Created by Fechee on 18/11/2015.
 */
public class ManejadorDeTurnos {

    private NodoJugador jugadorMano;
    private NodoJugador turnoActual;
    private ListaJugadores jugadores;


    private int manoActual;                                     // esto lo pongo aca, quizas haya que moverlo a mesa o donde quieran
    private int rondaActual;                                    // esto lo pongo aca, quizas haya que moverlo a mesa o donde quieran
    private int vecesQueSePasoElTurno;                          // esto lo pongo aca, quizas haya que moverlo a mesa o donde quieran

    private NodoJugador jugadorCanto;


    private Juego juego;
    private Mesa mesa;


    public ManejadorDeTurnos(ListaJugadores listaDeJugadores, Juego juego) {
        this.jugadorMano = listaDeJugadores.getPrimero();
        this.turnoActual = listaDeJugadores.getPrimero();
        this.jugadorCanto = this.turnoActual;
        this.manoActual = 1;
        this.rondaActual=+1;
        this.jugadores = listaDeJugadores;
        this.vecesQueSePasoElTurno=0;
        try {                               //HAGO ESTO PARA PASAR LOS TESTS, Y PODER MOSTRAR EL FUNCIONAMIENTO PARCIAL DE MANEJADOR DE TURNOS
            this.juego = juego;
            this.mesa = juego.mesaDelJuego();
        }catch (NullPointerException e){
            this.juego=null;
            this.mesa=null;
        }
    }

    public void pasarMano(){                                                        // ASI COMO ESTA MODELADO ESTO TENDRIA QUE SER LLAMADO CUANDO SE TERMINE LA RONDA
        this.jugadorMano = this.jugadorMano.getSiguiente();                           //SI LE QUIEREN SACAR ESTA FUNCIONALIDAD CAMBIAR DE ACA PARA ABAJO (EN ESTE METODO)
        this.turnoActual = this.jugadorMano;
        this.rondaActual+=1;
        this.manoActual=1;
        this.vecesQueSePasoElTurno=0;
    }


    public NodoJugador getNodoMano() {        return this.jugadorMano;    }

    public Jugador getJugadorQueEsMano() {return this.jugadorMano.getJugador();}

    public NodoJugador getNodoJugadorConTurnoActual(){
        return this.turnoActual;
    }

    public Jugador getJugadorConTurnoActual() {     return this.turnoActual.getJugador();    }

    public Jugador getJugadorConTurnoCanto() { return this.jugadorCanto.getJugador(); }

    public Integer getNumeroDeManoActual(){    return this.manoActual;   }

    public void pasarTurnoCantos(){//c Anthony : cre este metodo por q no me  sirve de que pasa el turno pase el tunro y a la vez calcule cosas
        this.jugadorCanto = this.jugadorCanto.getSiguiente();
    }


    public void pasarTurnoCartas(){
        this.turnoActual = this.turnoActual.getSiguiente();
        this.vecesQueSePasoElTurno+=1;
        if (this.vecesQueSePasoElTurno == this.jugadores.getTamanio()){ //SI TERMINO LA MANO
            this.manoActual+=1;
            this.vecesQueSePasoElTurno=0;
            Equipo ganador = this.mesa.ganadorDeManoUsandoIndicesDeCartas().getEquipo();
            ganador.ganarMano();
            this.mesa.limpiarCartasEnMesa();
            if (this.manoActual==4 | this.jugadores.hayGanador()){                                    //SI TERMINO LA RONDA
                this.jugadores.getEquipoGanador().sumarPuntos(this.juego.getPuntosDeTruco());                                      //se suman puntosDeEstado depende del estado HARCODIE Y PUSE 1
                this.jugadores.reiniciarManosGanadasDeTodosLosJugadores();
                this.juego.repartirCartasAJugadores();
                this.pasarMano();
            }
        }

    }



    public void volverTurnoCanto(){   this.jugadorCanto = this.jugadorCanto.getAnterior();   }

    public void setJugadorTurnoActual(NodoJugador jugadorConTurnoActual) {
        this.turnoActual = jugadorConTurnoActual;
    }

    public Integer getRondaActual(){ return this.rondaActual; }

    public ListaJugadores getJugadores() {       return this.jugadores;    }

    public int getManoActual(){ return this.manoActual; }


    public Jugador getJugadorSiguienteAlTurnoActual(){
        return this.getNodoJugadorConTurnoActual().getSiguiente().getJugador();
    }


    public Jugador getJugadorAnteriorAlTurnoActual(){
        return this.getNodoJugadorConTurnoActual().getAnterior().getJugador();
    }


}
