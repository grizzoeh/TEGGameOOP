package edu.fiuba.algo3.modelo.gestiondeturnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.aexcepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.aexcepciones.PaisNoLePerteneceException;

import java.util.ArrayList;

public class TurnoEtapaInicial implements TurnoJugable, TurnoBasico {
    private Mapa mapa;
    private ArrayList<Jugador> jugadores;
    private int posActual;
    private int cantidadFichas;
    private int fichasMax;


    public TurnoEtapaInicial(ArrayList<Jugador> jugadores, int jugadorActual, Mapa mapaIngresado, Integer fichasAColocar) {
        this.jugadores = jugadores;
        this.mapa = mapaIngresado;
        this.posActual = jugadorActual;
        this.cantidadFichas = fichasAColocar;
        this.fichasMax = fichasAColocar;

    }
    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) {
        throw new EtapaEquivocadaException();
    }

    public void asignarEjercito(String pais, int cantidad) {
        if(!mapa.paisLePertenece(pais, jugadores.get(posActual))) {
            throw new PaisNoLePerteneceException();
        }

        cantidad = cantidad >= cantidadFichas ? cantidadFichas : cantidad;
        mapa.agregarEjercitos(pais, cantidad);
        cantidadFichas -= cantidad;
    }

    public void moverEjercito(String paisOrigen, String paisDestino, int cantidad) {
        throw new EtapaEquivocadaException();
    }

    public Turno avanzarEtapa() {
        posActual++;
        if (posActual >= jugadores.size()) {
            if (fichasMax == 3) {
                return new TurnoAtaque(jugadores.get(0), mapa);
            } else {
                return new TurnoEtapaInicial(jugadores, 0, mapa, 3);
            }
        }
        return new TurnoEtapaInicial(jugadores, posActual, mapa, fichasMax);
    }


    public void canjeoDeTresTarjetas() {
        throw new EtapaEquivocadaException();
    }

    public void canjeoUnicoTarjeta(String pais) {
        throw new EtapaEquivocadaException();
    }

    public String enQueFaseDelTurnoEsta(){
        return "Etapa Inicial";
    }

    public  int getCantidadFichasTrasCanje() {
        throw new EtapaEquivocadaException();
    }

    public boolean todasLasFichasColocadas(){
        return (cantidadFichas == 0);
    }

    public boolean estaFinalizado() {
        return false;
    }

    public int obtenerCantidadDeFichas() {
        return cantidadFichas;
    }

    public Jugador obtenerJugadorActual() {
        return jugadores.get(posActual);
    }
}