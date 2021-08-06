package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.gestionDeCombate.Combate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCombate {
    @Test
    public void test01AtacantePierdeYRestaUnEjercito() {
        Ejercito ejercitoRojo = new Ejercito("Rojo");
        Ejercito ejercitoVerde = new Ejercito("Verde");

        Pais paisDefensa = new Pais("Argentina");
        Pais paisAtaque = new Pais("Brasil");

        paisDefensa.asignarEjercito(ejercitoRojo);
        paisAtaque.asignarEjercito(ejercitoVerde);

        paisDefensa.agregarEjercito(1);
        paisAtaque.agregarEjercito(2);

        CombateMock combate = new CombateMock(paisAtaque,paisDefensa,1);
        combate.generarCombateDefensorGanador();

        assertEquals(1,paisAtaque.obtenerCantidadEjercitos());
    }
    @Test
    public void test02AtacanteGanaYPasaUnEjercito() {
        Ejercito ejercitoRojo = new Ejercito("Rojo");
        Ejercito ejercitoVerde = new Ejercito("Verde");

        Pais paisDefensa = new Pais("Argentina");
        Pais paisAtaque = new Pais("Brasil");

        paisDefensa.asignarEjercito(ejercitoRojo);
        paisAtaque.asignarEjercito(ejercitoVerde);

        paisDefensa.agregarEjercito(1);
        paisAtaque.agregarEjercito(2);

        CombateMock combate = new CombateMock(paisAtaque,paisDefensa,1);
        combate.generarCombateAtacanteGanador();

        assertEquals(1,paisAtaque.obtenerCantidadEjercitos());
    }
    @Test
    public void test03AtacanteGanaYElColorDelPaisDefensorAhoraEsDelAtacante() {
        Ejercito ejercitoRojo = new Ejercito("Rojo");
        Ejercito ejercitoVerde = new Ejercito("Verde");

        Pais paisDefensa = new Pais("Argentina");
        Pais paisAtaque = new Pais("Brasil");

        paisDefensa.asignarEjercito(ejercitoRojo);
        paisAtaque.asignarEjercito(ejercitoVerde);

        paisDefensa.agregarEjercito(1);
        paisAtaque.agregarEjercito(2);

        CombateMock combate = new CombateMock(paisAtaque,paisDefensa,1);
        combate.generarCombateAtacanteGanador();

        assertEquals(ejercitoVerde,paisDefensa.getEjercito());
    }
    @Test
    public void test04CantidadDeEjercitosDespuesDeCombateEsCorrecta() {
        Ejercito ejercitoRojo = new Ejercito("Rojo");
        Ejercito ejercitoVerde = new Ejercito("Verde");

        Pais paisDefensa = new Pais("Argentina");
        Pais paisAtaque = new Pais("Brasil");

        paisDefensa.asignarEjercito(ejercitoRojo);
        paisAtaque.asignarEjercito(ejercitoVerde);

        paisDefensa.agregarEjercito(1);
        paisAtaque.agregarEjercito(2);

        Combate combate = new Combate(paisAtaque,paisDefensa,1);
        combate.generarCombate();

        assertEquals(paisAtaque.obtenerCantidadEjercitos(), 1);
        assertEquals(paisDefensa.obtenerCantidadEjercitos(), 1);
    }
    @Test
    public void test05ResultadosDeCombateSonCorrectos() {
        Ejercito ejercitoRojo = new Ejercito("Rojo");
        Ejercito ejercitoVerde = new Ejercito("Verde");

        Pais paisDefensa = new Pais("Argentina");
        Pais paisAtaque = new Pais("Brasil");

        paisDefensa.asignarEjercito(ejercitoRojo);
        paisAtaque.asignarEjercito(ejercitoVerde);

        paisDefensa.agregarEjercito(1);
        paisAtaque.agregarEjercito(2);

        Combate combate = new Combate(paisAtaque,paisDefensa,1);
        combate.generarCombate();

        assertEquals(paisAtaque.getEjercito(), ejercitoVerde);
        boolean estado = (paisDefensa.getEjercito() == ejercitoVerde || paisDefensa.getEjercito() == ejercitoRojo);
        assertTrue(estado);
    }
}

