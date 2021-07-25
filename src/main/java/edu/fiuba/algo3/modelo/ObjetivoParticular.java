package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ObjetivoParticular implements Objetivo {
    private String objetivo;
    private ArrayList<Subobjetivo> subobjetivos;

    public ObjetivoParticular(String objetivoACumplir, ArrayList<Subobjetivo> subojetivosRecibidos){
        this.objetivo = objetivoACumplir;
        this.subobjetivos = subojetivosRecibidos;
    }

    @Override
    public boolean objetivoCumplido() {
        return false;
    }
}
