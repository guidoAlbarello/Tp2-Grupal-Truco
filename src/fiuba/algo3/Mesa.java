package fiuba.algo3;

import fiuba.algo3.ModeladoDeCarta.Carta;
import fiuba.algo3.ModeladoDeCarta.Palo;
import fiuba.algo3.ModeladoDeCarta.PaloCopa;
import fiuba.algo3.manejoDeJugadores.Equipo;
import fiuba.algo3.manejoDeJugadores.Jugador;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by anthony on 19/11/2015.
 */
public class Mesa {
    private LinkedList<CartaJugada> listaDeCartasJugadas;
    private CartaJugada ganadora, segunda;
    private Jugador emparde;

    public Mesa(){
        this.listaDeCartasJugadas = new LinkedList<>();
        this.emparde = new Jugador("emparde");
        this.emparde.setEquipo(new Equipo("emparde"));
        this.ganadora = new CartaJugada(new Carta(4, new PaloCopa()),this.emparde);
        this.segunda = this.ganadora;
    }

    public LinkedList<CartaJugada> listaDeCartasJugadas() {
        return this.listaDeCartasJugadas;
    }

    public void agregarCartaALsitaDeCartasJugadas(CartaJugada cartaJugada) {
        this.listaDeCartasJugadas.add(cartaJugada);
        compararConLasDeMesa(cartaJugada);
    }

    private void compararConLasDeMesa(CartaJugada cartaJugada) {
        int poderTirada, poderMayorActual;
        poderTirada = cartaJugada.getCarta().getValorDePoder();
        poderMayorActual = ganadora.getCarta().getValorDePoder();
        if (poderTirada >= poderMayorActual){                                                       //ESTO SUENA MAL CUANDO LOS 4 JUGADORES TIREN LOS 4 CUATROS....
            if (poderTirada==poderMayorActual){
                this.segunda=cartaJugada;
            } else this.ganadora=cartaJugada;
        }
    }

/*
    public Jugador ganadorDeMano(){
        Iterator<CartaJugada> iterador = this.listaDeCartasJugadas.iterator();
        CartaJugada cartaGanadora = iterador.next();
        while ( iterador.hasNext()){
            CartaJugada unaCartaJugada = iterador.next();
            if (cartaGanadora.getCarta().getValorDePoder() < unaCartaJugada.getCarta().getValorDePoder()) {
                cartaGanadora = unaCartaJugada;
            }
        }
        return cartaGanadora.getJugador();
    }
*/



    //PRE: LA MANO TIENE QUE ESTAR TERMINADA
    //POST: DEVUELVE EL JUGADOR QUE GANO LA MANO
    public Jugador ganadorDeManoUsandoIndicesDeCartas(){
        Jugador ganadorDeMano;
        if (ganadora.getCarta().getValorDePoder() == segunda.getCarta().getValorDePoder()) {
            ganadorDeMano = this.emparde;
        }else ganadorDeMano = this.ganadora.getJugador();

        this.ganadora = new CartaJugada(new Carta(4, new PaloCopa()),null);

        return ganadorDeMano;
    }


    public void limpiarCartasEnMesa() {
        this.listaDeCartasJugadas.clear();
        this.ganadora = new CartaJugada(new Carta(4, new PaloCopa()),null);
    }


    public Jugador getEmparde(){return this.emparde;}
}
