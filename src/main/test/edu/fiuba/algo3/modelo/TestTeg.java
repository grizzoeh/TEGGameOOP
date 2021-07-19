package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTeg {
    @Test
    public void test01AlInicializarseSeDistribuyenTodosLosPaises(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores);

        assertTrue(teg.todosLosPaisesOcupados());

    }
    @Test
    public void test02AlInicializarseLaCantidadDeJugadoresEsCorrecta(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores);

        assertEquals(1, teg.cantidadJugadores());

    }
    @Test
    public void test03AlInicializarseSeComienzaEnLaFaseDeAtaque(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores);

        assertEquals("Ataque Entre Jugadores", teg.enQueFaseEstaElJuego());

    }
    @Test
    public void test04AlAvanzarUnaEtapaSucedeLaReagrupacion(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores);
        teg.avanzarEtapa();

        assertEquals("Reagrupación de Tropas", teg.enQueFaseEstaElJuego());

    }
    @Test
    public void test05AlAvanzarDosEtapasSucedeLaAsignacionDeNuevasFichas(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Bad Bunny");
        Teg teg = new Teg(nombresJugadores);
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Asignación De Fichas", teg.enQueFaseEstaElJuego());

    }
    @Test
    public void test06AlIniciarLaPartidaLeTocaAlJugador1(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("BetaTester");
        Teg teg = new Teg(nombresJugadores);

        assertEquals("BetaTester", teg.aQueJugadorLeToca());
    }

    @Test
    public void test07CuandoUnJugadorTerminaSuTurnoPasaAlAtaqueDelSiguiente(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ozuna");
        nombresJugadores.add("Sech");
        Teg teg = new Teg(nombresJugadores);
        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Ataque Entre Jugadores", teg.enQueFaseEstaElJuego());

    }
    @Test
    public void test08CuandoUnJugadorTerminaSuTurnoPasaAlSiguienteJugador(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ozuna");
        nombresJugadores.add("Sech");
        Teg teg = new Teg(nombresJugadores);
        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Sech", teg.aQueJugadorLeToca());

    }
    @Test
    public void test09TrasUnaRondaEnteraLeTocaDeNuevoAlPrimerJugador(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Carzo");
        nombresJugadores.add("Diaz");
        Teg teg = new Teg(nombresJugadores);
        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Carzo", teg.aQueJugadorLeToca());

    }
}
