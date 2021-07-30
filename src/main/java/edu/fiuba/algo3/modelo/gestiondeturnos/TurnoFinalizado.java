package edu.fiuba.algo3.modelo.gestiondeturnos;

public class TurnoFinalizado implements TurnoBasico {

    public TurnoJugable avanzarEtapa() {return (TurnoJugable) this;}

    public String enQueFaseDelTurnoEsta() {
        return "TurnoFinalizado";
    }

    public boolean estaFinalizado() {
        return true;
    }
}
