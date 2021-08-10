package edu.fiuba.algo3.modelo.gestiondeturnos;

public interface TurnoBasico extends Turno {

     Turno avanzarEtapa();

     boolean estaFinalizado();

     String enQueFaseDelTurnoEsta();
}
