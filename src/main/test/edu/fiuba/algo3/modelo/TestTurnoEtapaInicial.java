package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoEtapaInicial;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Mazo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestTurnoEtapaInicial {
    Mapa mapa = new Mapa("recursos/archivosDeTexto/fronteras.csv", true);
    Ejercito azul = new Ejercito("Azul");
    Mazo mazo = new Mazo(mapa.listaPaises());
    Jugador jugador = new Jugador("Tomi", azul);
    ArrayList<Jugador> listaJugadores = new ArrayList<>();
    TurnoEtapaInicial turno;

    public TestTurnoEtapaInicial() {
        listaJugadores.add(jugador);
        turno = new TurnoEtapaInicial(listaJugadores,0, mapa,5, mazo);
    }

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
    public void test03CanjearUnaDevuelveExepcion() {
        assertThrows(EtapaEquivocadaException.class,
                ()->{
                    turno.canjeoUnicoTarjeta("Fiumba");
                });
    }

    @Test
    public void test04CanjearTresDevuelveExepcion() {
        assertThrows(EtapaEquivocadaException.class,
                ()->{
                    turno.canjeoDeTresTarjetas();
                });
    }

    @Test
    public void test05PorDefectoNoEstanTodasLasFichasColocadas() {
        assertFalse(turno.todasLasFichasColocadas());
    }

    @Test
    public void test06SeDevuelveLaFaseCorrecta() {
        assertEquals("Etapa Inicial",turno.enQueFaseDelTurnoEsta());
    }

    @Test
    public void test07PorDefectoNoEstaFinalizado() {
        assertFalse(turno.estaFinalizado());
    }
}
