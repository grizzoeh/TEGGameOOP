package edu.fiuba.algo3.modelo;

public class ContinenteControladoEnDosPaisesMock extends Continente{
    public ContinenteControladoEnDosPaisesMock(String nombreRecibido, int fichasPorConquista){
        super();


    }
    public int cuantosPaisesDelContinenteDomina(Ejercito ejercito){
        return 2;
    }

    public boolean jugadorControlaContinente(Ejercito ejercito){
        return false;
    }
}
