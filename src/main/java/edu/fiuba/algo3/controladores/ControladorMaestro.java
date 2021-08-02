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

    public ArrayList<String> paisesQueSePuedenAtacarDesde(String pais){
        return teg.paisesQueSePuedenAtacarDesde(pais);
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

    public void avanzarEtapa() { teg.avanzarEtapa(); }

    public String etapaActual() {
        return teg.enQueFaseEstaElJuego();
    }

    public String colorJugadorActual() {
        return teg.colorJugadorActual();
    }

    public void asignarFichas(int cantidad, String pais) {
        teg.asignarEjercito(pais, cantidad);
    }

    public int paisesDominadosPorJugActual(){
        return teg.cuantosPaisesDominaElJugadorActual();
    }

    public ArrayList<ArrayList<String>> paisesPorJugador() {
        return teg.paisesPorJugador();
    }

    public int tropasDisponiblesEn(String pais) {
        return teg.cantidadDeTropasDisponiblesParaAtacar(pais);
    }
    public void atacar(String desde, String hacia, Integer cantidad){
        teg.atacar(desde,hacia,cantidad);
    }
}
