package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestObjetivoComun {
    Ejercito ejercito = new Ejercito("Amarillo");
    Mapa mapa = new Mapa("archivosDeTexto/fronterasParaPrueba.csv");
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
