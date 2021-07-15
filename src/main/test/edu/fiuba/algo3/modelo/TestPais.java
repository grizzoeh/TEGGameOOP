package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class TestPais {

    Pais paisPrueba = new Pais("Argentina");


    @Test
    public void test01TrasAsignarUnNombreEsteSeQuedaCorrectamente(){

        assertEquals("Argentina", paisPrueba.obtenerNombre());
    }
    @Test
    public void test02InicialmenteCadaPaisTieneCeroEjercitos(){

        assertEquals(0, paisPrueba.obtenerCantidadEjercitos());
    }
    @Test
    public void test03InicialmenteUnPaisNoEstaOcupado(){

        assertFalse(paisPrueba.estaOcupado());
    }
    @Test
    public void test04TrasAsignarUnEjercitoEsteSeQuedaCorrectamente(){
        Ejercito ejercito = new Ejercito("Blanco");

        paisPrueba.asignarEjercito(ejercito);

        assertEquals(ejercito, paisPrueba.getEjercito());
    }
    @Test
    public void test05TrasSumarUnEjercitoElPaisEstaOcupado(){

        paisPrueba.agregarEjercito();

        assertTrue(paisPrueba.estaOcupado());
    }
    @Test
    public void test06UnPaisConDosEjercitosAlQuitarUnoSigueOcupado(){

        paisPrueba.agregarEjercito();
        paisPrueba.agregarEjercito();

        paisPrueba.eliminarEjercitos(1);

        assertTrue(paisPrueba.estaOcupado());
    }
    @Test
    public void test07UnPaisConDosEjercitosAlQuitarDosNoSigueOcupado(){

        paisPrueba.agregarEjercito();
        paisPrueba.agregarEjercito();

        paisPrueba.eliminarEjercitos(2);

        assertFalse(paisPrueba.estaOcupado());
    }
    @Test
    public void test08TrasSumar20EjercitosLaCantidadEsCorrecta(){

        for (int i = 1; i <= 20; i++ ){
                paisPrueba.agregarEjercito();
        }

        assertEquals(20,paisPrueba.obtenerCantidadEjercitos());
    }
    @Test
    public void test10TrasCambiarDeEjercitoDuenioEsteSeActualizaCorrectamente(){

        Ejercito ejercitoInicial = new Ejercito("Blanco");
        Ejercito ejercitoFinal = new Ejercito("Azul");
        paisPrueba.asignarEjercito(ejercitoInicial);

        paisPrueba.asignarEjercito(ejercitoFinal);

        assertNotEquals(ejercitoInicial, paisPrueba.getEjercito());
        assertEquals(ejercitoFinal, paisPrueba.getEjercito());
    }

    @Test
    public void test11UnPaisSinFronteraNoContieneAOtroPaisEnElla(){
        Pais segundoPais = new Pais("Australia");
        HashSet<Pais> fronteraPrueba = new HashSet<>();

        paisPrueba.agregarFrontera(fronteraPrueba);

        assertFalse(paisPrueba.estaEnFrontera(segundoPais));
    }

    @Test
    public void test12SePuedenAgregarPaisesALaFrontera(){
        Pais segundoPais = new Pais("Chile");
        HashSet<Pais> fronteraPrueba = new HashSet<>();
        fronteraPrueba.add(segundoPais);

        paisPrueba.agregarFrontera(fronteraPrueba);

        assertTrue(paisPrueba.estaEnFrontera(segundoPais));

    }
    @Test
    public void test13SePuedenAgregarMultiplesPaisesALaFrontera(){
        Pais segundoPais = new Pais("Chile");
        Pais tercerPais = new Pais("Uruguay");
        Pais cuartoPais = new Pais("Varsil");
        HashSet<Pais> fronteraPrueba = new HashSet<>();

        fronteraPrueba.add(segundoPais);
        fronteraPrueba.add(tercerPais);
        fronteraPrueba.add(cuartoPais);

        paisPrueba.agregarFrontera(fronteraPrueba);

        assertTrue(paisPrueba.estaEnFrontera(segundoPais));
        assertTrue(paisPrueba.estaEnFrontera(tercerPais));
        assertTrue(paisPrueba.estaEnFrontera(cuartoPais));

    }
    @Test
    public void test14AlInvadirSeReduceLaCantidadDeEjercitosEnElAtacante(){
        Pais segundoPais = new Pais("Chile");
        Ejercito ejercito = new Ejercito("Azul");

        paisPrueba.asignarEjercito(ejercito);

        paisPrueba.agregarEjercito();
        paisPrueba.agregarEjercito();

        paisPrueba.invadir(segundoPais);

        assertEquals(1,paisPrueba.obtenerCantidadEjercitos());

    }
    @Test
    public void test15DespuesDeInvadirElEjercitoAtacanteYDefensorSonLosMismos(){
        Pais segundoPais = new Pais("Chile");
        Ejercito ejercito = new Ejercito("Azul");

        paisPrueba.asignarEjercito(ejercito);

        paisPrueba.agregarEjercito();
        paisPrueba.agregarEjercito();

        paisPrueba.invadir(segundoPais);

        assertEquals(ejercito,paisPrueba.getEjercito());
        assertEquals(ejercito,segundoPais.getEjercito());

    }
    @Test
    public void test16TrasSumarUnEjercitoElPaisNoEsAptoParaAtacar(){

        paisPrueba.agregarEjercito();

        assertFalse(paisPrueba.esAptoParaAtacar());
    }
    @Test
    public void test17TrasSumarDosEjercitosElPaisEsAptoParaAtacar(){

        paisPrueba.agregarEjercito();
        paisPrueba.agregarEjercito();

        assertTrue(paisPrueba.esAptoParaAtacar());
    }
    @Test
    public void test18DosPaisesConElMismoEjercitoDebenTenerElMismoColor(){
        Pais segundoPais = new Pais("Chile");
        Ejercito ejercito = new Ejercito("Azul");

        paisPrueba.asignarEjercito(ejercito);
        segundoPais.asignarEjercito(ejercito);

        assertFalse(paisPrueba.tienenEjercitosDiferentes(segundoPais));

    }
    @Test
    public void test18DosPaisesConDistintoEjercitoNoDebenTenerElMismoColor(){
        Pais segundoPais = new Pais("Chile");
        Ejercito ejercito = new Ejercito("Azul");
        Ejercito ejercito2 = new Ejercito("Rojo");

        paisPrueba.asignarEjercito(ejercito);
        segundoPais.asignarEjercito(ejercito2);

        assertTrue(paisPrueba.tienenEjercitosDiferentes(segundoPais));

    }
}

