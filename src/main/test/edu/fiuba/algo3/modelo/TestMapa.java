package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMapa {
    Mapa mapa = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv", true);
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
    public void test06DosPaisesVecinosConElMismoDuenioConMasDeUnEjercitoPuedeIntercambiarTropas() throws PaisesNoSonDelMismoDuenoException, PaisSinEjercitosSuficientesException, PaisesNoContinuosException {
        Ejercito ejercito = new Ejercito("Blanco");

        Pais origen = mapa.obtenerPais("Egipto");
        Pais destino = mapa.obtenerPais("Madagascar");

        origen.asignarEjercito(ejercito);
        destino.asignarEjercito(ejercito);
        origen.agregarEjercito(3);
        destino.agregarEjercito(1);

        try {
            mapa.moverEjercitos("Egipto","Madagascar", 2);

        }catch (PaisesNoSonDelMismoDuenoException e) {
            e.printStackTrace();
        }


        assertEquals(3 ,destino.obtenerCantidadEjercitos());
    }
    @Test
    public void test07MapaAtacarFuncionaCorrectamenteEnCasoQuePuedeAtacar() {
        Mapa mapaAux = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("Esteban", new Ejercito("Blanco"));
        Jugador jugador2 = new Jugador("Franco", new Ejercito("Rojo"));
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        mapaAux.agregarEjercitos("Zaire", 1);
        mapaAux.repartirPaises(jugadores);
        try {
            mapaAux.atacar("Zaire", "Etiopia", 1);
        } catch (PaisesConMismoDuenoException e) {
            e.printStackTrace();
        } catch (PaisSinEjercitosSuficientesException e) {
            e.printStackTrace();
        } catch (PaisesNoContinuosException e) {
            e.printStackTrace();
        }

        assertEquals(mapaAux.numeroEjercitosEn("Zaire"), 1);
        assertEquals(mapaAux.numeroEjercitosEn("Etiopia"), 1);
    }

    @Test
    public void testExcepcionO1NoSePuedeRealizarUnAtaqueSiLosPaisesNoSonContiguos() {
        assertThrows(PaisesNoContinuosException.class,
                () -> {
                    mapa.atacar("Sahara", "Madagascar", 3);
                });
    }
    @Test
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
    @Test
    public void testExcepcionO3NoSePuedeRealizarUnAtaqueSiElAtacanteTieneUnEjercito() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("Esteban", new Ejercito("Blanco"));
        Jugador jugador2 = new Jugador("Franco", new Ejercito("Rojo"));
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        mapa.repartirPaises(jugadores);

        assertThrows(PaisSinEjercitosSuficientesException.class,
                () -> {
                    mapa.atacar("Zaire", "Etiopia", 1);
                });
    }
    @Test public void testExcepcion04SiNoExisteUnPaisSeDevuelveExcepcion(){

        assertThrows(NoExisteEsePaisException.class,
                () -> {
                    mapa.obtenerPais("Suiza");
                });
    }
}