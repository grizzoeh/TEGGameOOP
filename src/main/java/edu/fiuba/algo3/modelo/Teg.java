package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.gestiondeturnos.*;
import edu.fiuba.algo3.modelo.objetivosytarjetas.*;

import java.util.ArrayList;

public class Teg {
    private int cantidadJugadores;
    private Mapa mapa;
    private ArrayList<Jugador> jugadores;
    private Turno turnoActual;
    private int numeroJugadorActual;
    private Mazo mazo;
    private ListaObjetivos posiblesObjetivos;

    public Teg(ArrayList<String> nombresJugadores, String rutaArchivo, Boolean testMode) {
        this.cantidadJugadores = nombresJugadores.size();
        this.mapa = new Mapa(rutaArchivo, testMode);
        this.jugadores = new ArrayList<Jugador>();
        this.numeroJugadorActual = 0;

        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Rosa", "Negro"};

        for (int i = 0; i < this.cantidadJugadores; i++) {
            this.jugadores.add(new Jugador(nombresJugadores.get(i), new Ejercito(colores[i])));
        }

        mapa.repartirPaises(jugadores);

        mazo = new Mazo(mapa.listaPaises());
        posiblesObjetivos = new ListaObjetivos(mapa, testMode);

        asignarObjetivosAJugadores();

        turnoActual = new TurnoEtapaInicial(jugadores, 0, mapa, 5, mazo);
    }

    public void asignarObjetivosAJugadores() {
        Jugador jugAux;

        for (int i = 0; i < this.cantidadJugadores; i++) {
            jugAux = jugadores.get(i);
            jugAux.asignarObjetivoGeneral(posiblesObjetivos.asignarObjetivoComun());
            jugAux.asignarObjetivoParticular(posiblesObjetivos.asignarObjetivoParticular());

        }
    }

    public boolean todosLosPaisesOcupados() {
        return this.mapa.todosLosPaisesOcupados();
    }

