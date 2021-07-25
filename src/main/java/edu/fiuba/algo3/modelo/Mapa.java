package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PaisSinEjercitosSuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisesConMismoDuenoException;
import edu.fiuba.algo3.modelo.excepciones.PaisesNoContinuosException;
import edu.fiuba.algo3.modelo.excepciones.PaisesNoSonDelMismoDuenoException;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Mapa {
    private Hashtable<String, Pais> paises;
    private Hashtable<String, Continente> continentes;

    public Mapa(){
        this.paises = new Hashtable<String, Pais>();
        this.continentes = new Hashtable<String, Continente>();
        this.crearContinentes();
        this.crearPaises();
    }

    //Transformar este metodo a una lectura de archivos (un archivo de paises y otro de fronteras)
    public void crearPaises() {

        String[] nombresPaises = {"Madagascar", "Etiopia", "Egipto", "Sahara", "Sudafrica", "Zaire", "Arabia", "Turquia"};
        Pais paisAux;

        for(int i = 0; i < (nombresPaises.length); i++){
            paises.put(nombresPaises[i], new Pais(nombresPaises[i]));

        }

        ArrayList<Pais> fronteraAux = new ArrayList<>();
        paisAux = paises.get("Egipto");

        continentes.get("África").agregarPais(paisAux);

        fronteraAux.add( paises.get("Etiopia"));
        fronteraAux.add( paises.get("Madagascar"));
        fronteraAux.add( paises.get("Sahara"));
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Etiopia");

        continentes.get("África").agregarPais(paisAux);

        fronteraAux = new ArrayList<>();

        fronteraAux.add( paises.get("Egipto"));
        fronteraAux.add( paises.get("Zaire"));
        fronteraAux.add( paises.get("Sahara"));
        fronteraAux.add( paises.get("Sudafrica"));

        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Madagascar");

        continentes.get("África").agregarPais(paisAux);

        fronteraAux = new ArrayList<>();
        fronteraAux.add( paises.get("Egipto"));
        fronteraAux.add( paises.get("Zaire"));

        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Sahara");

        continentes.get("África").agregarPais(paisAux);

        fronteraAux = new ArrayList<>();
        fronteraAux.add( paises.get("Egipto"));
        fronteraAux.add( paises.get("Zaire"));
        fronteraAux.add( paises.get("Etiopia"));

        paisAux.agregarFrontera(fronteraAux);

        paisAux = (paises.get("Sudafrica"));

        continentes.get("África").agregarPais(paisAux);

        fronteraAux = new ArrayList<>();
        fronteraAux.add( paises.get("Zaire"));
        fronteraAux.add( paises.get("Etiopia"));

        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Zaire");

        continentes.get("África").agregarPais(paisAux);

        fronteraAux = new ArrayList<>();

        fronteraAux.add( paises.get("Madagascar"));
        fronteraAux.add( paises.get("Etiopia"));
        fronteraAux.add( paises.get("Sahara"));
        fronteraAux.add(paises.get("Sudafrica"));

        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Turquia");

        continentes.get("Asia").agregarPais(paisAux);

        fronteraAux = new ArrayList<>();

        fronteraAux.add( paises.get("Arabia"));

        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Arabia");

        continentes.get("Asia").agregarPais(paisAux);

        fronteraAux = new ArrayList<>();

        fronteraAux.add( paises.get("Turquia"));
        paisAux.agregarFrontera(fronteraAux);
    }

    public void crearContinentes(){
        ArrayList<Integer> bonusFichas = new ArrayList<>();
        bonusFichas.add(5);
        bonusFichas.add(3);
        bonusFichas.add(7);
        bonusFichas.add(3);
        bonusFichas.add(5);
        bonusFichas.add(2);
        String[] nombresContinentes = {"América del Norte", "América del Sur", "Asia", "África", "Europa", "Oceanía"};
        for (int i = 0; i < (nombresContinentes.length); i++){
            continentes.put(nombresContinentes[i], new Continente(nombresContinentes[i],bonusFichas.get(i)));
        }
    }

    public void repartirPaises(ArrayList<Jugador> jugadores){

        int cantidadPaises = paises.size();
        int cantidadJugadores = jugadores.size();
        Pais paisAux;
        String[] keys = paises.keySet().toArray(new String[0]);
        int i = 0;
        int j = 0;
        int jugActual;
        while(i < cantidadPaises){
            jugActual = j % cantidadJugadores;
            paisAux = paises.get(keys[i]);
            paisAux.asignarEjercito(jugadores.get(jugActual).getEjercito());
            paisAux.agregarEjercito(1);
            i++;
            j++;
        }
    }

    public boolean todosLosPaisesOcupados(){
        AtomicBoolean estanOcupados = new AtomicBoolean(true);

        paises.forEach((stringPais, objetoPais) -> {
            estanOcupados.set(estanOcupados.get() && (objetoPais.estaOcupado()));
        });
        return estanOcupados.get();
    }

    public Pais obtenerPais(String paisABuscar) {
        return paises.get(paisABuscar);
    }

    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws PaisesNoContinuosException, PaisesConMismoDuenoException, PaisSinEjercitosSuficientesException {
        Pais paisAtacante = obtenerPais(paisAtaque);
        Pais paisDefensor = obtenerPais(paisDefensa);

        if(!sonContiguos(paisAtacante, paisDefensor))
            throw new PaisesNoContinuosException();
        if(!paisAtacante.tienenEjercitosDiferentes(paisDefensor))
            throw new PaisesConMismoDuenoException();
        if(!paisAtacante.esAptoParaAtacar())
            throw new PaisSinEjercitosSuficientesException();

        Combate combate = new Combate(paisAtacante, paisDefensor, cantEjercitos);
        combate.generarCombate();
    }

    public boolean sonContiguos(Pais paisUno, Pais paisDos) {
        return paisUno.estaEnFrontera(paisDos);
    }

    public Ejercito ejercitoEnPais(String nombrePais){
        Pais paisBuscado = paises.get(nombrePais);
        return paisBuscado.getEjercito();
    }

    public int numeroEjercitosEn(String nombrePais){
        Pais paisBuscado = paises.get(nombrePais);
        return paisBuscado.obtenerCantidadEjercitos();
    }

    public Integer paisesConEjercito(Ejercito ejercito){
        AtomicInteger contadorEjercito = new AtomicInteger();
        Ejercito ejercitoAux;

        AtomicBoolean estado = new AtomicBoolean(true);

        paises.forEach((stringPais, objetoPais) -> {
            if (ejercitoEnPais(stringPais) == ejercito) contadorEjercito.getAndIncrement();
        });
        return contadorEjercito.get();
    }

    public void moverEjercitos(String paisOrigen, String paisDestino, Integer cantidadAMover) throws PaisesNoContinuosException, PaisSinEjercitosSuficientesException, PaisesNoSonDelMismoDuenoException {
        Pais origen = obtenerPais(paisOrigen);
        Pais destino = obtenerPais(paisDestino);

        if (!sonContiguos(origen,destino)) throw new PaisesNoContinuosException();
        if (origen.tienenEjercitosDiferentes(destino)) throw new PaisesNoSonDelMismoDuenoException();
        if (!origen.sePuedeMoverEstaCantidadDeEjercitos(cantidadAMover)) throw new PaisSinEjercitosSuficientesException();

        origen.eliminarEjercitos(cantidadAMover);
        destino.agregarEjercito(cantidadAMover);
    }


    public boolean paisLePertenece(String pais, Jugador jugador) {
        Pais paisAux = paises.get(pais);
        return jugador.getEjercito() == paisAux.getEjercito();
    }

	public void agregarEjercitos(String paisIngresado, int cantidad) {
		Pais pais = paises.get(paisIngresado);
		pais.agregarEjercito(cantidad);
	}

    public boolean jugadorControlaContinente(String  continente, Jugador jugador) {
        return continentes.get(continente).jugadorControlaContinente(jugador.getEjercito());
    }

    public int fichasPorContinentesControlados(Ejercito ejercito) {
        AtomicInteger fichas = new AtomicInteger();

        continentes.forEach((stringContinente, objetoContinente) -> {
            if (objetoContinente.jugadorControlaContinente(ejercito)) fichas.addAndGet(objetoContinente.getBonusConquista());
        });
        return fichas.get();
    }

    public Continente getContinente(String nombre){
        return continentes.get(nombre);
    }
}