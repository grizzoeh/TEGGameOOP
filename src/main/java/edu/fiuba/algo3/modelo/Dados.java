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

        //Tirar dados
        int valor_dado;

        for (int i = 0; i < cantDados; i++) {
            valor_dado = (int)(Math.random()*6+1);
            resultado.add(valor_dado);

        }
        //Ordenar Dados
        Collections.sort(resultado);
        Collections.reverse(resultado);
        return resultado;
    }

    public ArrayList<Integer> tirarDadosPonderados(int cantDados, int valorDado) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();

        for (int i = 0; i < cantDados; i++) {
            resultado.add(valorDado);
        }
        return resultado;
    }
}
