package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private Ejercito ejercito;

    public Jugador(String nombre, Ejercito ejercitoRecibido) {
        this.nombre = nombre;
        this.ejercito = ejercitoRecibido;
    }

    public Ejercito getEjercito(){
        return ejercito;
    }

    public String getNombre(){
        return this.nombre;
    }
}