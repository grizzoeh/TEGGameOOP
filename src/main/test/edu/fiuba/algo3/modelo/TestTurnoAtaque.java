package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTurnoAtaque {
    Mapa mapa = new Mapa();
    Ejercito rojo = new Ejercito("rojo");
    Jugador jugador = new Jugador("Fran", rojo);
    TurnoAtaque turno = new TurnoAtaque(jugador, mapa);

    @Test
    public void test01AsignarEjercitoDevuelveExepcion() {
        assertThrows(EtapaEquivocadaException.class,
                ()->{
                    turno.asignarEjercito("Argentina", 3);
                });
    }
    @Test
    public void test02ReagruparDevuelveExepcion() {
        assertThrows(EtapaEquivocadaException.class,
                ()->{
                    turno.moverEjercito("Argentina", "Brasil", 3);
                });
    }
    @Test
    public void test03AvanzarEtapaDevuelveTurnoReagrupar() {
        Turno actual = turno.avanzarEtapa();
        Turno real = new TurnoReagrupar(jugador, mapa);
        assertEquals(actual.getClass(), real.getClass());
    }
}
