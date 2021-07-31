package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.aexcepciones.NoExisteTarjetaParaElPaisException;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Mazo;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Tarjeta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestMazo {

    @Test
    public void test01AlCrearseLaCantidadDeTarjetasCorrespondeConLaCantidadDePaises(){
        Pais paisAux = new Pais("Qatar");
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(paisAux);

        Mazo mazo = new Mazo(paises);

        assertEquals(1, mazo.cantidadDeTarjetasEnElMazo());
    }
    @Test
    public void test02AlCrearseLaCantidadDeTarjetasRepartidasEsCero(){
        ArrayList<Pais> paises = new ArrayList<>();

        Mazo mazo = new Mazo(paises);

        assertEquals(0, mazo.cantidadDeTarjetasRepartidas());
    }
    @Test
    public void test03DosTarjetasConMismoSimboloNoSerianCanjeables(){

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        Pais paisAux = new Pais("Qatar");
        ArrayList<Pais> paises = new ArrayList<>();

        tarjetas.add(new Tarjeta(paisAux, "Barco"));
        tarjetas.add(new Tarjeta(paisAux, "Globo"));
        tarjetas.add(new Tarjeta(paisAux, "Globo"));

        Mazo mazo = new Mazo(paises);

        assertFalse(mazo.sonAptasParaCanje(tarjetas));
    }
    @Test
    public void test04TresTarjetasConElMismoSimboloSonCanjeables(){

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        Pais paisAux = new Pais("Qatar");
        ArrayList<Pais> paises = new ArrayList<>();
        tarjetas.add(new Tarjeta(paisAux, "Barco"));
        tarjetas.add(new Tarjeta(paisAux, "Barco"));
        tarjetas.add(new Tarjeta(paisAux, "Barco"));
        Mazo mazo = new Mazo(paises);

        assertTrue(mazo.sonAptasParaCanje(tarjetas));
    }
    @Test
    public void test05TresTarjetasDeSimbolosDistintos(){

        ArrayList<Tarjeta> tarjetas = new ArrayList<>();
        Pais paisAux = new Pais("Qatar");
        ArrayList<Pais> paises = new ArrayList<>();

        tarjetas.add(new Tarjeta(paisAux, "Barco"));
        tarjetas.add(new Tarjeta(paisAux, "Globo"));
        tarjetas.add(new Tarjeta(paisAux, "Cañon"));

        Mazo mazo = new Mazo(paises);

        assertTrue(mazo.sonAptasParaCanje(tarjetas));
    }
    @Test
    public void test06ObtenerUnaTarjetaEspecificaDevuelveLaTarjetaBuscada() throws NoExisteTarjetaParaElPaisException {
        Pais paisAux = new Pais("Qatar");
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(paisAux);

        Mazo mazo = new Mazo(paises);

        Tarjeta tarjetaABuscar = mazo.obtenerTarjetaEspecifica(paisAux);

        assertEquals(tarjetaABuscar.obtenerPais(), paisAux);
    }
    @Test
    public void test07SiNoExisteLaTarjetaBuscadaSeDevuelveNull() throws NoExisteTarjetaParaElPaisException {
        Pais paisAux = new Pais("Qatar");
        ArrayList<Pais> paises = new ArrayList<>();

        Mazo mazo = new Mazo(paises);

        Tarjeta tarjetaABuscar = mazo.obtenerTarjetaEspecifica(paisAux);

        assertEquals(null, tarjetaABuscar);
    }
    @Test
    public void test08TrasRepartirTarjetaSeActualizanCantidadesCorrectamente(){
        Pais paisAux = new Pais("Qatar");
        ArrayList<Pais> paises = new ArrayList<>();
        paises.add(paisAux);

        Mazo mazo = new Mazo(paises);

        mazo.repartirTarjeta();

        assertEquals(0, mazo.cantidadDeTarjetasEnElMazo());
        assertEquals(1, mazo.cantidadDeTarjetasRepartidas());
    }

    @Test
    public void test09PedirleTarjetasAUnMazoVacioDevuelveNull(){
        ArrayList<Pais> paises = new ArrayList<>();
        Mazo mazo = new Mazo(paises);

        Tarjeta eliminada = mazo.repartirTarjeta();

        assertTrue(eliminada == null);
    }
}
