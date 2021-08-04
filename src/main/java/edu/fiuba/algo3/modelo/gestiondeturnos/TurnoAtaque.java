package edu.fiuba.algo3.modelo.gestiondeturnos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.aexcepciones.*;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Mazo;

import java.util.ArrayList;

public class TurnoAtaque implements TurnoJugable, TurnoBasico {
	private Mapa mapa;
	private Jugador jugador;
	private boolean gano;
	private Mazo mazo;

	public TurnoAtaque(Jugador jugadorIngresado, Mapa mapaIngresado, Mazo mazo) {
		this.jugador = jugadorIngresado;
		this.mapa = mapaIngresado;
		this.mazo = mazo;
		gano = false;
	}

	public ArrayList<String> atacar(String paisAtaque, String paisDefensa, int cantEjercitos) {
		ArrayList<String> resultado = null;

		if(!mapa.paisLePertenece(paisAtaque, jugador)) {
			throw new PaisNoLePerteneceException();
		}
		try {
			resultado = mapa.atacar(paisAtaque, paisDefensa, cantEjercitos);
			if(resultado.get(0) == "País Invadido"){
				gano = true;
			};
		} catch (PaisesNoContinuosException | PaisesConMismoDuenoException | PaisSinEjercitosSuficientesException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public void asignarEjercito(String pais, int cantidad) {
		throw new EtapaEquivocadaException();
	}

	public void moverEjercito(String paisDesde, String paisHasta, int cantidad) {
		throw new EtapaEquivocadaException();
	}

	public Turno avanzarEtapa() {
		if (gano && mazo.quedanTarjetas()) jugador.agregarTarjeta(mazo.repartirTarjeta());
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