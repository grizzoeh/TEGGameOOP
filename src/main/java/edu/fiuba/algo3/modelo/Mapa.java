package edu.fiuba.algo3.modelo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.io.File;
import java.util.Scanner;

public class Mapa {
    private Hashtable<String, Pais> paises;

    public Mapa(){
        this.paises = new Hashtable<String, Pais>();
        this.crearPaises();
    }

    //Transformar este metodo a una lectura de archivos (un archivo de paises y otro de fronteras)
    public void crearPaises() {
        /*
        Path current = Paths.get("../archivosDeTexto/paises.txt");
        String s = current.toAbsolutePath().toString();

        File f = new File(s);
        Scanner fr = new Scanner(f);

        while(fr.hasNextLine()) {
            String linea = fr.nextLine();
            linea = linea.replace("\n", "").replace("\r", "");
            paises.put(linea, new Pais(linea));
        }

        fr.close();

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

        */
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


    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) {

        Pais paisAtacante = paises.get(paisAtaque);
        Pais paisDefensor = paises.get(paisDefensa);
        Combate combate = new Combate(paisAtacante, paisDefensor, cantEjercitos);
        combate.generarCombate();
    }

    public boolean sonContiguos(String pais1, String pais2) {
        Pais paisUno = paises.get(pais1);
        Pais paisDos = paises.get(pais2);

        return paisUno.estaEnFrontera(paisDos);


    }
}
