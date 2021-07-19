package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTurnoAsignarFicha {
    Mapa mapa = new Mapa();
    Ejercito rojo = new Ejercito("rojo");
    Jugador jugador = new Jugador("Fran", rojo);
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
    public void test04SeDevuelveLaFaseCorrecta(){
        assertEquals("Asignación De Fichas",turno.enQueFaseDelTurnoEsta());
    }
}
