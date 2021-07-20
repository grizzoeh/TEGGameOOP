package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;
import edu.fiuba.algo3.modelo.excepciones.PaisesConMismoDuenoException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTurnoAsignarFicha {
    Mapa mapa = new Mapa();
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
    public void test03AvanzarEtapaDevuelveNull() {
        assertEquals(turno.avanzarEtapa(), null);
    }

    @Test
    public void test04SeDevuelveLaFaseCorrecta() {
        assertEquals("Asignación De Fichas",turno.enQueFaseDelTurnoEsta());
    }
    @Test
    public void test05CanjeFuncionaCorrectamente() throws PaisNoLePerteneceException {
        lista.add(jugador);
        mapa.repartirPaises(lista);
        TurnoAsignarFicha turno = new TurnoAsignarFicha(jugador, mapa);
        turno.canjeoDeTarjeta("Zaire");

        assertEquals(mapa.numeroEjercitosEn("Zaire"), 5);
        turno.canjeoDeTarjeta("Zaire");

        assertEquals(mapa.numeroEjercitosEn("Zaire"), 12);
        turno.canjeoDeTarjeta("Zaire");

        assertEquals(mapa.numeroEjercitosEn("Zaire"), 22);
        turno.canjeoDeTarjeta("Zaire");

        assertEquals(mapa.numeroEjercitosEn("Zaire"), 37);
        turno.canjeoDeTarjeta("Zaire");

        assertEquals(mapa.numeroEjercitosEn("Zaire"), 57);
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
                    turno.canjeoDeTarjeta("Etiopia");
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
                    turno.asignarEjercito("Etiopia", 1);
                });
    }
}
