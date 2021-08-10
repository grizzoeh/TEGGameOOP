package edu.fiuba.algo3.modelo.objetivosytarjetas;

import edu.fiuba.algo3.modelo.distribuciondepaises.Continente;
import edu.fiuba.algo3.modelo.componentesJugador.Ejercito;

public class Subobjetivo {
    private Continente continenteAOcupar;
    private Integer cantidadPaises;

    public Subobjetivo(Continente continenteRecibido, Integer cantidadRecibida){
        this.continenteAOcupar = continenteRecibido;
        this.cantidadPaises = cantidadRecibida;
    }

    public boolean cumplido(Ejercito ejercito){

        if(cantidadPaises == 0)

            return continenteAOcupar.jugadorControlaContinente(ejercito);

        return (cantidadPaises == continenteAOcupar.cuantosPaisesDelContinenteDomina(ejercito));
    }



}
