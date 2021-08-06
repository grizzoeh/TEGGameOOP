package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.distribuciondepaises.Continente;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestContinente {
    @Test
    public void test01BonusConquistaDevuelveCorrectamente(){
        Continente continente = new Continente("America del sur", 4);

        assertEquals(continente.getBonusConquista(), 4);
    }
    @Test
    public void test02JugadorControlaContinenteDeContinenteVacioEsFalse(){
        Continente continente = new Continente("America del sur", 4);
        Ejercito rojo = new Ejercito("rojo");

        assertEquals(continente.jugadorControlaContinente(rojo), false);
    }
    @Test
    public void test03JugadorControlaContinenteEsFalse(){
        Continente continente = new Continente("America del sur", 4);
        Pais pais1 = new Pais("Argentina");
        Pais pais2 = new Pais("Brasil");
        Ejercito rojo = new Ejercito("rojo");
        Ejercito azul = new Ejercito("azul");

        pais1.asignarEjercito(rojo);
        pais2.asignarEjercito(azul);
        continente.agregarPais(pais1);
        continente.agregarPais(pais2);

        assertEquals(continente.jugadorControlaContinente(rojo), false);
    }
    @Test
    public void test04JugadorControlaContinenteEsTrue(){
        Continente continente = new Continente("America del sur", 4);
        Pais pais1 = new Pais("Argentina");
        Pais pais2 = new Pais("Brasil");
        Ejercito rojo = new Ejercito("rojo");

        pais1.asignarEjercito(rojo);
        pais2.asignarEjercito(rojo);
        continente.agregarPais(pais1);
        continente.agregarPais(pais2);

        assertEquals(continente.jugadorControlaContinente(rojo), true);
    }
    @Test
    public void test04ContinenteControladoPorOtroJugadorEsFalse(){
        Continente continente = new Continente("America del sur", 4);
        Pais pais1 = new Pais("Argentina");
        Pais pais2 = new Pais("Brasil");
        Ejercito rojo = new Ejercito("rojo");
        Ejercito azul = new Ejercito("azul");

        pais1.asignarEjercito(rojo);
        pais2.asignarEjercito(rojo);
        continente.agregarPais(pais1);
        continente.agregarPais(pais2);

        assertEquals(continente.jugadorControlaContinente(azul), false);
    }
}
