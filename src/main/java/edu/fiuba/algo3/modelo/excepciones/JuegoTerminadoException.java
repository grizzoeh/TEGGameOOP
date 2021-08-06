package edu.fiuba.algo3.modelo.excepciones;

import edu.fiuba.algo3.modelo.componentesJugador.Jugador;

public class JuegoTerminadoException extends RuntimeException {
    private Jugador jugGanador;
    private String colorJugHex;

    public JuegoTerminadoException(Jugador jugador, String colorHex) {
        colorJugHex = colorHex;
        jugGanador = jugador;
    }

    public String obtenerNombreGanador(){
        return jugGanador.getNombre();
    }


    public String obtenerColorGanador(){
        String color = (jugGanador.getColor() + "-" + colorJugHex);
        return color;
    }
}
