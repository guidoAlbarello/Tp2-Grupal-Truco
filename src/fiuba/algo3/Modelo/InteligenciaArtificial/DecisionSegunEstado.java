package fiuba.algo3.Modelo.InteligenciaArtificial;

import fiuba.algo3.Modelo.Excepciones.NoHayFlorEnLaManoError;
import fiuba.algo3.Modelo.Juego.Mesa;

import java.util.Random;

/**
 * Created by Krion on 30/11/2015.
 */
public class DecisionSegunEstado {
        private JugadorArtificial unJugadorMaquina;
        private Mesa mesaDeJuego;
        private int factorDeAzar;
        private int factorDeAzar2;

        public DecisionSegunEstado(JugadorArtificial unJugador, Mesa unaMesa){
                this.unJugadorMaquina = unJugador;
                this.mesaDeJuego = unaMesa;
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt(100) + 1;
                this.factorDeAzar2 = rand.nextInt(200) + 1;
        }

        public void elegirJugadaEstadoTruco(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiCantaEnvido())
                        unJugadorMaquina.envido();
                else if(elegirSiCantaReTruco())
                        unJugadorMaquina.retruco();
                else if (elegirSiQuiereTruco())
                        unJugadorMaquina.quiero();
                else
                        unJugadorMaquina.noQuiero();
        }

        public void elegirJugadaEstadoRetruco() {
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiCantaValeCuatro())
                        unJugadorMaquina.valeCuatro();
                else if(elegirSiQuiereReTruco())
                        unJugadorMaquina.quiero();
                else
                        unJugadorMaquina.noQuiero();
        }

        public void elegirJugadaEstadoValeCuatro() {
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiQuiereValeCuatro())
                        unJugadorMaquina.quiero();
                else
                        unJugadorMaquina.noQuiero();
        }

        public void elegirJugadaEstadoEnvido(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiCantaRealEnvido())
                        unJugadorMaquina.realEnvido();
                else if(elegirSiCantaEnvidoEnvido())
                        unJugadorMaquina.envido();
                else if(elegirSiQuiereEnvido())
                        unJugadorMaquina.quiero();
                else
                        unJugadorMaquina.noQuiero();
        }

        public void elegirJugadaEstadoRealEnvido() {
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if (elegirSiCantaFaltaEnvido())
                        unJugadorMaquina.faltaEnvido();
                else if (elegirSiQuiereRealEnvido())
                        unJugadorMaquina.quiero();
                else
                        unJugadorMaquina.noQuiero();
        }

        public void elegirJugadaEstadoFaltaEnvido(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiQuiereFaltaEnvido())
                        unJugadorMaquina.quiero();
                else
                        unJugadorMaquina.noQuiero();
        }

        public void elegirJugadaEstadoEnvidoEnvido(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiCantaRealEnvido())
                        unJugadorMaquina.realEnvido();
                else if(this.elegirSiCantaEnvido())
                        unJugadorMaquina.quiero();
                else
                        unJugadorMaquina.noQuiero();
        }

        public void elegirJugadaEstadoFlor(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiQuiereEnvido())
                    unJugadorMaquina.quiero();
                else
                    unJugadorMaquina.noQuiero();
        }

        public void elegirJugadaEstadoJuegoConFlor(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiCantaFlor())
                        unJugadorMaquina.flor();
                        //unJugadorMaquina.elegirCarta(factorDeAzar);
                else if(this.elegirSiCantaEnvido())
                        unJugadorMaquina.envido();
                        //unJugadorMaquina.elegirCarta(factorDeAzar);
                else
                        unJugadorMaquina.elegirCarta(factorDeAzar);
        }

        public void elegirJugadaEstadoJuegoSinFlor() {
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(this.elegirSiCantaEnvido())
                        unJugadorMaquina.envido();
                else
                        unJugadorMaquina.elegirCarta(factorDeAzar);;
        }

        public void elegirJugadaEstadoRetrucoAceptado(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiCantaValeCuatro())
                        unJugadorMaquina.valeCuatro();
                else
                        unJugadorMaquina.elegirCarta(factorDeAzar);;
        }

        public void elegirJugadaEstadoTrucoAceptado(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                if(elegirSiCantarReTruco())
                        unJugadorMaquina.retruco();
                else
                        unJugadorMaquina.elegirCarta(factorDeAzar);;
        }

        public void elegirJugadaEstadoValeCuatroAceptado(){
                Random rand = new Random();
                this.factorDeAzar = rand.nextInt((100) + 1);
                unJugadorMaquina.elegirCarta(factorDeAzar);;
        }

        public void elegirJugadaEstadoSinEnvido() {}

        public void elegirJugadaEstadoTrucoSinEnvido() {}

        private boolean elegirSiCantarReTruco() {
                return ((unJugadorMaquina.getEquipo().getManosGanadas() >=1 && factorDeAzar2EstaEnElRangoDe(140, 200)) || factorDeAzarEstaEnElRangoDe(78, 100));
        }

        private boolean elegirSiCantaFlor() {
                boolean resultadoCantarFlor;
                try{
                        unJugadorMaquina.getMano().calcularFlor();
                        resultadoCantarFlor = true;
                } catch(NoHayFlorEnLaManoError e){
                        resultadoCantarFlor = false;
                }
                return (resultadoCantarFlor && factorDeAzar2EstaEnElRangoDe(50, 100));
        }

        private boolean elegirSiQuiereEnvido() {
                return ((unJugadorMaquina.getMano().obtenerEnvido().getValorEnvido() >= 23 && factorDeAzar2EstaEnElRangoDe(80, 200)) || factorDeAzarEstaEnElRangoDe(80,100));
        }

        private boolean elegirSiCantaRealEnvido() {
                return ((unJugadorMaquina.getMano().obtenerEnvido().getValorEnvido() >= 29 && factorDeAzar2EstaEnElRangoDe(70, 200)) || factorDeAzarEstaEnElRangoDe(85,100));
        }

        private boolean elegirSiQuiereFaltaEnvido() {
                return ((unJugadorMaquina.getMano().obtenerEnvido().getValorEnvido() >= 32 && factorDeAzar2EstaEnElRangoDe(105, 200) ) || factorDeAzarEstaEnElRangoDe(97,100));
        }
        
        private boolean elegirSiQuiereRealEnvido() {
                return ((unJugadorMaquina.getMano().obtenerEnvido().getValorEnvido() >= 29 && factorDeAzar2EstaEnElRangoDe(90, 200)) || factorDeAzarEstaEnElRangoDe(85,100));
        }

        private boolean elegirSiCantaFaltaEnvido() {
                return ((unJugadorMaquina.getMano().obtenerEnvido().getValorEnvido() >= 32 && factorDeAzar2EstaEnElRangoDe(90,200)) || factorDeAzarEstaEnElRangoDe(97,100));
        }

        private boolean elegirSiCantaEnvidoEnvido() {
                return ((unJugadorMaquina.getMano().obtenerEnvido().getValorEnvido() >= 27 && factorDeAzar2EstaEnElRangoDe(110,200)) || factorDeAzarEstaEnElRangoDe(83,100));
        }

        private boolean elegirSiQuiereValeCuatro() {
                return ((unJugadorMaquina.getEquipo().getManosGanadas() >=1 && factorDeAzar2EstaEnElRangoDe(80,200)) || factorDeAzarEstaEnElRangoDe(80,100));
        }

        private boolean elegirSiQuiereReTruco() {
                return ((unJugadorMaquina.getEquipo().getManosGanadas() >=1 && factorDeAzar2EstaEnElRangoDe(110,200)) || factorDeAzarEstaEnElRangoDe(75,100));
        }

        private boolean elegirSiCantaValeCuatro() {
                return ((unJugadorMaquina.getEquipo().getManosGanadas() >=1 && factorDeAzar2EstaEnElRangoDe(110,200)) || factorDeAzarEstaEnElRangoDe(72,100));
        }

        private boolean elegirSiQuiereTruco() {
                return ((unJugadorMaquina.getEquipo().getManosGanadas() >=1 && factorDeAzar2EstaEnElRangoDe(100,200)) || factorDeAzarEstaEnElRangoDe(70,100));
        }

        private boolean elegirSiCantaReTruco() {
                return ((unJugadorMaquina.getEquipo().getManosGanadas() >=1 && factorDeAzar2EstaEnElRangoDe(110,200)) || factorDeAzarEstaEnElRangoDe(80,100));
        }

        private boolean elegirSiCantaEnvido() {
                return ((unJugadorMaquina.getMano().obtenerEnvido().getValorEnvido() >= 24 && factorDeAzar2EstaEnElRangoDe(115,200)) || factorDeAzarEstaEnElRangoDe(65,100));
        }

        public boolean factorDeAzarEstaEnElRangoDe(final int MINIMO, final int MAXIMO){
                if(factorDeAzar >= MINIMO && factorDeAzar <= MAXIMO)
                        return true;
                else
                        return false;
        }

        public boolean factorDeAzar2EstaEnElRangoDe(final int MINIMO, final int MAXIMO){
                if(factorDeAzar2 >= MINIMO && factorDeAzar2 <= MAXIMO)
                        return true;
                else
                        return false;
        }
}
