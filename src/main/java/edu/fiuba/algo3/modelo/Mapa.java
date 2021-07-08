package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Hashtable;

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


}


/*'Africa': ['Egipto', 'Etiopia', 'Madagascar', 'Sahara', 'Sudafrica', 'Zaire'],
        'America del Sur': ['Argentina', 'Brasil', 'Chile', 'Colombia', 'Peru', 'Uruguay'],
        'America del Norte': ['Alaska', 'California', 'Canada', 'Groenlandia', 'Labrador', 'Nueva York', 'Mexico', 'Oregon', 'Terranova', 'Yukon'],
        'Asia': ['Arabia', 'Aral', 'China', 'Gobi', 'India', 'Iran', 'Israel', 'Japon', 'Kamchatka', 'Malasia', 'Mongolia', 'Siberia', 'Taimir', 'Tartaria', 'Turquia'],
        'Europa': ['Alemania', 'Espana', 'Francia', 'Gran Bretana', 'Islandia', 'Italia', 'Polonia', 'Rusia', 'Suecia'],
        'Oceania': ['Australia', 'Borneo', 'Java', 'Sumatra'],*/