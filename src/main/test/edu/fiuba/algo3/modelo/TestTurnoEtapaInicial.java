package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestTurnoEtapaInicial {
    Mapa mapa = new Mapa();
    Ejercito azul = new Ejercito("Azul");
    Jugador jugador = new Jugador("Tomi", azul);
    ArrayList lista = new ArrayList<>();
    TurnoEtapaInicial turno = new TurnoEtapaInicial(jugador, mapa,5);

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
