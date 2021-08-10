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

    public ArrayList<String> paisesPuedenReagrupar() {
        return teg.paisesDisponiblesReagrupar();
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

    public  ArrayList<String> paisesAliadosEnFronteraDe(String pais){
        return teg.paisesAliadosEnFronteraDe(pais);
    }
    public int tropasDisponiblesEn(String pais) {
        return teg.cantidadDeTropasDisponiblesParaAtacar(pais);
    }

    public ArrayList<String> atacar(String desde, String hacia, Integer cantidad){
        return teg.atacar(desde,hacia,cantidad);
    }

    public void reagrupar(String desde, String hacia, int cantidad) {
        teg.moverEjercito(desde, hacia, cantidad);
    }

    public ArrayList<String> mostrarTodasTarjetasJugadorActual() {
     return teg.enlistarTarjetasPaisJugadorActual();
    }

    public void canjearTarjetaIndividual(String pais) {
        teg.canjearTarjetaIndividual(pais);
    }

    public boolean sePuedenCanjearTarjetas(String tarjeta1, String tarjeta2, String tarjeta3) {
        return teg.sePuedenCanjearTarjetas(tarjeta1, tarjeta2, tarjeta3);
    }
    public void canjearTarjetaMultiple(String tarjeta1, String tarjeta2, String tarjeta3) {
        teg.canjearTarjetaMultiple(tarjeta1, tarjeta2, tarjeta3);
    }

}
