package fiuba.algo3.modelo.jugadasPosibles;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.excepciones.NoExisteLaJugadaError;
import fiuba.algo3.modelo.excepciones.NoSeEstaJugandoConFlorError;
import fiuba.algo3.modelo.jugadasPermitidas.CartaJugada;
import fiuba.algo3.modelo.jugadasPermitidas.Jugada;
import fiuba.algo3.modelo.jugadasPermitidas.respuestasAPeticiones.*;
import org.omg.CORBA.NO_IMPLEMENT;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Krion on 15/11/2015.
 */
public class JugadaDeRespuestaAPeticion extends JugadaPosible {
    private List<String> jugadasPosibles;
    private SeJuegaConFlor seJuegaConFlor;

    public JugadaDeRespuestaAPeticion(SeJuegaConFlor seJuegaConFlor){
        this.jugadasPosibles = new ArrayList<>();
        this.seJuegaConFlor = seJuegaConFlor;
        this.jugadasPosibles.add(AceptaEnvido.class.getName());
        this.jugadasPosibles.add(CartaJugada.class.getName());
        this.jugadasPosibles.add(AceptaFaltaEnvido.class.getName());
        this.jugadasPosibles.add(AceptaRealEnvido.class.getName());
        this.jugadasPosibles.add(ReTrucoAceptado.class.getName());
        this.jugadasPosibles.add(TrucoAceptado.class.getName());
        this.jugadasPosibles.add(ValeCuatroAceptado.class.getName());
        this.jugadasPosibles.add(NoAceptaEnvido.class.getName());
        try{
            this.seJuegaConFlor.getSiHayJugadaFlor();
            this.jugadasPosibles.add(AceptaFlor.class.getName());
        } catch (NoSeEstaJugandoConFlorError e){}
    }
    @Override
    public List<String> getJugadasPosibles() {
        return jugadasPosibles;
    }

    protected String getNombreClase(Class unaClase){
        String nombreCompletoClase = unaClase.getName();
        return nombreCompletoClase.substring(nombreCompletoClase.lastIndexOf('.') + 1);
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
        if(posicionDeJugada == -1 && unaNuevaJugada.equals("AceptaFlor"))
            throw new NoSeEstaJugandoConFlorError();
        return posicionDeJugada;
    }

    protected Object crearClase(String unaJugadaNueva, Jugador unJugador) {
        Object nuevoObjeto = null;
        int posicionDeJugadaEnLista = this.compararNombresJugadas(unaJugadaNueva);
        if(posicionDeJugadaEnLista  >= 0){
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
