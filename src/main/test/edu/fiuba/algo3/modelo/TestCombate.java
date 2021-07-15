package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    /*

    ESTE TEST DEBE SER ELIMINADO, YA QUE NO ES REESPOSABILIDAD DE LA CLASE COMBATE EL VERIFICAR ESTA SITUACION
    @Test
    public void test04AtacanteConSoloUnEjercitoNoPuedeAtacar() {
        Ejercito ejercitoRojo = new Ejercito("Rojo");
        Ejercito ejercitoVerde = new Ejercito("Verde");

        Pais paisDefensa = new Pais("Argentina");
        Pais paisAtaque = new Pais("Brasil");

        paisDefensa.asignarEjercito(ejercitoRojo);
        paisAtaque.asignarEjercito(ejercitoVerde);

        paisDefensa.agregarEjercito();
        paisAtaque.agregarEjercito();

        Combate combate = new Combate(paisAtaque,paisDefensa,1);
        combate.generarCombate();

        assertEquals(1,paisAtaque.obtenerCantidadEjercitos());
        assertEquals(1,paisDefensa.obtenerCantidadEjercitos());
    }
     */
}

