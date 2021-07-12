package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class CombateMock {
    private Pais paisAtacante;
    private Pais paisDefensor;
    private int cantAtacante;


    public CombateMock(Pais paisAtacanteIngresado, Pais paisDefensorIngresado, int cantAtacanteIngresada) {
        this.paisAtacante = paisAtacanteIngresado;
        this.paisDefensor = paisDefensorIngresado;
        this.cantAtacante = cantAtacanteIngresada;
    }

    public void generarCombateAtacanteGanador() {
        int perdidosAtacante = 0;
        int perdidosDefensor = 1;

        informarResultados(perdidosAtacante, perdidosDefensor);
    }

    public void generarCombateDefensorGanador() {
        int perdidosAtacante = 1;
        int perdidosDefensor = 0;

        informarResultados(perdidosAtacante, perdidosDefensor);
    }

    public void informarResultados(int perdidosAtacante, int perdidosDefensor) {
        this.paisAtacante.eliminarEjercitos(perdidosAtacante);
        this.paisDefensor.eliminarEjercitos(perdidosDefensor);

        if (!this.paisDefensor.estaOcupado()) this.paisAtacante.invadir(this.paisDefensor);
    }
}
