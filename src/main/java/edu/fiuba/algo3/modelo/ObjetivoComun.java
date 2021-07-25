package edu.fiuba.algo3.modelo;

public class ObjetivoComun implements Objetivo{
    private String objetivo;
    private Mapa mapa;

    public ObjetivoComun(Mapa mapaRecibido){
        this.objetivo = "Ocupar 30 países.";
        this.mapa = mapaRecibido;
    }

    @Override
    public boolean objetivoCumplido() {
        return false;
    }

}
