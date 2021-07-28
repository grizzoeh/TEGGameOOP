package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;
import edu.fiuba.algo3.modelo.gestiondeturnos.Turno;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoAsignarFicha;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoReagrupar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTurnoReagrupar {
    Mapa mapa = new Mapa("archivosDeTexto/fronterasParaPrueba.csv");
    Ejercito rojo = new Ejercito("rojo");
    Jugador jugador = new Jugador("Fran", rojo);
    ArrayList lista = new ArrayList<>();
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
    @Test
    public void testExcepcion01MoverEjercitoConPaisEnemigoDaExcepcion() {
        Ejercito azul = new Ejercito("azul");
        Jugador jugadorAux = new Jugador("Rodolfo", azul);
        lista.add(jugador);
        lista.add(jugadorAux);
        mapa.repartirPaises(lista);
        TurnoReagrupar turno = new TurnoReagrupar(jugador, mapa);

        assertThrows(PaisNoLePerteneceException.class,
                () -> {
                    turno.moverEjercito("Etiopia", "Madagascar",1);
                });
    }
}
