package edu.fiuba.algo3.modelo.objetivosytarjetas;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ObjetivoParticular implements Objetivo {
    private String objetivo;
    private ArrayList<Subobjetivo> subobjetivos;

    public ObjetivoParticular(String objetivoACumplir, ArrayList<Subobjetivo> subojetivosRecibidos){
        this.objetivo = objetivoACumplir;
        this.subobjetivos = subojetivosRecibidos;
    }

    @Override
    public boolean objetivoCumplido(Ejercito ejercito) {
        if (subobjetivos.size() == 0) return false;
        AtomicBoolean ocupado = new AtomicBoolean(true);

        subobjetivos.forEach((subobjetivo) -> {
            ocupado.set(ocupado.get() && (subobjetivo.cumplido(ejercito)));
        });

       return ocupado.get();
    }
    @Override
    public String mostrarObjetivo(){
        return objetivo;
    }
}
