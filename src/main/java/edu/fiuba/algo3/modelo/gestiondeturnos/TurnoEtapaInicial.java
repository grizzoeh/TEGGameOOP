package edu.fiuba.algo3.modelo.gestiondeturnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;

public class TurnoEtapaInicial implements Turno {
    private Mapa mapa;
    private Jugador jugador;
    private int cantidadFichas;


    public TurnoEtapaInicial(Jugador jugadorIngresado, Mapa mapaIngresado, Integer fichasAColocar) {
        this.jugador = jugadorIngresado;
        this.mapa = mapaIngresado;
        this.cantidadFichas = fichasAColocar;
    }
    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) {
        throw new EtapaEquivocadaException();
    }

    public void asignarEjercito(String pais, int cantidad) {
        if(!mapa.paisLePertenece(pais, jugador)) {
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
        return new TurnoFinalizado();
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
}