package fiuba.algo3.manejoDeJugadores;

import fiuba.algo3.EstadosDeJuego.EstadoJuegoConFlor;
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
    public int vecesQueSePasoElTurno;                          // esto lo pongo aca, quizas haya que moverlo a mesa o donde quieran
    private NodoJugador ultimoQueJugoEnvido;
    private NodoJugador ultimoQueJugoTruco;//agregue par ael tema del truco en 4 configJugadores
    private NodoJugador primeroQueCantoEnvido;
    private NodoJugador primeroQueCantoTruco;
    private Juego juego;
    private Mesa mesa;

    public ManejadorDeTurnos(ListaJugadores listaDeJugadores, Juego juego) {
        this.jugadorMano = listaDeJugadores.getPrimero();
        this.turnoActual = listaDeJugadores.getPrimero();
        //this.ultimoQueJugoEnvido = this.turnoActual;
        this.manoActual = 1;
        this.rondaActual=+1;
        this.jugadores = listaDeJugadores;
        this.vecesQueSePasoElTurno=0;
        try {                               //HAGO ESTO PARA PASAR LOS TESTS, Y PODER MOSTRAR EL FUNCIONAMIENTO PARCIAL DE MANEJADOR DE TURNOS
            this.juego = juego;
            this.mesa = juego.getMesaDelJuego();
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

    public Integer getNumeroDeManoActual(){    return this.manoActual;   }

    public void pasarTurnoActual(){//c Anthony : cre este metodo por q no me  sirve de que pasa el turno pase el tunro y a la vez calcule cosas
        this.turnoActual = this.turnoActual.getSiguiente();
    }

    public void reiniciarRonda(){
        //SI TERMINO LA RONDA
        this.jugadores.reiniciarManosGanadasDeTodosLosJugadores();
        this.pasarMano();
        this.jugadores.reiniciarManos();
        this.juego.setEstadoDeJuego(new EstadoJuegoConFlor(juego));
        this.juego.repartirCartasAJugadores();
        this.juego.inicializarPuntosParaRonda();
    }

    public void reiniciarMano(){
        this.manoActual+=1;
        this.vecesQueSePasoElTurno=0;
        Jugador ganador = this.mesa.ganadorDeManoUsandoIndicesDeCartas();
        ganador.getEquipo().ganarMano();
        if (!ganador.getNombre().equals("emparde")){
            this.setJugadorTurnoActual(this.jugadores.buscarNodoJugadorPorJugador(ganador)); }
        this.mesa.limpiarCartasEnMesa();
    }

    public void pasarTurnoCartas(){
        this.turnoActual = this.turnoActual.getSiguiente();
        this.vecesQueSePasoElTurno+=1;
        if (this.vecesQueSePasoElTurno == this.jugadores.getTamanio()){ //SI TERMINO LA MANO
            this.manoActual+=1;
            this.vecesQueSePasoElTurno=0;
            Jugador ganador = this.mesa.ganadorDeManoUsandoIndicesDeCartas();
            ganador.getEquipo().ganarMano();
            if (!ganador.getNombre().equals("emparde")){
                this.setJugadorTurnoActual(this.jugadores.buscarNodoJugadorPorJugador(ganador)); }
            this.mesa.limpiarCartasEnMesa();
            if (this.manoActual==4 | this.jugadores.hayGanador(this.mesa.getEmparde())){
                this.jugadores.getEquipoGanador().sumarPuntos(this.juego.getPuntosDeTruco());//se suman puntosSiSeQuiere depende del estado HARCODIE Y PUSE 1
                this.reiniciarRonda();
            }
        }
    }

    public void setJugadorTurnoActual(NodoJugador jugadorConTurnoActual) {
        this.turnoActual = jugadorConTurnoActual;
    }

    public Integer getRondaActual(){ return this.rondaActual; }

    public ListaJugadores getJugadores() {       return this.jugadores;    }

    public Jugador getJugadorSiguienteAlTurnoActual(){
        return this.getNodoJugadorConTurnoActual().getSiguiente().getJugador();
    }

    public Jugador getJugadorAnteriorAlTurnoActual(){
        return this.getNodoJugadorConTurnoActual().getAnterior().getJugador();
    }

    public void setUltimoQueJugoTruco(Jugador jugadorQuecantoTruco) {
        this.ultimoQueJugoTruco = jugadores.buscarNodoJugadorPorJugador(jugadorQuecantoTruco);
    }

    public NodoJugador getUltimoQueJugoTruco() {
        return ultimoQueJugoTruco;
    }

    public void setUltimoQueJugoEnvido(Jugador jugadorQuecantoEnvido) {
        this.ultimoQueJugoEnvido = jugadores.buscarNodoJugadorPorJugador(jugadorQuecantoEnvido);
    }

    public NodoJugador getJugadorQueCantoEnvido() {return ultimoQueJugoEnvido;}

    public void setPrimeroQueCantoEnvido(Jugador primeroQueCantoEnvido){ this.primeroQueCantoEnvido = jugadores.buscarNodoJugadorPorJugador(primeroQueCantoEnvido);}

    public NodoJugador getPrimeroQueCantoEnvido(){return primeroQueCantoEnvido;}

    public void setPrimeroQueCantoTruco(Jugador primeroQueCantoTruco){ this.primeroQueCantoTruco = jugadores.buscarNodoJugadorPorJugador(primeroQueCantoTruco);}

    public NodoJugador getPrimeroQueCantoTruco(){return primeroQueCantoTruco;}
    public int getManoActual(){
        return this.manoActual;
    }


    public int getPosicionDelJugadorConTurnoActual(){return this.getNodoJugadorConTurnoActual().getPosicion();}
}


