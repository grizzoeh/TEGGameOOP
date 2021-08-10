package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

        paisPrueba.agregarEjercito(1);

        assertTrue(paisPrueba.estaOcupado());
    }
    @Test
    public void test06UnPaisConDosEjercitosAlQuitarUnoSigueOcupado(){

        paisPrueba.agregarEjercito(2);

        paisPrueba.eliminarEjercitos(1);

        assertTrue(paisPrueba.estaOcupado());
    }
    @Test
    public void test07UnPaisConDosEjercitosAlQuitarDosNoSigueOcupado(){

        paisPrueba.agregarEjercito(2);

        paisPrueba.eliminarEjercitos(2);

        assertFalse(paisPrueba.estaOcupado());
    }
    @Test
    public void test08TrasSumar20EjercitosLaCantidadEsCorrecta(){

        paisPrueba.agregarEjercito(20);

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
        ArrayList<Pais> fronteraPrueba = new ArrayList<>();

        paisPrueba.agregarFrontera(fronteraPrueba);

        assertFalse(paisPrueba.estaEnFrontera(segundoPais));
    }

    @Test
    public void test12SePuedenAgregarPaisesALaFrontera(){
        Pais segundoPais = new Pais("Chile");
        ArrayList<Pais> fronteraPrueba = new ArrayList<>();
        fronteraPrueba.add(segundoPais);

        paisPrueba.agregarFrontera(fronteraPrueba);

        assertTrue(paisPrueba.estaEnFrontera(segundoPais));

    }
    @Test
    public void test13SePuedenAgregarMultiplesPaisesALaFrontera(){
        Pais segundoPais = new Pais("Chile");
        Pais tercerPais = new Pais("Uruguay");
        Pais cuartoPais = new Pais("Varsil");
        ArrayList<Pais> fronteraPrueba = new ArrayList<>();

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

        paisPrueba.agregarEjercito(2);

        paisPrueba.invadir(segundoPais);

        assertEquals(1,paisPrueba.obtenerCantidadEjercitos());

    }
    @Test
    public void test15DespuesDeInvadirElEjercitoAtacanteYDefensorSonLosMismos(){
        Pais segundoPais = new Pais("Chile");
        Ejercito ejercito = new Ejercito("Azul");

        paisPrueba.asignarEjercito(ejercito);

        paisPrueba.agregarEjercito(2);

        paisPrueba.invadir(segundoPais);

        assertEquals(ejercito,paisPrueba.getEjercito());
        assertEquals(ejercito,segundoPais.getEjercito());

    }
    @Test
    public void test16TrasSumarUnEjercitoElPaisNoEsAptoParaAtacar(){

        paisPrueba.agregarEjercito(1);

        assertFalse(paisPrueba.esAptoParaAtacar());
    }
    @Test
    public void test17TrasSumarDosEjercitosElPaisEsAptoParaAtacar(){

        paisPrueba.agregarEjercito(2);

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
    @Test
    public void test19UnPaisConUnEjercitoNuncaPodriaMoverTres(){
        paisPrueba.agregarEjercito(1);

        assertFalse(paisPrueba.sePuedeMoverEstaCantidadDeEjercitos(3));

    }
    @Test
    public void test20UnPaisConDosEjercitosNuncaPodriaMoverTres(){
        paisPrueba.agregarEjercito(2);

        assertFalse(paisPrueba.sePuedeMoverEstaCantidadDeEjercitos(3));

    }
    @Test
    public void test21UnPaisConTresEjercitosNuncaPodriaMoverTres(){
        paisPrueba.agregarEjercito(3);

        assertFalse(paisPrueba.sePuedeMoverEstaCantidadDeEjercitos(3));

    }
    @Test
    public void test22UnPaisConCuatroEjercitosOMasPodriaMoverTres(){
        paisPrueba.agregarEjercito(4);

        assertTrue(paisPrueba.sePuedeMoverEstaCantidadDeEjercitos(3));

    }
    @Test
    public void test23UnPaisCon4EjercitosTieneQuePoderUsar3ParaAtacar(){
        paisPrueba.agregarEjercito(4);

        assertEquals(3, paisPrueba.tropasDisponiblesParaAtacar());
    }
}

