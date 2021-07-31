package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.aexcepciones.*;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
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
        this.mapa = new Mapa(rutaArchivo);
        this.jugadores = new ArrayList<Jugador>();
        this.numeroJugadorActual = 0;

        String[] colores = {"rojo", "azul", "verde", "amarillo", "rosa", "negro"};

        for (int i = 0; i < this.cantidadJugadores; i++) {
            this.jugadores.add(new Jugador(nombresJugadores.get(i), new Ejercito(colores[i])));
        }

        mapa.repartirPaises(jugadores);

        mazo = new Mazo(mapa.listaPaises());
        posiblesObjetivos = new ListaObjetivos(mapa, testMode);

        asignarObjetivosAJugadores();

        turnoActual = new TurnoEtapaInicial(jugadores.get(numeroJugadorActual),mapa, 5);
    }

    public void asignarObjetivosAJugadores(){
        Jugador jugAux;

        for (int i = 0; i < this.cantidadJugadores; i++) {
            jugAux = jugadores.get(i);
            jugAux.asignarObjetivoGeneral(posiblesObjetivos.asignarObjetivoComun());
            jugAux.asignarObjetivoParticular(posiblesObjetivos.asignarObjetivoParticular());

        }
    }
    public boolean todosLosPaisesOcupados(){
        return this.mapa.todosLosPaisesOcupados();
    }

    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        ((TurnoJugable) turnoActual).atacar(paisAtaque,paisDefensa,cantEjercitos);
    }

    public void moverEjercito(String paisDesde, String paisHasta,int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException, PaisesNoSonDelMismoDuenoException, PaisSinEjercitosSuficientesException, PaisesNoContinuosException {
        ((TurnoJugable) turnoActual).moverEjercito(paisDesde,paisHasta,cantidad);
    }

    public void asignarEjercito(String pais,int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        ((TurnoJugable) turnoActual).asignarEjercito(pais,cantidad);
    }

    public void avanzarPrimeraEtapaColocacion() throws ColocacionFinalizadaException {
        if (numeroJugadorActual > jugadores.size()) throw new ColocacionFinalizadaException();

        if (numeroJugadorActual == jugadores.size()){
            numeroJugadorActual = 0;
            turnoActual = new TurnoEtapaInicial(jugadores.get(0),mapa, 3);
            return;
        }
        Integer jugActual = numeroJugadorActual % jugadores.size();
        numeroJugadorActual++;
        turnoActual = new TurnoEtapaInicial(jugadores.get(jugActual),mapa, 5);
    }
    public void avanzarSegundaEtapaColocacion() throws ColocacionFinalizadaException {
        if (numeroJugadorActual > jugadores.size()) throw new ColocacionFinalizadaException();
        if (numeroJugadorActual == jugadores.size()){
            numeroJugadorActual = 0;
            turnoActual = new TurnoAtaque(jugadores.get(0),mapa);
            return;
        }
        numeroJugadorActual++;
        Integer jugActual = numeroJugadorActual % jugadores.size();
        turnoActual = new TurnoEtapaInicial(jugadores.get(jugActual),mapa, 3);
    }


    public void saltearColocacionInicial(){
        numeroJugadorActual = 0;
        turnoActual = new TurnoAtaque(jugadores.get(numeroJugadorActual), mapa);
    }
    public ArrayList<String> paisesDelJugadorActual(){
        Jugador jugador = jugadores.get(numeroJugadorActual);
        return mapa.listaPaisesConEjercito(jugador.getEjercito());
    }
    public void avanzarEtapa(){
         turnoActual = ((TurnoJugable) turnoActual).avanzarEtapa();

        if(((TurnoBasico) turnoActual).estaFinalizado()){
            if (jugadorGano(jugadores.get(numeroJugadorActual))){
                this.anunciarGanador();
            }
            numeroJugadorActual++;
            numeroJugadorActual %= jugadores.size();
            if (jugadorEstaEliminado(jugadores.get(numeroJugadorActual))){
                jugadores.remove(numeroJugadorActual);
            }
            turnoActual = new TurnoAtaque(jugadores.get(numeroJugadorActual),mapa);
        }
    }

    public void anunciarGanador() {
        //Darle funcionalidad
    }
    public ArrayList<Jugador> obtenerListaJugadores(){
        ArrayList<Jugador> lista = (ArrayList<Jugador>) jugadores.clone();
        return lista;
    }
    public boolean jugadorEstaEliminado(Jugador jugador){
        return !mapa.leQuedanEjercitos(jugador.getEjercito());
    }

    public int cantEjercitosEn(String nombrePais){
        return mapa.numeroEjercitosEn(nombrePais);

    }

    public boolean jugadorGano(Jugador jugador){
        return jugador.objetivoCumplido();
    }

    public int obtenerCantidadFichas() {
        return ((TurnoJugable) turnoActual).obtenerCantidadDeFichas();
    }

    public int cantidadJugadores(){
        return cantidadJugadores;
    }
    public String enQueFaseEstaElJuego(){
        return ((TurnoBasico) turnoActual).enQueFaseDelTurnoEsta();
    }
    public String mostrarObjetivoJugadorActual() {
        Jugador jugador = jugadores.get(numeroJugadorActual);
        return jugador.mostrarObjetivo();
    }

    public String aQueJugadorLeToca(){
        return jugadores.get(numeroJugadorActual).getNombre();
    }

    public String colorJugadorActual() {
        Jugador jugador = jugadores.get(numeroJugadorActual);
        return jugador.getColor();
    }
}