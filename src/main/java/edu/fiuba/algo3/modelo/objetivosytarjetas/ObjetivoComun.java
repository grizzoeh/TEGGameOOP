package edu.fiuba.algo3.modelo.objetivosytarjetas;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;

public class ObjetivoComun implements Objetivo{
    private String objetivo;
    private Mapa mapa;

    public ObjetivoComun(Mapa mapaRecibido){
        this.objetivo = "Ocupar 30 países.";
        this.mapa = mapaRecibido;
    }

    @Override
    public boolean objetivoCumplido(Ejercito ejercito) {
        return (30 <= mapa.paisesConEjercito(ejercito));
    }
    @Override
    public String mostrarObjetivo(){
        return objetivo;
    }
}
