package edu.fiuba.algo3.modelo;

public class Combate {
    private Pais paisAtacante;
    private Pais paisDefensor;
    private int cantAtacante;

    public Combate(Pais paisAtacanteIngresado, Pais paisDefensorIngresado, int cantAtacanteIngresada) {
        this.paisAtacante = paisAtacanteIngresado;
        this.paisDefensor = paisDefensor;
        this.cantAtacante = cantAtacanteIngresada;
    }
}
