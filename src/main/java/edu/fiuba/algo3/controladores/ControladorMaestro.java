package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Teg;

import java.util.ArrayList;

public class ControladorMaestro {
    Teg teg;

    public ControladorMaestro (ArrayList<String> jugadores) {

        teg = new Teg(jugadores, ProveedorDeConstantes.obtenerDireccionTablero(), false);

    }
    public ArrayList<String> paisesJugadorActual() {
        return teg.paisesDelJugadorActual();
    }
    public int fichasDisponiblesJugadorActual() {
        return teg.obtenerCantidadFichas();
    }
    public String objetivoJugadorActual() {
        return teg.mostrarObjetivoJugadorActual();
    }
    public String nombreJugadorActual() {
        return teg.aQueJugadorLeToca();
    }

    public String colorJugadorActual() {
        return teg.colorJugadorActual();
    }

}
