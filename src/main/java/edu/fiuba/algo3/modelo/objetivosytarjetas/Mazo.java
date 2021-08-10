package edu.fiuba.algo3.modelo.objetivosytarjetas;

import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.excepciones.NoExisteTarjetaParaElPaisException;

import java.util.ArrayList;


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
    public boolean quedanTarjetas(){
        return !(tarjetas.size() <= 0);
    }
    public Tarjeta repartirTarjeta(){
        int numeroTarjeta = (int)(Math.random()*tarjetas.size());
        Tarjeta tarjetaaux = tarjetas.get(numeroTarjeta);
        tarjetas.remove(numeroTarjeta);
        tarjetasRepartidas.add(tarjetaaux);

        return tarjetaaux;
    }



    public Tarjeta obtenerTarjetaEspecifica(Pais pais) {
        if (tarjetas.size() <= 0) return null;
        Tarjeta tarjeta = tarjetas.stream()
                .filter(t -> t.perteneceAEstePais(pais))
                .findFirst() //findFirst devuelve Optional<Tipo>, es decir o el tipo del elememento o null
                .orElseThrow(()-> new NoExisteTarjetaParaElPaisException());
        tarjetas.remove(tarjeta);
        tarjetasRepartidas.add(tarjeta);

        return tarjeta;
    }
}

