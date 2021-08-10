package edu.fiuba.algo3.modelo.gestiondeturnos;

import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

public class TurnoReagrupar implements TurnoJugable, TurnoBasico{
	private Mapa mapa;
	private Jugador jugador;

	public TurnoReagrupar(Jugador jugadorIngresado, Mapa mapaIngresado) {
		this.jugador = jugadorIngresado;
		this.mapa = mapaIngresado;
	}

	public ArrayList<String> atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public void moverEjercito(String paisOrigen, String paisDestino, int cantidad)  {
		if(!mapa.paisLePertenece(paisOrigen, jugador)) {
			throw new PaisNoLePerteneceException();
		}
		mapa.moverEjercitos(paisOrigen, paisDestino, cantidad);
	}

	public Turno avanzarEtapa() {
		return new TurnoAsignarFicha(jugador, mapa);
	}

	public String enQueFaseDelTurnoEsta(){
		return "Reagrupación de Tropas";
	}

	public void canjeoDeTresTarjetas() {
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