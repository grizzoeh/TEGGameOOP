package edu.fiuba.algo3.modelo.gestiondeturnos;

public interface Turno{
	
	public Turno avanzarEtapa();

	public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos);

	public void asignarEjercito(String pais, int cantidad);

	public void moverEjercito(String paisDesde, String paisHasta, int cantidad);

	public String enQueFaseDelTurnoEsta();

	 public void canjeoDeTresTarjetas();

	 public  void canjeoUnicoTarjeta(String pais);

	 public boolean estaFinalizado();

	public boolean todasLasFichasColocadas();
}