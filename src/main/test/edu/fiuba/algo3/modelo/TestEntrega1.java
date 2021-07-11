package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEntrega1 {
    @Test
    public void test01ColocacionDeEjercitos() {
        ArrayList<String> jugadores = new ArrayList<String>();
        jugadores.add("Nico");
        jugadores.add("Tomi");

        Teg teg = new Teg(jugadores);
        assertTrue(teg.todosLosPaisesOcupados());
    }
}
