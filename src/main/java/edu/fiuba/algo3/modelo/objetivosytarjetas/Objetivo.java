package edu.fiuba.algo3.modelo.objetivosytarjetas;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;

public interface Objetivo {
    public boolean objetivoCumplido(Ejercito ejercito);
    public String mostrarObjetivo();

}
