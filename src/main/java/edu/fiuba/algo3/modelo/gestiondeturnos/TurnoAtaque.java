package edu.fiuba.algo3.modelo.gestiondeturnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.aexcepciones.*;

public class TurnoAtaque implements TurnoJugable, TurnoBasico {
	private Mapa mapa;
	private Jugador jugador;

	public TurnoAtaque(Jugador jugadorIngresado, Mapa mapaIngresado) {
		this.jugador = jugadorIngresado;
		this.mapa = mapaIngresado;
	}

	public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) {
		if(!mapa.paisLePertenece(paisAtaque, jugador)) {
			throw new PaisNoLePerteneceException();
		}
		try {
			mapa.atacar(paisAtaque, paisDefensa, cantEjercitos);
		} catch (PaisesNoContinuosException | PaisesConMismoDuenoException | PaisSinEjercitosSuficientesException e) {
			e.printStackTrace();
		}
	}

	public void asignarEjercito(String pais, int cantidad) {
		throw new EtapaEquivocadaException();
	}

	public void moverEjercito(String paisDesde, String paisHasta, int cantidad) {
		throw new EtapaEquivocadaException();
	}

	public Turno avanzarEtapa() {
		return new TurnoReagrupar(jugador, mapa);
	}

	public String enQueFaseDelTurnoEsta(){
		return "Ataque Entre Jugadores";
	}

	public void canjeoDeTresTarjetas(){
		throw new EtapaEquivocadaException();
	}

	public void canjeoUnicoTarjeta(String pais) {
		throw new EtapaEquivocadaException();
	}
	public boolean todasLasFichasColocadas() {
		throw new EtapaEquivocadaException();
	}

	public boolean estaFinalizado() {return false;}

	public int obtenerCantidadDeFichas() {
		throw new EtapaEquivocadaException();
	}

	public Jugador obtenerJugadorActual() {
		return jugador;
	}
}