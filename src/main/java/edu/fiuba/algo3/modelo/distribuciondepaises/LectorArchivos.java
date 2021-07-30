package edu.fiuba.algo3.modelo.distribuciondepaises;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class LectorArchivos {
    public void leerYParsear(String rutaArchivo, Hashtable<String, Pais> paises, Hashtable<String, Continente> continentes) throws FileNotFoundException {
        FileReader fileReader = new FileReader(rutaArchivo);
        CSVReader csvReader = new CSVReader(fileReader);

        ArrayList<String> listaLector;
        try {
            String[] linea;
            csvReader.readNext();
            while ((linea = csvReader.readNext()) != null) {
                Pais paisAux = new Pais(linea[0]);
                paises.put(linea[0],paisAux);
                continentes.get(linea[1]).agregarPais(paisAux);

            }

            fileReader = new FileReader(rutaArchivo);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();
            while ((linea = csvReader.readNext()) != null) {
                ArrayList<Pais> frontera = new ArrayList<Pais>();
                Pais paisAux = paises.get(linea[0]);
                String[] listaFronteras = linea[2].replaceAll("^\"|\"$", "").split(",");

                for (String pais : listaFronteras){
                    frontera.add(paises.get(pais));
                }


                paisAux.agregarFrontera(frontera);


            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
