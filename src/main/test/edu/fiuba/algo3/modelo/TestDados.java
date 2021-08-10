package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.gestionDeCombate.Dados;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDados {
    @Test
    public void test01TirarDadosRandomDevuelveLaCantidadPedida() {
        Dados dado = new Dados();
        ArrayList<Integer> dados = dado.tirarDados(3);
        assertEquals(dados.size(), 3);
    }
    @Test
    public void test02TirarDadosRandomDevuelveNumerosEnterosEntre0Y6() {
        Dados dado = new Dados();
        ArrayList<Integer> dados = dado.tirarDados(100);
        boolean estado = true;
        boolean estadoSuperior = true;

        estado = dados.stream().allMatch(u -> u > 0);
        estadoSuperior = dados.stream().allMatch(u -> u < 7);

        assertTrue(estado && estadoSuperior);
    }
    @Test
    public void test03TirarDadosRandomDevuelveNumerosOrdenadosDeMayorAMenor() {
        Dados dado = new Dados();
        ArrayList<Integer> dados = dado.tirarDados(100);
        boolean estado = true;
        for (int i = 1; i < 100; i++) {
            estado = (dados.get(i) <= dados.get(i - 1));
        }
        assertTrue(estado);
    }

}
