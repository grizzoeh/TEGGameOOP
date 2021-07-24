package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaParaElPaisException;

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

    public void agregarTarjeta(Tarjeta tarjetaRecibida){ tarjetasPais.add(tarjetaRecibida); }

    public int cantidadDeTarjetas(){ return tarjetasPais.size(); }

    public int cuantosCanjesRealizados(){
        return cantidadDeCanjes;
    }

    public void agregarCanje(){
        cantidadDeCanjes++;
    }

    /*
    NO SE USA ACTUALMENTE

    public  ArrayList<Tarjeta> mostrarTarjetas(){
        ArrayList<Tarjeta> tarjetasPropias = (ArrayList<Tarjeta>) this.tarjetasPais.clone();
        return tarjetasPropias;
    }
    */

    public Tarjeta usarTarjeta(Pais unPais) throws NoExisteTarjetaParaElPaisException {
        Tarjeta tarjeta = tarjetasPais.stream()
                .filter(t -> t.perteneceAEstePais(unPais))
                .findFirst() //findFirst devuelve Optional<Tipo>, es decir o el tipo del elememento o null
                .orElseThrow(()-> new NoExisteTarjetaParaElPaisException());
        tarjetasPais.remove(tarjeta);
        return tarjeta;
    }
}
