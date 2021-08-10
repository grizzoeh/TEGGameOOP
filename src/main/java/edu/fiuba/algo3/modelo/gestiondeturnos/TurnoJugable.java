package edu.fiuba.algo3.modelo.gestiondeturnos;

import edu.fiuba.algo3.modelo.componentesJugador.Jugador;

import java.util.ArrayList;

public interface TurnoJugable extends Turno {

	ArrayList<String> atacar(String paisAtaque, String paisDefensa, int cantEjercitos);

	void asignarEjercito(String pais, int cantidad);

	void moverEjercito(String paisDesde, String paisHasta, int cantidad);

	void canjeoDeTresTarjetas();

	void canjeoUnicoTarjeta(String pais);

	boolean todasLasFichasColocadas();

	int obtenerCantidadDeFichas();

	Jugador obtenerJugadorActual();
}