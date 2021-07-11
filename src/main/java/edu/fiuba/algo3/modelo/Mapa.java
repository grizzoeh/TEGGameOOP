package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

public class Mapa {
    private Hashtable<String, Pais> paises;

    public Mapa(){
        this.paises = new Hashtable<String, Pais>();
        this.crearPaises();
    }

    //Transformar este metodo a una lectura de archivos (un archivo de paises y otro de fronteras)
    private void crearPaises(){
        String[] nombresPaises = {"Egipto", "Etiopia", "Madagascar", "Sahara", "Sudafrica", "Zaire"};
        Pais paisAux;

        for(int i = 0; i < (nombresPaises.length); i++){
            paises.put(nombresPaises[i], new Pais(nombresPaises[i]));
        }

        paisAux = paises.get("Egipto");
        Pais[] fronteraAux = {paises.get("Etiopia"), paises.get("Madagascar"), paises.get("Sahara")};
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Etiopia");
        fronteraAux = new Pais[]{paises.get("Egipto"), paises.get("Sahara"), paises.get("Zaire"), paises.get("Sudafrica")};
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Madagascar");
        fronteraAux = new Pais[]{paises.get("Egipto"), paises.get("Zaire")};
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Sahara");
        fronteraAux = new Pais[]{paises.get("Egipto"), paises.get("Etiopia") ,paises.get("Zaire")};
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Sudafrica");
        fronteraAux = new Pais[]{paises.get("Etiopia") ,paises.get("Zaire")};
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Zaire");
        fronteraAux = new Pais[]{paises.get("Etiopia") ,paises.get("Madagascar"), paises.get("Sahara"), paises.get("Sudafrica")};
        paisAux.agregarFrontera(fronteraAux);


    }

    //Esta funcion no aplica aleatoriedad.
    public void repartirPaises(ArrayList<Jugador> jugadores){
        int cantidadPaises = paises.size();
        int cantidadJugadores = jugadores.size();
        Pais paisAux;
        String[] keys = paises.keySet().toArray(new String[0]);

        int i = 0;
        while(i < cantidadPaises){
            for(int j = 0; j < cantidadJugadores; j++){
                paisAux = paises.get(keys[i]);
                paisAux.asignarEjercito(jugadores.get(j).getEjercito());
                paisAux.agregarEjercito();
                i++;
            }
        }
    }
    public boolean todosLosPaisesOcupados(){
        boolean estanOcupados = true;
        int i = 0;
        String[] keys = paises.keySet().toArray(new String[0]);

        while(estanOcupados && i < paises.size()){
            estanOcupados = estanOcupados && (paises.get(keys[i]).estaOcupado());
            i++;
        }
        return estanOcupados;
    }


}
