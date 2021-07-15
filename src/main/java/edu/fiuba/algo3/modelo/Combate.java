package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Combate {
    private Pais paisAtacante;
    private Pais paisDefensor;
    private int cantAtacante;
    private Dados dados;

    public Combate(Pais paisAtacanteIngresado, Pais paisDefensorIngresado, int cantAtacanteIngresada) {
        this.paisAtacante = paisAtacanteIngresado;
        this.paisDefensor = paisDefensorIngresado;
        this.cantAtacante = cantAtacanteIngresada;
        this.dados = new Dados();
    }

    public void generarCombate() {
        if (this.paisAtacante.obtenerCantidadEjercitos() < 2) return;

        ArrayList<Integer> dadosAtacante = dados.tirarDados(this.cantAtacante);
        int cantidadEjercitosDefensor = this.paisDefensor.obtenerCantidadEjercitos() <= 3 ? this.paisDefensor.obtenerCantidadEjercitos() : 3;
        ArrayList<Integer> dadosDefensor = dados.tirarDados(cantidadEjercitosDefensor);

        int perdidosAtacante = 0;
        int perdidosDefensor = 0;

        for (int i = 0; i < Math.min(cantidadEjercitosDefensor, this.cantAtacante); i++) {
            if (dadosAtacante.get(i) <= dadosDefensor.get(i)) perdidosAtacante++;
            else perdidosDefensor++;
        }

        informarResultados(perdidosAtacante, perdidosDefensor);
    }

    public void informarResultados(int perdidosAtacante, int perdidosDefensor) {
        this.paisAtacante.eliminarEjercitos(perdidosAtacante);
        this.paisDefensor.eliminarEjercitos(perdidosDefensor);

        if (!this.paisDefensor.estaOcupado()) this.paisAtacante.invadir(this.paisDefensor);
    }
}