    public ArrayList<String> atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        return ((TurnoJugable) turnoActual).atacar(paisAtaque, paisDefensa, cantEjercitos);
    }

    public void moverEjercito(String paisDesde, String paisHasta, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException, PaisesNoSonDelMismoDuenoException, PaisSinEjercitosSuficientesException, PaisesNoContinuosException {
        ((TurnoJugable) turnoActual).moverEjercito(paisDesde, paisHasta, cantidad);
    }

    public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        ((TurnoJugable) turnoActual).asignarEjercito(pais, cantidad);
    }


    public void saltearColocacionInicial() {
        numeroJugadorActual = 0;
        turnoActual = new TurnoAtaque(jugadores.get(numeroJugadorActual), mapa, mazo);
    }

    public ArrayList<String> paisesDelJugadorActual() {
        Jugador jugador = ((TurnoJugable) turnoActual).obtenerJugadorActual();
        return mapa.listaPaisesConEjercito(jugador.getEjercito());
    }

    public ArrayList<String> paisesDisponiblesAtacar() {
        return mapa.paisesPuedenAtacar(((TurnoJugable) turnoActual).obtenerJugadorActual().getEjercito());
    }
    public ArrayList<String> paisesDisponiblesReagrupar() {
        return mapa.paisesPuedenReagrupar(((TurnoJugable) turnoActual).obtenerJugadorActual().getEjercito());
    }


    public void avanzarEtapa() {
        turnoActual = ((TurnoBasico) turnoActual).avanzarEtapa();

        if (((TurnoBasico) turnoActual).estaFinalizado()) {
            if (jugadorGano(jugadores.get(numeroJugadorActual))) {
                this.anunciarGanador();
            }
            numeroJugadorActual++;
            numeroJugadorActual %= jugadores.size();
            if (jugadorEstaEliminado(jugadores.get(numeroJugadorActual))) {
                jugadores.remove(numeroJugadorActual);
            }
            turnoActual = new TurnoAtaque(jugadores.get(numeroJugadorActual), mapa, mazo);
        }
    }

    public void anunciarGanador() {
        String[] coloresHex = {"cc3311", "0077bb", "009988", "ee7733", "ee3377", "000000"};
        throw new JuegoTerminadoException(jugadores.get(numeroJugadorActual), coloresHex[numeroJugadorActual]);
    }

    public ArrayList<Jugador> obtenerListaJugadores() {
        ArrayList<Jugador> lista = (ArrayList<Jugador>) jugadores.clone();
        return lista;
    }

    public boolean jugadorEstaEliminado(Jugador jugador) {
        return !mapa.leQuedanEjercitos(jugador.getEjercito());
    }

    public int cantEjercitosEn(String nombrePais) {
        return mapa.numeroEjercitosEn(nombrePais);

    }

    public ArrayList<ArrayList<String>> paisesPorJugador() {
        ArrayList<ArrayList<String>> lista = new ArrayList();
        for (Jugador persona : jugadores) {
            ArrayList<String> sublista = new ArrayList();

            sublista.add(persona.getNombre());
            sublista.addAll(mapa.listaPaisesConEjercito(persona.getEjercito()));

            lista.add(sublista);
        }
        return lista;
    }

    public ArrayList<String> paisesAliadosEnFronteraDe(String pais) {
        return mapa.paisesAliadosEnFronteraDe(pais);
    }

    public boolean jugadorGano(Jugador jugador) {
        return jugador.objetivoCumplido();
    }

    public int obtenerCantidadFichas() {
        return ((TurnoJugable) turnoActual).obtenerCantidadDeFichas();
    }

    public int cantidadJugadores() {
        return cantidadJugadores;
    }

    public String enQueFaseEstaElJuego() {
        return ((TurnoBasico) turnoActual).enQueFaseDelTurnoEsta();
    }

    public String mostrarObjetivoJugadorActual() {
        return ((TurnoJugable) turnoActual).obtenerJugadorActual().mostrarObjetivo();
    }

    public String aQueJugadorLeToca() {
        return ((TurnoJugable) turnoActual).obtenerJugadorActual().getNombre();
    }

    public String colorJugadorActual() {
        String[] coloresHex = {"cc3311", "0077bb", "009988", "ee7733", "ee3377", "000000"};
        Jugador jugador = ((TurnoJugable) turnoActual).obtenerJugadorActual();
        String color = jugador.getColor() + "-" + coloresHex[jugadores.indexOf(jugador)];
        return color;
    }

    public Integer cuantosPaisesDominaElJugadorActual() {
        Ejercito ejercito = ((TurnoJugable) turnoActual).obtenerJugadorActual().getEjercito();
        return mapa.paisesConEjercito(ejercito);
    }

    public ArrayList<String> paisesQueSePuedenAtacarDesde(String pais) {
        return mapa.paisesAtacablesDesde(pais);
    }

    public int cantidadDeTropasDisponiblesParaAtacar(String pais) {
        return mapa.cantidadDeTropasParaAtacar(pais);
    }

    public ArrayList<String> enlistarTarjetasPaisJugadorActual(){
        return jugadores.get(numeroJugadorActual).mostrarTarjetas();
    }

    public void canjearTarjetaIndividual(String pais) {
        ((TurnoJugable) turnoActual).canjeoUnicoTarjeta(pais);
    }

    public boolean sePuedenCanjearTarjetas(String tarjeta1, String tarjeta2, String tarjeta3) {
        Tarjeta objTarjeta1 = jugadores.get(numeroJugadorActual).getTarjeta(tarjeta1);
        Tarjeta objTarjeta2 = jugadores.get(numeroJugadorActual).getTarjeta(tarjeta2);
        Tarjeta objTarjeta3 = jugadores.get(numeroJugadorActual).getTarjeta(tarjeta3);

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        tarjetas.add(objTarjeta1);
        tarjetas.add(objTarjeta2);
        tarjetas.add(objTarjeta3);

        return mazo.sonAptasParaCanje(tarjetas);
    }

    public void canjearTarjetaMultiple(String tarjeta1, String tarjeta2, String tarjeta3) {

        if (!this.sePuedenCanjearTarjetas(tarjeta1, tarjeta2, tarjeta3)) {
            return;
        }

        ((TurnoJugable) turnoActual).canjeoDeTresTarjetas();

        Jugador jugadorActual = jugadores.get(numeroJugadorActual);

        jugadorActual.canjearTarjetaIndividual(tarjeta1);
        jugadorActual.canjearTarjetaIndividual(tarjeta2);
        jugadorActual.canjearTarjetaIndividual(tarjeta3);
    }




}
