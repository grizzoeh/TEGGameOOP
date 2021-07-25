package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ListaObjetivos{
    private ArrayList<Objetivo> objetivos;
    private Mapa mapa;
    private ObjetivoComun objetivoComun;

    public ListaObjetivos(Mapa mapaRecibido){
        this.mapa = mapaRecibido;
        this.objetivos = new ArrayList<Objetivo>();
        this.objetivoComun = new ObjetivoComun(mapa);
        crearObjetivos();
    }

    private void crearObjetivos(){
        Objetivo objetivoAux;
        Subobjetivo subobjetivoAux;
        ArrayList<Subobjetivo> listaSubobjetivosAux = new ArrayList<Subobjetivo>();

        subobjetivoAux = new Subobjetivo(mapa.getContinente("África"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Norte"), 5);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar África, 5 países de América del Norte y 4 países de Europa.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Sur"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Oceanía"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 7);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar América del Sur, 7 países de Europa y 2 países de Oceanía.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Sur"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar Asia y 2 países de América del Sur.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Sur"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar Europa, 4 países de Asia y 2 países de América de Sur.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Norte"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Oceanía"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar América del Norte, 2 países de Oceanía y 4 de Asia.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Oceanía"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("África"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Sur"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 3);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Norte"), 4);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Asia"), 3);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar 2 países de Oceanía, 2 países de África, 2 países de América del Sur, 3 países de Europa, 4 de América del Norte y 3 de Asia.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Oceanía"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Norte"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("Europa"), 2);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar Oceanía, América del Norte y 2 países de Europa.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);

        listaSubobjetivosAux = new ArrayList<Subobjetivo>();
        subobjetivoAux = new Subobjetivo(mapa.getContinente("África"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Sur"), 0);
        listaSubobjetivosAux.add(subobjetivoAux);
        subobjetivoAux = new Subobjetivo(mapa.getContinente("América del Norte"), 5);
        listaSubobjetivosAux.add(subobjetivoAux);
        objetivoAux = new ObjetivoParticular("Ocupar América del Sur, África y 5 países de América del Norte.", listaSubobjetivosAux);
        objetivos.add(objetivoAux);


    }






}
