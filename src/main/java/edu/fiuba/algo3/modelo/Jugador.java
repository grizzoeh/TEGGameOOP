package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Ejercito ejercito;
    private ArrayList<Tarjeta> tarjetasPais;
    private int cantidadDeCanjes = 0;


    public Jugador(String nombre, Ejercito ejercitoRecibido) {
        this.nombre = nombre;
        this.ejercito = ejercitoRecibido;
        tarjetasPais = new ArrayList<>();
    }


    public Ejercito getEjercito(){
        return ejercito;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void agregarTarjeta(Tarjeta tarjetaRecibida){
        if (tarjetaRecibida != null ) tarjetasPais.add(tarjetaRecibida);
    }

    public  int cantidadDeTarjetas(){
        return tarjetasPais.size();
    }
    public int cuantosCanjesRealizados(){
        return cantidadDeCanjes;
    }

    public void agregarCanje(){
        cantidadDeCanjes++;
    }

    public  ArrayList<Tarjeta> mostrarTarjetas(){
        ArrayList<Tarjeta> tarjetasPropias = (ArrayList<Tarjeta>) this.tarjetasPais.clone();
        return tarjetasPropias;
    }
    public Tarjeta usarTarjeta(Pais pais){
        int i = 0;
        boolean encontrado = false;
        Tarjeta tarjetaux = null;
        while (!encontrado && i < tarjetasPais.size()){
            tarjetaux = tarjetasPais.get(i);
            if (tarjetaux.obtenerPais().equals(pais)) encontrado = true;
            i++;
        }
        tarjetasPais.remove(tarjetaux);
        return  tarjetaux;
    }
}