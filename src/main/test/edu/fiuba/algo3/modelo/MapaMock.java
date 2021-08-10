package edu.fiuba.algo3.modelo;

import com.opencsv.CSVReader;
import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Continente;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.excepciones.PaisSinEjercitosSuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisesConMismoDuenoException;
import edu.fiuba.algo3.modelo.excepciones.PaisesNoContinuosException;
import edu.fiuba.algo3.modelo.excepciones.PaisesNoSonDelMismoDuenoException;
import edu.fiuba.algo3.modelo.gestionDeCombate.Combate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class MapaMock {
    private Hashtable<String, Pais> paises;
    private Hashtable<String, Continente> continentes;

    public MapaMock(){
        this.paises = new Hashtable<String, Pais>();
        this.continentes = new Hashtable<String, Continente>();
        this.crearContinentes();
        try {
            this.crearPaises();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void crearPaises() throws FileNotFoundException {
        FileReader fileReader = new FileReader("archivosDeTexto/fronterasParaPruebas.csv");
        CSVReader csvReader = new CSVReader(fileReader);

        ArrayList<String> listaLector;
        try {
            String[] linea;
            csvReader.readNext();
            while ((linea = csvReader.readNext()) != null) {
                Pais paisAux = new Pais(linea[0]);
                paises.put(linea[0],paisAux);
                continentes.get(linea[1]).agregarPais(paisAux);

            }

            fileReader = new FileReader("archivosDeTexto/fronteras.csv");
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();
            while ((linea = csvReader.readNext()) != null) {
                ArrayList<Pais> frontera = new ArrayList<Pais>();
                Pais paisAux = paises.get(linea[0]);
                String[] listaFronteras = linea[2].replaceAll("^\"|\"$", "").split(",");

                for (String pais : listaFronteras){
                    frontera.add(paises.get(pais));
                }


                paisAux.agregarFrontera(frontera);


            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void crearContinentes(){
        ArrayList<Integer> bonusFichas = new ArrayList<>();
        bonusFichas.add(5);
        bonusFichas.add(3);
        bonusFichas.add(7);
        bonusFichas.add(3);
        bonusFichas.add(5);
        bonusFichas.add(2);
        String[] nombresContinentes = {"America del Norte", "America del Sur", "Asia", "Africa", "Europa", "Oceania"};
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
}