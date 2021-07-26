package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestObjetivoParticular {

    Continente continente1 =   new Continente("Prueba", 2);
    Pais pais = new Pais("Argentina");
    Ejercito ejercito = new Ejercito("Azul");
    ArrayList<Subobjetivo> subObje = new ArrayList<Subobjetivo>();

    @Test
    public void test01SeDevuelveElObjetivoCorrectamente(){
        ObjetivoParticular objetivoParticular = new ObjetivoParticular("Conquistar Un Continente.",subObje);

        assertEquals("Conquistar Un Continente.", objetivoParticular.mostrarObjetivo());

    }

    @Test
    public void test02SiNoHayObjetivosNoEstaCumplido(){
        ObjetivoParticular objetivoParticular = new ObjetivoParticular("Conquistar Un Continente.",subObje);

        assertFalse(objetivoParticular.objetivoCumplido(ejercito));

    }

    @Test
    public void test03BajoCondicionCumplidaElObjetivoEstaCumplido(){
        pais.asignarEjercito(ejercito);
        Subobjetivo subobjetivo1 = new Subobjetivo(continente1, 0);
        subObje.add(subobjetivo1);
        continente1.agregarPais(pais);

        ObjetivoParticular objetivoParticular = new ObjetivoParticular("Conquistar Un Continente.",subObje);

        assertTrue(objetivoParticular.objetivoCumplido(ejercito));

    }
    @Test
    public void test04BajoUnaCondicionNOCumplidaElObjetivoNOEstaCumplido(){
        Ejercito ejercito2 = new Ejercito("Az");

        pais.asignarEjercito(ejercito);
        Subobjetivo subobjetivo1 = new Subobjetivo(continente1, 0);
        subObje.add(subobjetivo1);
        continente1.agregarPais(pais);

        ObjetivoParticular objetivoParticular = new ObjetivoParticular("Conquistar Un Continente.",subObje);

        assertFalse(objetivoParticular.objetivoCumplido(ejercito2));

    }

}