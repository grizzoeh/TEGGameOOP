package edu.fiuba.algo3.modelo;

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
