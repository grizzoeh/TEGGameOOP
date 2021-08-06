package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestTeg {
    @Test
    public void test01AlInicializarseSeDistribuyenTodosLosPaises(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);

        assertTrue(teg.todosLosPaisesOcupados());
    }
    @Test
    public void test02AlInicializarseLaCantidadDeJugadoresEsCorrecta(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);

        assertEquals(1, teg.cantidadJugadores());
    }
    @Test
    public void test03AlInicializarseSeComienzaEnLaFaseDeColocacionInicial(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);

        assertEquals("Etapa Inicial", teg.enQueFaseEstaElJuego());
    }
    @Test
    public void test04AlAvanzarTurnoSeSigueEnLaFaseDeColocacionInicial() {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.avanzarEtapa();

        assertEquals("Etapa Inicial", teg.enQueFaseEstaElJuego());
    }
    @Test
    public void test05AlAvanzarDosVecesElTurnoNoSeSigueEnLaFaseDeColocacionInicial() {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Ataque Entre Jugadores", teg.enQueFaseEstaElJuego());
    }




    @Test
    public void test06AlInicializarseSalteandoseLaColocacionEsFaseDeAtaque(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();
        assertEquals("Ataque Entre Jugadores", teg.enQueFaseEstaElJuego());
    }
    @Test
    public void test07AlAvanzarUnaEtapaDespuesDeSaltearSucedeLaReagrupacion(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();
        teg.avanzarEtapa();

        assertEquals("Reagrupación de Tropas", teg.enQueFaseEstaElJuego());
    }
    @Test
    public void test08AlAvanzarDosEtapasDespuesDeSaltearSucedeLaAsignacionDeNuevasFichas(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Bad Bunny");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Asignación De Fichas", teg.enQueFaseEstaElJuego());
    }
    @Test
    public void test09AlIniciarLaPartidaLeTocaAlJugador1(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("BetaTester");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);

        assertEquals("BetaTester", teg.aQueJugadorLeToca());
    }
    @Test
    public void test10CuandoUnJugadorTerminaSuTurnoPasaAlAtaqueDelSiguiente(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ozuna");
        nombresJugadores.add("Sech");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Ataque Entre Jugadores", teg.enQueFaseEstaElJuego());
    }
    @Test
    public void test11CuandoUnJugadorTerminaSuTurnoPasaAlSiguienteJugador(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ozuna");
        nombresJugadores.add("Sech");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Sech", teg.aQueJugadorLeToca());
    }
    @Test
    public void test12TrasUnaRondaEnteraLeTocaDeNuevoAlPrimerJugador(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Carzo");
        nombresJugadores.add("Diaz");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        assertEquals("Carzo", teg.aQueJugadorLeToca());
    }
    @Test
    public void test13AtacarFuncionaCorrectamente() throws EtapaEquivocadaException {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Carzo");
        nombresJugadores.add("Diaz");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        teg.asignarEjercito("Zaire", 1);

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        teg.atacar("Zaire", "Etiopia", 1);

        assertEquals(teg.cantEjercitosEn("Zaire"), 1);
        assertEquals(teg.cantEjercitosEn("Etiopia"), 1);
    }
    @Test
    public void test14MoverEjercitoFuncionaCorrectamente() throws EtapaEquivocadaException, PaisesNoSonDelMismoDuenoException, PaisSinEjercitosSuficientesException, PaisesNoContinuosException {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Carzo");
        nombresJugadores.add("Diaz");
        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        teg.saltearColocacionInicial();

        teg.avanzarEtapa();
        teg.avanzarEtapa();

        teg.asignarEjercito("Zaire", 1);

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        teg.moverEjercito("Zaire", "Madagascar", 1);

        assertEquals(teg.cantEjercitosEn("Zaire"), 1);
        assertEquals(teg.cantEjercitosEn("Madagascar"), 2);
    }
    @Test
    public void test15AlInicializarseUnJugadorNoEstaEliminado(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");

        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        ArrayList<Jugador> jugs = teg.obtenerListaJugadores();


        assertFalse( teg.jugadorEstaEliminado(jugs.get(0)));
    }
    @Test
    public void test16SeDevuelveLaCantidadCorrectaDeJugadores(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        nombresJugadores.add("Titan");
        nombresJugadores.add("Lo");

        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);
        ArrayList<Jugador> jugs = teg.obtenerListaJugadores();


        assertEquals(teg.obtenerListaJugadores().size(),3);
    }
    @Test
    public  void test17enUnJuegoConDosJugadoresCadaJugadorTiene25Paises(){
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Ricardo");
        nombresJugadores.add("Titan");

        Teg teg = new Teg(nombresJugadores, "recursos/archivosDeTexto/fronterasParaPrueba.csv",true);

        assertEquals(4, teg.paisesDelJugadorActual().size());
    }
}




