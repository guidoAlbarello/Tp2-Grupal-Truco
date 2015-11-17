package fiuba.algo3.modelo.jugadasPosibles;

import fiuba.algo3.modelo.JugadasOpcional.Jugada;
import fiuba.algo3.modelo.excepciones.NoExisteLaJugadaError;
import fiuba.algo3.modelo.manejadoresDeSituaciones.ManejadorDeJugadas;

import java.util.List;

/**
 * Created by Krion on 15/11/2015.
 */
public class JugadaPosible {
   private Jugada jugadaHecha;
   private ManejadorDeJugadas manejadorDeJugadas;
   private int valorDeJugada;

   public JugadaPosible(Jugada unaJugada, ManejadorDeJugadas manejadorDeJugadas){
      this.valorDeJugada = unaJugada.getValorDeJugada();
      this.jugadaHecha = unaJugada;
      this.manejadorDeJugadas = manejadorDeJugadas;
   }

   public List<Class> getJugadasPosibles(){
      return this.jugadaHecha.getJugadasPosibles();
   }

   public boolean esUnaJugadaValida(Jugada unaJugada) {
      return this.jugadaHecha.esUnaJugadaValida(unaJugada);
   }

   public void setNuevaJugada(Jugada unaJugada){
      if(this.esUnaJugadaValida(unaJugada)){
         this.jugadaHecha = unaJugada;
         this.valorDeJugada += unaJugada.getValorDeJugada();
         this.jugadaHecha.setValorDeJugada(valorDeJugada);
      }
      else
         throw new NoExisteLaJugadaError();
   }

   public void resolverJugada() {
      this.manejadorDeJugadas.resolverJugada(this.jugadaHecha);
   }
}
