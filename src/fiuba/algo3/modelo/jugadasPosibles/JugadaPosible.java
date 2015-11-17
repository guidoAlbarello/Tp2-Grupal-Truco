package fiuba.algo3.modelo.jugadasPosibles;

import fiuba.algo3.modelo.JugadasOpcional.Jugada;

import java.util.List;

/**
 * Created by Krion on 15/11/2015.
 */
public class JugadaPosible {
   private Jugada jugadaHecha;
   public JugadaPosible(Jugada unaJugada){
      this.jugadaHecha = unaJugada;
   }

   public List<Class> getJugadasPosibles(){
      return this.jugadaHecha.getJugadasPosibles();
   }
}
