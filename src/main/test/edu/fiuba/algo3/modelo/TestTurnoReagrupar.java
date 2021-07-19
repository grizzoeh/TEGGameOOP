package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTurnoReagrupar {
    Mapa mapa = new Mapa();
    Ejercito rojo = new Ejercito("rojo");
    Jugador jugador = new Jugador("Fran", rojo);
    TurnoReagrupar turno = new TurnoReagrupar(jugador, mapa);

    @Test
    public void test01AsignarEjercitoDevuelveExepcion() {
        assertThrows(EtapaEquivocadaException.class,
                ()->{
                    turno.asignarEjercito("Argentina", 3);
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
    public void test03AvanzarEtapaDevuelveTurnoAsignarFicha() {
        Turno actual = turno.avanzarEtapa();
        Turno real = new TurnoAsignarFicha(jugador, mapa);
        assertEquals(actual.getClass(), real.getClass());
    }
    @Test
    public void test04SeDevuelveLaFaseCorrecta(){
        assertEquals("Reagrupación de Tropas",turno.enQueFaseDelTurnoEsta());
    }
}
