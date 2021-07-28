package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaParaElPaisException;
import edu.fiuba.algo3.modelo.objetivosytarjetas.ObjetivoComun;
import edu.fiuba.algo3.modelo.objetivosytarjetas.ObjetivoParticular;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Tarjeta;

import java.util.ArrayList;

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

    public void agregarTarjeta(Tarjeta tarjetaRecibida){ tarjetasPais.add(tarjetaRecibida); }

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


    public  ArrayList<Tarjeta> mostrarTarjetas(){
        ArrayList<Tarjeta> tarjetasPropias = (ArrayList<Tarjeta>) this.tarjetasPais.clone();
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
    public boolean objetivoCumplido(){
        return (objetivoComun.objetivoCumplido(ejercito) || objetivoParticular.objetivoCumplido(ejercito));
    }

}
