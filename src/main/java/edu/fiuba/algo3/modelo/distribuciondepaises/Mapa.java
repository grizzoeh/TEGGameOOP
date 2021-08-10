package edu.fiuba.algo3.modelo.distribuciondepaises;

import edu.fiuba.algo3.modelo.gestionDeCombate.Combate;
import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;



public class Mapa {
    private Hashtable<String, Pais> paises;
    private Hashtable<String, Continente> continentes;
    private String rutaArchivo;
    private Boolean testMode;

    public Mapa(String rutaArchivo, Boolean testMode){
        this.paises = new Hashtable<String, Pais>();
        this.continentes = new Hashtable<String, Continente>();
        this.rutaArchivo = rutaArchivo;
        this.testMode = testMode;
        this.crearContinentes();
        try {
            this.crearPaises();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void crearPaises() throws FileNotFoundException {
        LectorArchivos lector = new LectorArchivos();
        lector.leerYParsear(rutaArchivo,paises,continentes);


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
        ArrayList<String> keysEnArray = new ArrayList<>(Arrays.asList(keys));
        int i = 0;
        int j = 0;
        int jugActual;

        while(i < cantidadPaises){
            jugActual = j % cantidadJugadores;
            paisAux = paises.get(obtenerKeyRandom(keysEnArray));
            if (testMode){
                paisAux = paises.get(keys[i]);
            }
            paisAux.asignarEjercito(jugadores.get(jugActual).getEjercito());
            paisAux.agregarEjercito(1);
            i++;
            j++;
        }
    }
    public String obtenerKeyRandom(ArrayList<String> keys){
        int numeroKey = (int)(Math.random()*keys.size());
        String key = keys.get(numeroKey);
        keys.remove(numeroKey);
        return key;
    }
    public boolean todosLosPaisesOcupados(){
        AtomicBoolean estanOcupados = new AtomicBoolean(true);

        paises.forEach((stringPais, objetoPais) -> {
            estanOcupados.set(estanOcupados.get() && (objetoPais.estaOcupado()));
        });
        return estanOcupados.get();
    }

    public Pais obtenerPais(String paisABuscar) {
        if (!paises.containsKey(paisABuscar)) throw new NoExisteEsePaisException();
        return paises.get(paisABuscar);
    }

    public ArrayList<String> atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws PaisesNoContinuosException, PaisesConMismoDuenoException, PaisSinEjercitosSuficientesException {
        Pais paisAtacante = obtenerPais(paisAtaque);
        Pais paisDefensor = obtenerPais(paisDefensa);

        if(!sonContiguos(paisAtacante, paisDefensor))
            throw new PaisesNoContinuosException();
        if(!paisAtacante.tienenEjercitosDiferentes(paisDefensor))
            throw new PaisesConMismoDuenoException();
        if(!paisAtacante.esAptoParaAtacar())
            throw new PaisSinEjercitosSuficientesException();

        Combate combate = new Combate(paisAtacante, paisDefensor, cantEjercitos);
        return combate.generarCombate();
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
    public ArrayList<String> listaPaisesConEjercito(Ejercito ejercito) {
        ArrayList<String> paisesPertenecientes = new ArrayList<>();
        paises.forEach((stringPais, objetoPais) -> {
            if (ejercitoEnPais(stringPais) == ejercito) paisesPertenecientes.add(stringPais);
        });
        Collections.sort(paisesPertenecientes);
        return paisesPertenecientes;
    }

    public ArrayList<String> paisesPuedenAtacar(Ejercito ejercito) {
        ArrayList<String> paisesParaAtacar = this.listaPaisesConEjercito(ejercito);
        if (paisesParaAtacar.size() != 0 ){
            paisesParaAtacar.removeIf(pais -> !paises.get(pais).esAptoParaAtacar() | !paises.get(pais).tienePaisesAliadosEnFrontera());
        }
        paisesParaAtacar.removeIf(pais -> !paises.get(pais).esAptoParaAtacar() | !paises.get(pais).tienePaisesEnemigosEnFrontera());
        return paisesParaAtacar;
    }
    public ArrayList<String> paisesPuedenReagrupar(Ejercito ejercito) {
        ArrayList<String> paisesParaReagrupar = this.listaPaisesConEjercito(ejercito);
        if (paisesParaReagrupar.size() != 0 ){
            paisesParaReagrupar.removeIf(pais -> !paises.get(pais).esAptoParaAtacar() | !paises.get(pais).tienePaisesAliadosEnFrontera());

        }
        return paisesParaReagrupar;
    }

    public ArrayList<Pais> listaPaises() {
        ArrayList<Pais> paisesADevolver = new ArrayList<>();
        paises.forEach((stringPais, objetoPais) -> {
             paisesADevolver.add(objetoPais);
        });
        return paisesADevolver;
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


    public boolean leQuedanEjercitos(Ejercito ejercito) {
        return (this.paisesConEjercito(ejercito) != 0);
    }

    public ArrayList<String> paisesAtacablesDesde(String pais){
        Pais atacante = this.obtenerPais(pais);
        return atacante.paisesEnemigosEnFrontera();
    }

    public int cantidadDeTropasParaAtacar(String pais) {
        Pais atacante = this.obtenerPais(pais);
        return atacante.tropasDisponiblesParaAtacar();
    }

    public ArrayList<String> paisesAliadosEnFronteraDe(String pais) {
        if (!Objects.equals(pais, null)){
            Pais desde = this.obtenerPais(pais);
            return desde.paisesAliadosEnFrontera();
        }
     throw  new NoExisteEsePaisException();
    }
}