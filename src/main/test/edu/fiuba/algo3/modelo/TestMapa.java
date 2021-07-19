package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PaisSinEjercitosSuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisesConMismoDuenoException;
import edu.fiuba.algo3.modelo.excepciones.PaisesNoContinuosException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMapa {
    Mapa mapa = new Mapa();
    @Test
    public void test01TodosLosPaisesSeInicializanConAlMenosUnEjercito() {
        ArrayList<Jugador> jugadores = new ArrayList<>();

        Jugador jugador1 = new Jugador("Estebanquito", new Ejercito("Blanquito"));
        jugadores.add(jugador1);
        mapa.repartirPaises(jugadores);

        assertTrue(mapa.todosLosPaisesOcupados());
    }

    @Test
    public void test02TodosLosPaisesSeRepartenCuandoHayMasDeUnJugador(){
        ArrayList<Jugador> jugadores = new ArrayList<>();

        Jugador jugador1 = new Jugador("Estebanquito", new Ejercito("Blanquito"));
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador("Esteban", new Ejercito("Blanco"));
        jugadores.add(jugador2);

        mapa.repartirPaises(jugadores);

        assertTrue(mapa.todosLosPaisesOcupados());

    }

    @Test
    public void test03TodosLosPaisesSeRepartenEquitativamente(){
        ArrayList<Jugador> jugadores = new ArrayList<>();

        Jugador jugador1 = new Jugador("Estebanquito", new Ejercito("Blanquito"));
        jugadores.add(jugador1);
        Jugador jugador2 = new Jugador("Esteban", new Ejercito("Blanco"));
        jugadores.add(jugador2);

        mapa.repartirPaises(jugadores);

        assertEquals(4, mapa.paisesConEjercito(jugador2.getEjercito()));
    }
    @Test
    public void test04DosPaisesVecinosSonContiguos(){

        Pais origen = mapa.obtenerPais("Egipto");
        Pais destino = mapa.obtenerPais("Madagascar");

        assertTrue(mapa.sonContiguos(origen,destino));
    }
    @Test
    public void test05DosPaisesNOVecinosNOSonContiguos(){

        Pais origen = mapa.obtenerPais("Sahara");
        Pais destino = mapa.obtenerPais("Madagascar");
        assertFalse(mapa.sonContiguos(origen,destino));
    }
    @Test
    public void test06DosPaisesVecinosConElMismoDuenioConMasDeUnEjercitoPuedeIntercambiarTropas(){
        Ejercito ejercito = new Ejercito("Blanco");

        Pais origen = mapa.obtenerPais("Egipto");
        Pais destino = mapa.obtenerPais("Madagascar");

        origen.asignarEjercito(ejercito);
        destino.asignarEjercito(ejercito);
        origen.agregarEjercito(3);
        destino.agregarEjercito(1);

        mapa.moverEjercitos("Egipto","Madagascar", 2);

        assertEquals(3 ,destino.obtenerCantidadEjercitos());

    }

    /*
    @Test
    public void test07ConNingunCanjeSeSuman4Ejercitos(){
        Ejercito ejercito = new Ejercito("Blanco");

        Pais pais = mapa.obtenerPais("Egipto");

        mapa.canjeoDeTarjeta(0,pais);

        assertEquals(4 ,pais.obtenerCantidadEjercitos());

    }
    @Test
    public void test08ConUnCanjeSeSuman7Ejercitos(){
        Ejercito ejercito = new Ejercito("Blanco");

        Pais pais = mapa.obtenerPais("Egipto");

        mapa.canjeoDeTarjeta(1,pais);

        assertEquals(7 ,pais.obtenerCantidadEjercitos());

    }
    @Test
    public void test09ConDosCanjesSeSuman10Ejercitos(){
        Ejercito ejercito = new Ejercito("Blanco");

        Pais pais = mapa.obtenerPais("Egipto");

        mapa.canjeoDeTarjeta(2,pais);

        assertEquals(10 ,pais.obtenerCantidadEjercitos());

    }
    @Test
    public void test10ConTresCanjesSeSuman15Ejercitos(){
        Ejercito ejercito = new Ejercito("Blanco");

        Pais pais = mapa.obtenerPais("Egipto");

        mapa.canjeoDeTarjeta(3,pais);

        assertEquals(15 ,pais.obtenerCantidadEjercitos());

    }
    @Test
    public void test11ConCuatroCanjesSeSuman20Ejercitos(){
        Ejercito ejercito = new Ejercito("Blanco");

        Pais pais = mapa.obtenerPais("Egipto");

        mapa.canjeoDeTarjeta(4,pais);

        assertEquals(20 ,pais.obtenerCantidadEjercitos());

    }
    @Test
    public void test11ConCienCanjesSeSuman500Ejercitos(){
        Ejercito ejercito = new Ejercito("Blanco");

        Pais pais = mapa.obtenerPais("Egipto");

        mapa.canjeoDeTarjeta(100,pais);

        assertEquals(500 ,pais.obtenerCantidadEjercitos());

    }

    */
    @Test
    //Este Test Podria no llegar a pasar si no se posee JUNIT 5
    public void testExcepcionO1NoSePuedeRealizarUnAtaqueSiLosPaisesNoSonContiguos() {
        assertThrows(PaisesNoContinuosException.class,
                () -> {
                    mapa.atacar("Sahara", "Madagascar", 3);
                });

    }
    @Test
    //Este Test Podria no llegar a pasar si no se posee JUNIT 5
    public void testExcepcionO2NoSePuedeRealizarUnAtaqueSiLosPaisesTienenElMismoDueño() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = new Jugador("Esteban", new Ejercito("Blanco"));
        jugadores.add(jugador);

        mapa.repartirPaises(jugadores);

        assertThrows(PaisesConMismoDuenoException.class,
                () -> {
                    mapa.atacar("Sahara", "Egipto", 3);
                });

    }


}



