package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {
    Jugador jugador = new Jugador("Nicolas", new Ejercito("Verde"));

    @Test
    public void test01JugadorGuardaSuEjercitoCorrectamente() {
        Ejercito ejercitoAux = this.jugador.getEjercito();

        assertEquals("Verde", ejercitoAux.getColor());
    }

    @Test
    public void test02JugadorGuardaSuNombreCorrectamente(){
        assertEquals("Nicolas", this.jugador.getNombre());
    }

    @Test
    public void test03LaCantidadDeCanjesInicialesEsCero(){

        assertEquals(0, jugador.cuantosCanjesRealizados());
    }
    @Test
    public void test04LaCantidadDeCanjesSeActualizaCorrectamenteAlAniadirUnCanje(){

        jugador.agregarCanje();

        assertEquals(1, jugador.cuantosCanjesRealizados());
    }
    @Test
    public void test05LaCantidadDeCanjesSeActualizaCorrectamenteAlAniadirVariosCanjes(){

        jugador.agregarCanje();
        jugador.agregarCanje();
        jugador.agregarCanje();
        jugador.agregarCanje();

        assertEquals(4, jugador.cuantosCanjesRealizados());
    }
    @Test
    public void test06LaCantidadDeTarjetasInicialesEsCero(){
        assertEquals(0, jugador.cantidadDeTarjetas());
    }
    @Test
    public void test07LaCantidadDeTarjetasTrasAgregarUnaEsCorrecta(){
        Pais pais = new Pais("Suiza");
        Tarjeta tarjeta = new Tarjeta(pais, "Chocolate Suizo");

        jugador.agregarTarjeta(tarjeta);

        assertEquals(1, jugador.cantidadDeTarjetas());
    }
    @Test
    public void test08LaCantidadDeTarjetasTrasUsarUnaEsCorrecta(){
        Pais pais = new Pais("Suiza");
        Tarjeta tarjeta = new Tarjeta(pais, "Chocolate Suizo");

        jugador.agregarTarjeta(tarjeta);
        jugador.usarTarjeta(pais);

        assertEquals(0, jugador.cantidadDeTarjetas());
    }
}
