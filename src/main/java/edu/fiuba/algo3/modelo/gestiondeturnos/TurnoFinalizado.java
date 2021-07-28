package edu.fiuba.algo3.modelo.gestiondeturnos;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;

public class TurnoFinalizado implements Turno{

    public Turno avanzarEtapa() {
        return this;
    }

    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos)  {
        return;
    }

    public void asignarEjercito(String pais, int cantidad) {
        return;
    }

    public void moverEjercito(String paisDesde, String paisHasta, int cantidad) {
        return;
    }

    public String enQueFaseDelTurnoEsta() {
        return "TurnoFinalizado";
    }

    public void canjeoDeTresTarjetas(){
        return;
    }

    public  void canjeoUnicoTarjeta(String pais)  {
        return;
    }

    public boolean todasLasFichasColocadas(){
        throw new EtapaEquivocadaException();
    }
    
    public boolean estaFinalizado() {
        return true;
    }
}
