package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Mazo {

    ArrayList<Tarjeta> tarjetas;


    public Mazo(Collection<Pais> paises){
        Iterator<Pais> iterador = paises.iterator();
        Pais paisAux;
        String[] simbolos = {"Cañon", "Barco", "Globo"};
        int i = 0;
        while(iterador.hasNext()){
            paisAux = iterador.next();
            tarjetas.add(new Tarjeta(paisAux, simbolos[i % 3]));
            i++;
        }
    }
/*
    public void usarTarjeta(Pais pais){
*/


}
