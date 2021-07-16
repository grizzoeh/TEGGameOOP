package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.PaisSinEjercitosSuficientesException;
import edu.fiuba.algo3.modelo.excepciones.PaisesConMismoDuenoException;
import edu.fiuba.algo3.modelo.excepciones.PaisesNoContinuosException;

import java.util.*;
import java.util.stream.Stream;

public class Mapa {
    private Hashtable<String, Pais> paises;

    public Mapa(){
        this.paises = new Hashtable<String, Pais>();
        this.crearPaises();
    }

    //Transformar este metodo a una lectura de archivos (un archivo de paises y otro de fronteras)
    public void crearPaises() {

        String[] nombresPaises = {"Egipto", "Etiopia", "Madagascar", "Sahara", "Sudafrica", "Zaire"};
        Pais paisAux;

        for(int i = 0; i < (nombresPaises.length); i++){
            paises.put(nombresPaises[i], new Pais(nombresPaises[i]));

        }

        HashSet<Pais> fronteraAux = new HashSet<>();

        paisAux = paises.get("Egipto");
        Pais[] frontera = {paises.get("Etiopia"), paises.get("Madagascar"), paises.get("Sahara")};
        fronteraAux.addAll(Arrays.asList(frontera));
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Etiopia");
        frontera = new Pais[]{paises.get("Egipto"), paises.get("Sahara"), paises.get("Zaire"), paises.get("Sudafrica")};
        fronteraAux.clear();
        fronteraAux.addAll(Arrays.asList(frontera));
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Madagascar");
        frontera = new Pais[]{paises.get("Egipto"), paises.get("Zaire")};
        fronteraAux.clear();
        fronteraAux.addAll(Arrays.asList(frontera));
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Sahara");
        frontera = new Pais[]{paises.get("Egipto"), paises.get("Etiopia") ,paises.get("Zaire")};
        fronteraAux.clear();
        fronteraAux.addAll(Arrays.asList(frontera));
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Sudafrica");
        frontera = new Pais[]{paises.get("Etiopia") ,paises.get("Zaire")};
        fronteraAux.clear();
        fronteraAux.addAll(Arrays.asList(frontera));
        paisAux.agregarFrontera(fronteraAux);

        paisAux = paises.get("Zaire");
        frontera = new Pais[]{paises.get("Etiopia") ,paises.get("Madagascar"), paises.get("Sahara"), paises.get("Sudafrica")};
        fronteraAux.clear();
        fronteraAux.addAll(Arrays.asList(frontera));
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
                paisAux.agregarEjercito(1);
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
    //Tal vez esta funcion deberia tener una excepcion por si no existe ese país
    public Pais obtenerPais(String paisABuscar) {
        Pais paisEncontrado = paises.get(paisABuscar);
        return paisEncontrado;
    }

    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws PaisesNoContinuosException, PaisesConMismoDuenoException, PaisSinEjercitosSuficientesException {

        Pais paisAtacante = obtenerPais(paisAtaque);
        Pais paisDefensor = obtenerPais(paisDefensa);

        if(!sonContiguos(paisAtacante, paisDefensor))
            throw new PaisesNoContinuosException();
        if(!paisAtacante.tienenEjercitosDiferentes(paisDefensor))
            throw new PaisesConMismoDuenoException();
        if(!paisAtacante.esAptoParaAtacar())
            throw new PaisSinEjercitosSuficientesException();

        //En caso de ningun error, se realiza el ataque
        Combate combate = new Combate(paisAtacante, paisDefensor, cantEjercitos);
        combate.generarCombate();
    }

    public boolean sonContiguos(Pais paisUno, Pais paisDos) {
        return paisUno.estaEnFrontera(paisDos);
    }

    public Ejercito ejercitoEnPais(String nombrePais){
        Pais paisBuscado = paises.get(nombrePais);

        return paisBuscado.getEjercito();
    }

    public Integer paisesConEjercito(String colorEjercito){
        int contadorEjercito = 0;
        Ejercito ejercitoAux;
        int i = 0;
        String[] keys = paises.keySet().toArray(new String[0]);

        while (i < this.paises.size()){
            ejercitoAux = ejercitoEnPais(keys[i]);
            if(ejercitoAux.getColor().equals(colorEjercito)){
                contadorEjercito++;
            }
            i++;
        }

        return contadorEjercito;
    }
    public void moverEjercitos(String paisOrigen, String paisDestino, Integer cantidadAMover){
        Pais origen = obtenerPais(paisOrigen);
        Pais destino = obtenerPais(paisDestino);

        if (!sonContiguos(origen,destino)) return; //LANZAR ERROR PAISES NO SON ADYACENTES
        if (origen.tienenEjercitosDiferentes(destino)) return; //LANZAR ERROR PAISES NO SON DEL MISMO DUEÑO
        if (!origen.sePuedeMoverEstaCantidadDeEjercitos(cantidadAMover)) return; // LANZAR ERROR DE QUE NO ALCANZAN LAS TROPAS

        origen.eliminarEjercitos(cantidadAMover);
        destino.agregarEjercito(cantidadAMover);

    }
    public Collection<Pais> todosLosPaises(){
        return paises.values();
    }

}