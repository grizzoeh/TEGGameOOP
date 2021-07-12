package edu.fiuba.algo3.modelo;

public class Pais {
    private String nombre;
    private Pais[] frontera;
    private Ejercito ejercito;
    private int cantidadEjercitos = 0;

    public Pais(String nombreRecibido) {
        this.nombre = nombreRecibido;
    }

    public void agregarFrontera(Pais[] fronteraRecibida){
        this.frontera = fronteraRecibida;
    }

    public void asignarEjercito(Ejercito ejercitoAsignado){
        this.ejercito = ejercitoAsignado;
    }

    public void agregarEjercito(){
        cantidadEjercitos++;
    }

    public String obtenerNombre(){
        return this.nombre;
    }

    public Ejercito getEjercito(){
        return this.ejercito;
    }

    public boolean estaOcupado(){
        return(this.cantidadEjercitos > 0);
    }

    public void eliminarEjercitos(int cantidad) { this.cantidadEjercitos -= cantidad; }

    public int obtenerCantidadEjercitos() { return this.cantidadEjercitos; }

    public void invadir(Pais paisAInvadir) {
        this.cantidadEjercitos--;
        paisAInvadir.asignarEjercito(this.ejercito);
        paisAInvadir.agregarEjercito();
    }
}