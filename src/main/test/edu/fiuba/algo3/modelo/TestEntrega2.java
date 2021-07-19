package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//El codigo esta comentado para poder compilar sin problemas
public class TestEntrega2 {

    @Test
    public void test01ActivacionDeTarjetas() throws PaisNoLePerteneceException {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador1 = new Jugador("Pablito Lezcano", new Ejercito("Verde"));
        jugadores.add(jugador1);
        Mapa mapa = new Mapa();
        mapa.repartirPaises(jugadores);
        Pais egipto = mapa.obtenerPais("Egipto");
        Tarjeta tarjeta = new Tarjeta(egipto, "Barco");

        jugador1.agregarTarjeta(tarjeta);

        Tarjeta tarjetaDelJugador = jugador1.usarTarjeta(egipto);

        TurnoAsignarFicha turnoDeColocacion = new TurnoAsignarFicha(jugador1, mapa);

        turnoDeColocacion.canjeoDeTarjeta("Egipto");


        assertEquals(5, egipto.obtenerCantidadEjercitos());
        assertEquals(1, jugador1.cuantosCanjesRealizados());


    }

    @Test
    public void test02RondaDeDosJugadoresConColocacionDeEjercitos() throws EtapaEquivocadaException, PaisNoLePerteneceException {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        nombresJugadores.add("Gonza");
        nombresJugadores.add("Fran");

        Teg teg = new Teg(nombresJugadores);
        teg.avanzarEtapa();
        teg.avanzarEtapa();

        teg.asignarEjercito("Madagascar",1);

        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.avanzarEtapa();
        teg.asignarEjercito("Etiopia",1);

        assertEquals(2, teg.cantEjercitosEn("Madagascar"));
        assertEquals(2, teg.cantEjercitosEn("Etiopia"));

    }
    @Test
    public void test03RondaDeTresJugadoresConColocacionDeEjercitos(){


    }
    @Test
    public void test04RondaDeDosJugadoresConAtaqueYConquistaDeDosPaises(){

    }

}


