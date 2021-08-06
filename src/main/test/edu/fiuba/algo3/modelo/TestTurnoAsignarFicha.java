package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoAsignarFicha;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTurnoAsignarFicha {
    Mapa mapa = new Mapa("recursos/archivosDeTexto/fronteras.csv", true);
    Ejercito rojo = new Ejercito("rojo");
    Jugador jugador = new Jugador("Fran", rojo);
    ArrayList lista = new ArrayList<>();
    TurnoAsignarFicha turno = new TurnoAsignarFicha(jugador, mapa);

    @Test
    public void test01MoverEjercitoDevuelveExepcion() {
        assertThrows(EtapaEquivocadaException.class,
                ()->{
                    turno.moverEjercito("Argentina", "Brasil", 3);
                });
    }
    @Test
    public void test02AtacarDevuelveExepcion() {
        assertThrows(EtapaEquivocadaException.class,
                ()->{
                    turno.atacar("Argentina", "Brasil", 3);
                });
    }

    @Test
    public void test04SeDevuelveLaFaseCorrecta() {
        assertEquals("Asignación De Fichas",turno.enQueFaseDelTurnoEsta());
    }
    @Test
    public void test05CanjeDeVariasTarjetasFuncionaCorrectamente() {
        lista.add(jugador);
        mapa.repartirPaises(lista);

        TurnoAsignarFicha turno = new TurnoAsignarFicha(jugador, mapa);
        turno.canjeoDeTresTarjetas();


        assertEquals(turno.getCantidadFichasTrasCanje(), 4);
        turno.canjeoDeTresTarjetas();

        assertEquals(turno.getCantidadFichasTrasCanje(), 7);
        turno.canjeoDeTresTarjetas();

        assertEquals(turno.getCantidadFichasTrasCanje(), 10);
        turno.canjeoDeTresTarjetas();

        assertEquals(turno.getCantidadFichasTrasCanje(), 15);
    }
    @Test
    public  void test06CanjearUnaTarjetaAgregaDosTropas() throws PaisNoLePerteneceException {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("Pablito Lezcano", new Ejercito("Verde"));
        jugadores.add(jugador1);
        Mapa mapa = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv", true);
        mapa.repartirPaises(jugadores);

        Pais egipto = mapa.obtenerPais("Egipto");

        Integer cantidad = egipto.obtenerCantidadEjercitos();

        TurnoAsignarFicha turnoDeColocacion = new TurnoAsignarFicha(jugador1, mapa);

        turnoDeColocacion.canjeoUnicoTarjeta("Egipto");

        assertEquals((cantidad + 2), egipto.obtenerCantidadEjercitos());


    }
    @Test
    public void testExcepcion01CanjeoDeTarjetaDevuelveExcepcionSiNoLePerteneceElPais() {
        Ejercito azul = new Ejercito("azul");
        Jugador jugadorAux = new Jugador("Rodolfo", azul);
        lista.add(jugador);
        lista.add(jugadorAux);
        mapa.repartirPaises(lista);
        TurnoAsignarFicha turno = new TurnoAsignarFicha(jugador, mapa);

        assertThrows(PaisNoLePerteneceException.class,
                () -> {
                    turno.canjeoUnicoTarjeta("Madagascar");
                });
    }
    @Test
    public void testExcepcion02AsignarEjercitoDevuelveExcepcionSiNoLePerteneceElPais() {
        Ejercito azul = new Ejercito("azul");
        Jugador jugadorAux = new Jugador("Rodolfo", azul);
        lista.add(jugador);
        lista.add(jugadorAux);
        mapa.repartirPaises(lista);
        TurnoAsignarFicha turno = new TurnoAsignarFicha(jugador, mapa);

        assertThrows(PaisNoLePerteneceException.class,
                () -> {
                    turno.asignarEjercito("Madagascar", 1);
                });
    }
}
