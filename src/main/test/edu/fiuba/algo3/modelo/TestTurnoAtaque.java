package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoJugable;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoAtaque;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoReagrupar;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Mazo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTurnoAtaque {
    Mapa mapa = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv", true);
    Ejercito rojo = new Ejercito("rojo");
    Jugador jugador = new Jugador("Fran", rojo);
    Mazo mazo = new Mazo(mapa.listaPaises());
    ArrayList lista = new ArrayList<>();
    TurnoAtaque turno = new TurnoAtaque(jugador, mapa, mazo);

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
        TurnoJugable actual = (TurnoJugable)turno.avanzarEtapa();
        TurnoJugable real = new TurnoReagrupar(jugador, mapa);
        assertEquals(actual.getClass(), real.getClass());
    }
    @Test
    public void test04SeDevuelveLaFaseCorrecta(){
        assertEquals("Ataque Entre Jugadores",turno.enQueFaseDelTurnoEsta());
    }
    @Test
    public void testExcepcion01AtacarConPaisEnemigoDaExcepcion() {
        Ejercito azul = new Ejercito("azul");
        Jugador jugadorAux = new Jugador("Rodolfo", azul);
        lista.add(jugador);
        lista.add(jugadorAux);
        mapa.repartirPaises(lista);
        TurnoAtaque turno = new TurnoAtaque(jugador, mapa, mazo);

        assertThrows(PaisNoLePerteneceException.class,
                () -> {
                    turno.atacar("Etiopia", "Madagascar",1);
                });
    }
}
