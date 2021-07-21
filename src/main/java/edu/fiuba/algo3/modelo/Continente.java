package edu.fiuba.algo3.modelo;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public int getBonusConquista(){
        return bonusConquista;
    }
}