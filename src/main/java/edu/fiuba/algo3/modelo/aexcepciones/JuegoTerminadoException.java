package edu.fiuba.algo3.modelo.aexcepciones;

import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoJugable;

public class JuegoTerminadoException extends RuntimeException {
    private String nombreGanador;

    public JuegoTerminadoException(String nombre) {
        nombreGanador = nombre;
    }

    public String obtenerGanador(){
        return nombreGanador;
    }
}
