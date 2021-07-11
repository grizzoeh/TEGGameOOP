package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestsMapa {
    @Test
    public void test01TodosLosPaisesSeInicializanConAlMenosUnEjercito() {
        Mapa mapa = new Mapa();
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        Jugador jugador1 = new Jugador("Estebanquito", new Ejercito("Blanquito"));
        jugadores.add(jugador1);
        mapa.repartirPaises(jugadores);

    assertTrue(mapa.todosLosPaisesOcupados());


    }
}

