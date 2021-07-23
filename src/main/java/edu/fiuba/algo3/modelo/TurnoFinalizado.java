package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;

public class TurnoFinalizado implements Turno{

    public Turno avanzarEtapa() {
        return this;
    }

    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        return;
    }

    public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        return;
    }

    public void moverEjercito(String paisDesde, String paisHasta, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        return;
    }

    public String enQueFaseDelTurnoEsta() {
        return "TurnoFinalizado";
    }

    public void canjeoDeTresTarjetas() throws EtapaEquivocadaException {
        return;
    }

    public  void canjeoUnicoTarjeta(String pais) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        return;
    }
    public boolean estaFinalizado() {
        return true;
    }
}
