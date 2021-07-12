package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEjercito {
    Ejercito ejercito = new Ejercito("Verde");

    @Test
    public void test01EjercitoSeGeneraCorrectamente(){
        assertEquals("Verde",this.ejercito.getColor());
    }
}
