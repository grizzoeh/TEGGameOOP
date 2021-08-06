package edu.fiuba.algo3.modelo.distribuciondepaises;

import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Continente {

    private final String nombre;
    private Hashtable<String, Pais> paises;
    private int bonusConquista;


    public Continente(String nombreRecibido, int fichasPorConquista) {
        this.nombre = nombreRecibido;
        this.bonusConquista = fichasPorConquista;
        this.paises = new Hashtable<String, Pais>();
    }



    public void agregarPais(Pais pais) {
        paises.put(pais.obtenerNombre(),pais);
    }

    public boolean jugadorControlaContinente(Ejercito ejercito) {
        if (paises.isEmpty()){
            return false;
        }

        AtomicBoolean estado = new AtomicBoolean(true);

        paises.forEach((key, value) -> {
            Ejercito color = value.getEjercito();
            if (color != ejercito) estado.set(false);
        });
        return estado.get();
    }

    public int cuantosPaisesDelContinenteDomina(Ejercito ejercito){
       AtomicInteger paisesDominados = new AtomicInteger();

        paises.forEach((key, value) -> {
            Ejercito color = value.getEjercito();
            if (color == ejercito) paisesDominados.getAndIncrement();
        });

        return paisesDominados.get();
    }

    public int getBonusConquista(){
        return bonusConquista;
    }
}