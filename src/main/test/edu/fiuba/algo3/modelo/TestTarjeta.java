package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTarjeta {
    @Test
    public void test01ObtenerSimboloDevuelveElSimboloCorrecto(){
        Pais pais = new Pais("Argentina");
        Tarjeta tarjeta = new Tarjeta(pais, "Globo");

        assertEquals(tarjeta.obtenerSimbolo(), "Globo");
    }
    @Test
    public void test02ObtenerPaisDevuelveElPaisCorrecto(){
        Pais pais = new Pais("Argentina");
        Tarjeta tarjeta = new Tarjeta(pais, "Globo");

        assertEquals(tarjeta.obtenerPais(), pais);
    }
    @Test
    public void test03FueCambiadaEsFalsePorDefecto(){
        Pais pais = new Pais("Argentina");
        Tarjeta tarjeta = new Tarjeta(pais, "Globo");

        assertEquals(tarjeta.fueCambiada(), false);
    }
    @Test
    public void test04FueCambiadaEsTrueSiSeCambia(){
        Pais pais = new Pais("Argentina");
        Tarjeta tarjeta = new Tarjeta(pais, "Globo");

        tarjeta.canjearTarjeta();

        assertEquals(tarjeta.fueCambiada(), true);
    }
    @Test
    public void test05PerteneceAlPaisEsFalse(){
        Pais pais = new Pais("Argentina");
        Tarjeta tarjeta = new Tarjeta(pais, "Globo");
        Pais paisAux = new Pais("Brasil");

        assertEquals(tarjeta.perteneceAEstePais(paisAux), false);
    }
    @Test
    public void test06PerteneceAlPaisEsTrue(){
        Pais pais = new Pais("Argentina");
        Tarjeta tarjeta = new Tarjeta(pais, "Globo");

        assertEquals(tarjeta.perteneceAEstePais(pais), true);
    }
}
