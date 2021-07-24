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

    @Test
    public void test02CombateDefensorGanador() {
        Ejercito ejercitoCeleste = new Ejercito("Celeste");
        Ejercito ejercitoVerde = new Ejercito("Verde");

        Pais paisDefensa = new Pais("Argentina");
        Pais paisAtaque = new Pais("Brasil");

        paisDefensa.asignarEjercito(ejercitoCeleste);
        paisAtaque.asignarEjercito(ejercitoVerde);

        paisDefensa.agregarEjercito(1);
        paisAtaque.agregarEjercito(2);

        CombateMock combate = new CombateMock(paisAtaque,paisDefensa,1);
        combate.generarCombateDefensorGanador();


        assertEquals(1,paisDefensa.obtenerCantidadEjercitos());
        assertEquals(1,paisAtaque.obtenerCantidadEjercitos());
        assertEquals(ejercitoCeleste, paisDefensa.getEjercito());
    }

    @Test
    public void test03CombateAtacanteGanadorEInvade() {

        Ejercito ejercitoCeleste = new Ejercito("Celeste");
        Ejercito ejercitoVerde = new Ejercito("Verde");

        Pais paisDefensa = new Pais("Argentina");
        Pais paisAtaque = new Pais("Brasil");

        paisDefensa.asignarEjercito(ejercitoCeleste);
        paisAtaque.asignarEjercito(ejercitoVerde);

        paisDefensa.agregarEjercito(1);
        paisAtaque.agregarEjercito(2);

        CombateMock combate = new CombateMock(paisAtaque,paisDefensa,1);
        combate.generarCombateAtacanteGanador();

        assertEquals(1,paisDefensa.obtenerCantidadEjercitos());
        assertEquals(1,paisAtaque.obtenerCantidadEjercitos());
        assertEquals(ejercitoVerde, paisDefensa.getEjercito());
    }
}
