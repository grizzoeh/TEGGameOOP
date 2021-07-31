package edu.fiuba.algo3.modelo.gestiondeturnos;

public interface TurnoJugable extends Turno {
	Turno avanzarEtapa();

	void atacar(String paisAtaque, String paisDefensa, int cantEjercitos);

	void asignarEjercito(String pais, int cantidad);

	void moverEjercito(String paisDesde, String paisHasta, int cantidad);

	void canjeoDeTresTarjetas();

	void canjeoUnicoTarjeta(String pais);

	boolean todasLasFichasColocadas();

	int obtenerCantidadDeFichas();
}