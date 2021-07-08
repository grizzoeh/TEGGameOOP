package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais {
    private String nombre;
    private Pais[] frontera;

    public Pais(String nombreRecibido) {
        this.nombre = nombreRecibido;
    }

    public void agregarFrontera(Pais[] fronteraRecibida){
        this.frontera = fronteraRecibida;
    }
}