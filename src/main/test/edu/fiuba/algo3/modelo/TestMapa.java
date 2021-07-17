package edu.fiuba.algo3.modelo;

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

        assertEquals(3, mapa.paisesConEjercito(jugador2.getEjercito()));
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

    /*@Test
    public void TestExcepcionO1NoSePuedeRealizarUnAtaqueSiLosPaisesNoSonContiguos() throws Exception{
        mapa.atacar("Sahara", "Madagascar", 3);
    }*/
}

