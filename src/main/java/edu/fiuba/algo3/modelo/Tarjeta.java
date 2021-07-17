package edu.fiuba.algo3.modelo;

public class Tarjeta {
    Pais paisPerteciente;
    String simbolo;

    public Tarjeta(Pais pais, String simbolo){
        this.paisPerteciente = pais;
        this.simbolo = simbolo;
    }

    public String obtenerSimbolo(){
        return simbolo;
    }

    public Pais obtenerPais(){
            return paisPerteciente;
    }

    public Boolean perteneceAEstePais(Pais pais){
        return (pais == paisPerteciente);
    }
}