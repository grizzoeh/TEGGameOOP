package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Mazo {

    ArrayList<Tarjeta> tarjetas;
    ArrayList<Tarjeta> tarjetasRepartidas;


    public Mazo(ArrayList<Pais> paises){
        tarjetas = new ArrayList<>();
        tarjetasRepartidas = new ArrayList<>();
        Pais paisAux;
        String[] simbolos = {"Cañon", "Barco", "Globo"};
        for (int i = 0; i < paises.size(); i++){
            paisAux = paises.get(i);
            tarjetas.add(new Tarjeta(paisAux, simbolos[i % 3]));
        }

    }
    public Integer cantidadDeTarjetasRepartidas(){
        return tarjetasRepartidas.size();
    }

    public Integer cantidadDeTarjetasEnElMazo(){
        return tarjetas.size();
    }

    public boolean sonAptasParaCanje(ArrayList<Tarjeta> tarjetasACanjear){

        boolean mismoSimbolo = false;
        boolean todosDistintos = false;


        Tarjeta tarjetaPrimera = tarjetasACanjear.get(0);
        String simboloPrimera = tarjetaPrimera.obtenerSimbolo();

        mismoSimbolo = tarjetasACanjear.stream().allMatch(tarjeta -> (tarjeta.obtenerSimbolo().equals(simboloPrimera)));

        Tarjeta tarjetaSegunda = tarjetasACanjear.get(1);
        String simboloSegunda = tarjetaSegunda.obtenerSimbolo();
        Tarjeta tarjetaTercera = tarjetasACanjear.get(2);
        String simboloTercera = tarjetaTercera.obtenerSimbolo();

        todosDistintos = ((!simboloPrimera.equals(simboloSegunda) && !simboloPrimera.equals(simboloTercera)) && !simboloTercera.equals(simboloSegunda));

        return (todosDistintos || mismoSimbolo);
    }

    public void devolverTarjetas(ArrayList<Tarjeta> tarjetasADevolver){
        for (int i = 0; i < tarjetasADevolver.size(); i++ ){
            tarjetasRepartidas.remove(tarjetasADevolver.get(i));
        }

        tarjetas.addAll(tarjetasADevolver);
    }

    public Tarjeta repartirTarjeta(){
        if(tarjetas.size() <= 0) return null;

        Tarjeta tarjetaaux = tarjetas.get(0);
        tarjetas.remove(0);
        tarjetasRepartidas.add(tarjetaaux);

        return tarjetaaux;
    }

    //Esta funcion solo tiene utilidad en procesos de Testeo
    public Tarjeta obtenerTarjetaEspecifica(Pais pais){
        if (tarjetas.size() <= 0) return null;
        boolean encontrado = false;
        int i = 0;
        Tarjeta tarjetaAux = null;
        while (!encontrado || i < tarjetas.size()){
            tarjetaAux = tarjetas.get(i);
            if (tarjetaAux.obtenerPais() == pais) encontrado = true;
            i++;
        }
        tarjetas.remove(tarjetaAux);
        tarjetasRepartidas.add(tarjetaAux);

        return tarjetaAux;
    }
}

