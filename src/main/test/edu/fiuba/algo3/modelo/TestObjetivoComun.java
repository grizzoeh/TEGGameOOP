package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.objetivosytarjetas.ObjetivoComun;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestObjetivoComun {
    Ejercito ejercito = new Ejercito("Amarillo");
    Mapa mapa = new Mapa("recursos/archivosDeTexto/fronterasParaPrueba.csv", true);
    @Test
    public void test01SeDevuelveElObjetivoCorrectamente(){
        ObjetivoComun objetivoComun = new ObjetivoComun(mapa);

        assertEquals(objetivoComun.mostrarObjetivo(), "Ocupar 30 países.");

    }
    @Test
    public void test02AlRecienIniciarUnMapaElObjetivoNoEstaCumplido(){
        ObjetivoComun objetivoComun = new ObjetivoComun(mapa);

        assertFalse(objetivoComun.objetivoCumplido(ejercito));
    }
}
