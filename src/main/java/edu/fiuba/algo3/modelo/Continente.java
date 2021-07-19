package edu.fiuba.algo3.modelo;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

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
        if(paises.isEmpty()){
            return false;
        }
        Set<String> keys = paises.keySet();
        Iterator<String> itr = keys.iterator();

        while(itr.hasNext()){
            String paisNombre = itr.next();
            Pais pais = paises.get(paisNombre);

            if (pais.getEjercito() != ejercito){
                return false;
            }
        }
        return true;
    }

    public int getBonusConquista(){
        return bonusConquista;
    }
}