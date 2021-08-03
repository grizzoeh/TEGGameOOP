package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.aexcepciones.NoExisteTarjetaParaElPaisException;
import edu.fiuba.algo3.modelo.objetivosytarjetas.ObjetivoComun;
import edu.fiuba.algo3.modelo.objetivosytarjetas.ObjetivoParticular;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Tarjeta;

import java.util.ArrayList;
import java.util.Collections;

public class Jugador {
    private String nombre;
    private Ejercito ejercito;
    private ArrayList<Tarjeta> tarjetasPais;
    private int cantidadDeCanjes = 0;
    ObjetivoComun objetivoComun;
    ObjetivoParticular objetivoParticular;


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

    public String getColor() { return this.ejercito.getColor();}

    public void agregarTarjeta(Tarjeta tarjetaRecibida){
        tarjetasPais.add(tarjetaRecibida);
    }

    public int cantidadDeTarjetas(){ return tarjetasPais.size(); }

    public int cuantosCanjesRealizados(){
        return cantidadDeCanjes;
    }

    public void agregarCanje(){
        cantidadDeCanjes++;
    }

    public void asignarObjetivoParticular(ObjetivoParticular objetivoRecibido){
        this.objetivoParticular = objetivoRecibido;
    }
    public void asignarObjetivoGeneral(ObjetivoComun objetivoRecibido){
        this.objetivoComun = objetivoRecibido;
    }


    public  ArrayList<String> mostrarTarjetas(){
        ArrayList<String> tarjetasPropias = new ArrayList<>();
        tarjetasPais.forEach( tarjeta -> tarjetasPropias.add(tarjeta.obtenerPais().obtenerNombre() + " - " + tarjeta.obtenerSimbolo()));
        return tarjetasPropias;
    }

    public Tarjeta usarTarjeta(Pais unPais) {
        Tarjeta tarjeta = tarjetasPais.stream()
                .filter(t -> t.perteneceAEstePais(unPais))
                .findFirst() //findFirst devuelve Optional<Tipo>, es decir o el tipo del elememento o null
                .orElseThrow(()-> new NoExisteTarjetaParaElPaisException());
        tarjetasPais.remove(tarjeta);
        return tarjeta;
    }
    public void canjearTarjetaIndividual(String unPais) {
        for (Tarjeta tarjeta : tarjetasPais) {
            if (tarjeta.obtenerPais().obtenerNombre().equals(unPais)) {
                tarjetasPais.remove(tarjeta);
                return;
            }
        }
    }
    public boolean objetivoCumplido(){
        return (objetivoComun.objetivoCumplido(ejercito) || objetivoParticular.objetivoCumplido(ejercito));
    }
    public String mostrarObjetivo() {
        return objetivoParticular.mostrarObjetivo();
    }

}
