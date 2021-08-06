package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;
import edu.fiuba.algo3.modelo.gestiondeturnos.*;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Mazo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestTurnoFinalizado {
    TurnoFinalizado turno;



    public TestTurnoFinalizado() {
        turno = new TurnoFinalizado();
    }
    @Test
    public  void test01UnTurnoFinalizadoEstaFinalizado(){
        assertTrue(turno.estaFinalizado());
    }
    @Test
    public void test02UnTurnoFinalizadoEstaEnFaseFinalizada(){
        assertEquals(turno.enQueFaseDelTurnoEsta(), "Turno Finalizado");
    }
}
