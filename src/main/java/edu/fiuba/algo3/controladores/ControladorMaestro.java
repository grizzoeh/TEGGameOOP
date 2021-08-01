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
    public ArrayList<String> paisesPuedenAtacar() {
        return teg.paisesDisponiblesAtacar();
    }
    public int fichasDisponiblesJugadorActual() {
        return teg.obtenerCantidadFichas();
    }
    public String objetivoJugadorActual() {
        return teg.mostrarObjetivoJugadorActual();
    }
    public String nombreJugadorActual() {
        System.out.println(teg.aQueJugadorLeToca());
        return teg.aQueJugadorLeToca();
    }
    public void avanzarEtapa() {
        teg.avanzarEtapa();
    }
    public String etapaActual() {
        return teg.enQueFaseEstaElJuego();
    }

    public String colorJugadorActual() {
        return teg.colorJugadorActual();
    }

    public void asignarFichas(int cantidad, String pais) {
        teg.asignarEjercito(pais, cantidad);
    }

}
