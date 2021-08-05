package edu.fiuba.algo3.modelo.objetivosytarjetas;

import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.NoHayMasObjetivosException;

import java.util.ArrayList;

public class ListaObjetivos{
    private ArrayList<ObjetivoParticular> objetivos;
    private Mapa mapa;
    private ObjetivoComun objetivoComun;

    public ListaObjetivos(Mapa mapaRecibido, boolean testMode){
        this.mapa = mapaRecibido;
        this.objetivos = new ArrayList<ObjetivoParticular>();
        this.objetivoComun = new ObjetivoComun(mapa);
        if(!testMode){
            crearObjetivos();
        }
        else {
            crearObjetivosDePrueba();
        }
    }

    private void crearObjetivos(){
        ObjetivoParticular objetivoAux;
        Subobjetivo subobjetivoAux;
        ArrayList<Subobjetivo> listaSubobjetivosAux = new ArrayList<Subobjetivo>();

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Norte"), 5);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar Africa, 5 países de America del Norte y 4 países de Europa.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Sur"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Oceania"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 7);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar América del Sur, 7 países de Europa y 2 países de Oceanía.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Sur"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar Asia y 2 países de América del Sur.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Sur"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar Europa, 4 países de Asia y 2 países de América de Sur.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Norte"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Oceania"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar América del Norte, 2 países de Oceanía y 4 de Asia.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Oceania"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Sur"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 3);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Norte"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 3);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar 2 países de Oceanía, 2 países de África, 2 países de América del Sur, 3 países de Europa, 4 de América del Norte y 3 de Asia.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Oceania"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Norte"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar Oceanía, América del Norte y 2 países de Europa.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Sur"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("America del Norte"), 5);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar América del Sur, África y 5 países de América del Norte.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);


    }
    public int cantidadDeObjetivos (){
        return objetivos.size();
    }

    public ObjetivoComun asignarObjetivoComun(){
        return objetivoComun;
    }

    public ObjetivoParticular asignarObjetivoParticular(){
        if (objetivos.size() <= 0) throw new NoHayMasObjetivosException();


        int numeroObjetivo = (int)(Math.random()*objetivos.size());
        ObjetivoParticular objetivoAleatorio = objetivos.get(numeroObjetivo);
        objetivos.remove(numeroObjetivo);
        return objetivoAleatorio;
    }

    //Esta funcion solo tiene usos en funciones de testeo
    public ObjetivoParticular asignarObjetivoParticularEspecifico(Integer numObjetivo){
        if (objetivos.size() <= 0) throw new NoHayMasObjetivosException();
        ObjetivoParticular objetivo = objetivos.get(numObjetivo);
        objetivos.remove(numObjetivo);
        return objetivo;
    }
    public void crearObjetivosDePrueba(){
        ObjetivoParticular objetivoAux;
        Subobjetivo subobjetivoAux;

        ArrayList<Subobjetivo> listaSubobjetivosAux = new ArrayList<Subobjetivo>();

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar África, y 4 países de Asia.", listaSubobjetivosAux);

        objetivos.add(objetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar África, y 4 países de Asia.", listaSubobjetivosAux);

        objetivos.add(objetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar África, y 4 países de Asia.", listaSubobjetivosAux);

        objetivos.add(objetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar África, y 4 países de Asia.", listaSubobjetivosAux);

        objetivos.add(objetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar África, y 4 países de Asia.", listaSubobjetivosAux);

        objetivos.add(objetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar África, y 4 países de Asia.", listaSubobjetivosAux);

        objetivos.add(objetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Africa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);

        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar África, y 4 países de Asia.", listaSubobjetivosAux);

        objetivos.add(objetivoAux);

    }
}
