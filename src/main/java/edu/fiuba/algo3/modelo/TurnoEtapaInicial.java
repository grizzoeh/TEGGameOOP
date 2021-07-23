package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;

import java.util.ArrayList;

public class TurnoEtapaInicial implements Turno {
    private Mapa mapa;
    private Jugador jugador;
    private int cantidadFichas;


    public TurnoEtapaInicial(Jugador jugadorIngresado, Mapa mapaIngresado, Integer fichasAColocar) {
        this.jugador = jugadorIngresado;
        this.mapa = mapaIngresado;
        this.cantidadFichas = fichasAColocar;
    }
    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        throw new EtapaEquivocadaException();
    }

    public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        if(!mapa.paisLePertenece(pais, jugador)) {
            throw new PaisNoLePerteneceException();
        }

        cantidad = cantidad >= cantidadFichas ? cantidadFichas : cantidad;
        mapa.agregarEjercitos(pais, cantidad);
        cantidadFichas -= cantidad;
    }

    public void moverEjercito(String paisOrigen, String paisDestino, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        throw new EtapaEquivocadaException();
    }

    public Turno avanzarEtapa() {
        return new TurnoFinalizado();
    }


    public void canjeoDeTresTarjetas() throws EtapaEquivocadaException {
        throw new EtapaEquivocadaException();
    }

    public void canjeoUnicoTarjeta(String pais) throws PaisNoLePerteneceException, EtapaEquivocadaException {
        throw new EtapaEquivocadaException();
    }

    public String enQueFaseDelTurnoEsta(){
        return "Etapa Inicial";
    }

    public  int getCantidadFichasTrasCanje() throws EtapaEquivocadaException {
        throw new EtapaEquivocadaException();
    }

    public boolean todasLasFichasColocadas(){
        return (cantidadFichas == 0);
    }

    public boolean estaFinalizado() {
        return false;
    }
}