package edu.fiuba.algo3.modelo.distribuciondepaises;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Pais {
    private final String nombre;
    private Collection<Pais> frontera;
    private Ejercito ejercito;
    private int cantidadEjercitos = 0;

    public Pais(String nombreRecibido) {
        this.nombre = nombreRecibido;
    }

    public void agregarFrontera(ArrayList<Pais> fronteraRecibida){
        this.frontera = fronteraRecibida;
    }

    public boolean esAptoParaAtacar(){
        return cantidadEjercitos >= 2;
    }

    public boolean tienenEjercitosDiferentes(Pais paisAAtacar){
        return (!(paisAAtacar.getEjercito().getColor().equals(this.ejercito.getColor())));
    }
    public boolean estaEnFrontera(Pais pais){return frontera.contains(pais);}

    public void asignarEjercito(Ejercito ejercitoAsignado){
        this.ejercito = ejercitoAsignado;
    }

    public void agregarEjercito(Integer cantidad){
        this.cantidadEjercitos += cantidad;
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
        paisAInvadir.agregarEjercito(1);
    }
    public boolean sePuedeMoverEstaCantidadDeEjercitos(Integer cantidad){
        return (cantidadEjercitos >= cantidad + 1);
    }

    public boolean tienePaisesEnemigosEnFrontera(){
        ArrayList<String> paises = this.paisesEnemigosEnFrontera();
        return paises.size() >= 1;
    }
    public ArrayList<String> paisesEnemigosEnFrontera(){
        ArrayList<String> paises = new ArrayList<>();
        frontera.forEach(pais -> {if((pais.getEjercito()) != this.ejercito) paises.add(pais.obtenerNombre());} );
        Collections.sort(paises);
        return paises;
    }


    public boolean tienePaisesAliadosEnFrontera(){
        ArrayList<String> tiene = this.paisesAliadosEnFrontera();
        return tiene.size() >= 1;

    }
    public ArrayList<String> paisesAliadosEnFrontera(){
        ArrayList<String> paises = new ArrayList<>();
            frontera.forEach(pais -> {if((pais.getEjercito()) == this.ejercito) paises.add(pais.obtenerNombre());} );
            Collections.sort(paises);

        return paises;
    }
    public int tropasDisponiblesParaAtacar() {
        return cantidadEjercitos - 1;
    }
}