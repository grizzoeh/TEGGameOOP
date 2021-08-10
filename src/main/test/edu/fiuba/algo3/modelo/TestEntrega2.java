package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoJugable;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoAsignarFicha;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Tarjeta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEntrega2 {
    @Test
    public void test01ActivacionDeTarjetas() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("Pablito Lezcano", new Ejercito("Verde"));
        jugadores.add(jugador1);
        Mapa mapa = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv", true);
        mapa.repartirPaises(jugadores);
        Pais egipto = mapa.obtenerPais("Egipto");
        Tarjeta tarjeta = new Tarjeta(egipto, "Barco");

        jugador1.agregarTarjeta(tarjeta);

        Tarjeta tarjetaDelJugador = jugador1.getTarjeta(egipto.obtenerNombre());

        TurnoAsignarFicha turnoDeColocacion = new TurnoAsignarFicha(jugador1, mapa);

        turnoDeColocacion.canjeoUnicoTarjeta("Egipto");

        assertEquals(3, egipto.obtenerCantidadEjercitos());
    }
    @Test
    public void test02RondaDeDosJugadoresConColocacionDeEjercitos() throws EtapaEquivocadaException, PaisNoLePerteneceException {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Gonza");
        nombresJugadores.add("Fran");

        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        teg.asignarEjercito("Madagascar",1);

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.asignarEjercito("Egipto",1);

        assertEquals(2, teg.cantEjercitosEn("Madagascar"));
        assertEquals(2, teg.cantEjercitosEn("Egipto"));
    }
    @Test
    public void test03RondaDeTresJugadoresConColocacionDeEjercitos() throws EtapaEquivocadaException, PaisNoLePerteneceException {
        ArrayList<Jugador> jugadores = new ArrayList<>();

        Ejercito ejercitoJugador2 = new Ejercito("Azul");

        Jugador jugador1 = new Jugador("Briasco", new Ejercito("Verde"));
        Jugador jugador2 = new Jugador("Pavon", ejercitoJugador2);
        Jugador jugador3 = new Jugador("Villa", new Ejercito("Amarillo"));

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);

        Mapa mapa = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv", true);
        mapa.repartirPaises(jugadores);

        Pais turquia = mapa.obtenerPais("Turquia");
        Pais arabia = mapa.obtenerPais("Arabia");

        turquia.asignarEjercito(ejercitoJugador2);
        arabia.asignarEjercito(ejercitoJugador2);

        TurnoJugable turnoJugable;

        turnoJugable = new TurnoAsignarFicha(jugador2, mapa); // Para asignar los ejercitos por continente.
        turnoJugable.asignarEjercito("Arabia", 1);

        turnoJugable = new TurnoAsignarFicha(jugador1, mapa);
        turnoJugable.asignarEjercito("Egipto", 1);

        turnoJugable = new TurnoAsignarFicha(jugador2, mapa);
        turnoJugable.asignarEjercito("Arabia", 7);

        turnoJugable = new TurnoAsignarFicha(jugador3, mapa);
        turnoJugable.asignarEjercito("Sahara", 1);

        assertTrue(mapa.jugadorControlaContinente("Asia", jugador2));

        assertEquals(2, mapa.numeroEjercitosEn("Egipto"));

        assertEquals(9, mapa.numeroEjercitosEn("Arabia"));

        assertEquals(2, mapa.numeroEjercitosEn("Sahara"));
    }
    @Test
    public void test04RondaDeDosJugadoresConAtaqueYConquistaDeDosPaises() throws EtapaEquivocadaException, PaisNoLePerteneceException {
        ArrayList<Jugador> jugadores = new ArrayList<>();

        Ejercito ejercitoJug1 = new Ejercito("Verde");

        Jugador jugador1 = new Jugador("Ribery", ejercitoJug1);
        Jugador jugador2 = new Jugador("Toto Salvio", new Ejercito("Amarillo"));

        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Mapa mapa = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv", true);
        mapa.repartirPaises(jugadores);

        Integer cantidadDePaisesDominadosPorJug1 = mapa.paisesConEjercito(ejercitoJug1);

        Pais madagascar = mapa.obtenerPais("Madagascar");
        Pais zaire = mapa.obtenerPais("Zaire");
        Pais egipto = mapa.obtenerPais("Egipto");
        Pais sudafrica = mapa.obtenerPais("Sudafrica");

        madagascar.agregarEjercito(2);
        zaire.agregarEjercito(2);

        CombateMock combate = new CombateMock(madagascar,egipto,2);
        combate.generarCombateAtacanteGanador();

        combate = new CombateMock(zaire, sudafrica, 2);
        combate.generarCombateAtacanteGanador();

        assertEquals(ejercitoJug1, mapa.ejercitoEnPais("Egipto"));
        assertEquals(ejercitoJug1, mapa.ejercitoEnPais("Sudafrica"));

        assertEquals(1, mapa.numeroEjercitosEn("Egipto"));
        assertEquals(1, mapa.numeroEjercitosEn("Sudafrica"));

        assertEquals((cantidadDePaisesDominadosPorJug1 + 2), mapa.paisesConEjercito(ejercitoJug1));
    }
}


