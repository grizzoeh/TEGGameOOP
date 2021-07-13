package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {
    Jugador jugador = new Jugador("Nicolas", new Ejercito("Verde"));

    @Test
    public void test01JugadorGuardaSuEjercitoCorrectamente() {
        Ejercito ejercitoAux = this.jugador.getEjercito();

        assertEquals("Verde", ejercitoAux.getColor());
    }

    @Test
    public void test02JugadorGuardaSuNombreCorrectamente(){
        assertEquals("Nicolas", this.jugador.getNombre());
    }
}
