package fiuba.algo3.modelo.jugadasPosibles;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.NoExisteLaJugadaError;
import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import fiuba.algo3.modelo.jugadasPermitidas.CartaJugada;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.jugadasPermitidas.peticiones.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Krion on 15/11/2015.
 */
public class JugadaDePeticion extends JugadaPosible {
    private List<String> jugadasPosibles;
    private SeJuegaConFlor seJuegaConFlor;

    public JugadaDePeticion(SeJuegaConFlor seJuegaConFlor){
        this.jugadasPosibles = new ArrayList<>();
        this.seJuegaConFlor = seJuegaConFlor;
        this.jugadasPosibles.add(CartaJugada.class.getName());
        this.jugadasPosibles.add(EnvidoCantado.class.getName());
        this.jugadasPosibles.add(FaltaEnvidoCantado.class.getName());
        this.jugadasPosibles.add(RealEnvidoCantado.class.getName());
        this.jugadasPosibles.add(ReTrucoCantado.class.getName());
        this.jugadasPosibles.add(TrucoCantado.class.getName());
        this.jugadasPosibles.add(ValeCuatroCantado.class.getName());
        try{
            this.seJuegaConFlor.getSiHayJugadaFlor().getClass().getName();
        } catch (NoSeEstaJugandoConFlorError e){}
        catch (NullPointerException e){
            this.jugadasPosibles.add(FlorCantada.class.getName());
        }
    }
    @Override
    public List<String> getJugadasPosibles() {
        return jugadasPosibles;
    }

    public int compararNombresJugadas(String unaNuevaJugada){
        Iterator<String> iteradorJugadasPosibles = this.jugadasPosibles.iterator();
        int posicionDeJugada = -1;
        int i = 0;
        try {
            while (iteradorJugadasPosibles.hasNext() && posicionDeJugada < 0) {
                String unNombreDeJugada = iteradorJugadasPosibles.next();
                String nombreDeJugadaSinDireccionDePaquete = unNombreDeJugada.substring(unNombreDeJugada.lastIndexOf('.') + 1);
                if (nombreDeJugadaSinDireccionDePaquete.equals(unaNuevaJugada))
                    posicionDeJugada = i;
                i++;
            }
        } catch (Exception e){
            throw new NoSeEstaJugandoConFlorError();
        }
        if(unaNuevaJugada.equals("FlorCantada") && posicionDeJugada == -1)
            throw new NoSeEstaJugandoConFlorError();
        return posicionDeJugada;
    }

    protected Object crearClase(String unaJugadaNueva, Jugador unJugador) {
        Object nuevoObjeto = null;
        int posicionDeJugadaEnLista = this.compararNombresJugadas(unaJugadaNueva);
        if(posicionDeJugadaEnLista  > 0){
            Class definicionDeClase = null;
            try {
                definicionDeClase = Class.forName(this.jugadasPosibles.get(posicionDeJugadaEnLista));
            } catch (ClassNotFoundException e) {
                throw new NoExisteLaJugadaError();
            }
            try {
                try {
                    nuevoObjeto = definicionDeClase.getConstructor(Jugador.class).newInstance(unJugador);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else{
            throw new NoExisteLaJugadaError();
        }
        return nuevoObjeto;
    }

    @Override
    public SeJuegaConFlor getSeJuegaConFlor() {
        return this.seJuegaConFlor;
    }
}
