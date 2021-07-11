package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

public class Dados {

    public Dados() {
    }
    public ArrayList<Integer> tirarDados(int cantDados) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();

        //Tiar dados
        int valor_dado;

        for (int i = 0; i < cantDados - 1; i++) {
            valor_dado = (int)(Math.random()*6+1);
            resultado.add(valor_dado);

        }
        //Ordenar Dados
        Collections.sort(resultado);
        return resultado;
    }
}
