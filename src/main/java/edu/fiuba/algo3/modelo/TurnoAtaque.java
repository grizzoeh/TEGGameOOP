package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

public class TurnoAtaque implements Turno {
	private Mapa mapa;
	private Jugador jugador;

	public TurnoAtaque(Jugador jugadorIngresado, Mapa mapaIngresado) {
		this.jugador = jugadorIngresado;
		this.mapa = mapaIngresado;
	}

	public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		if(!mapa.paisLePertenece(paisAtaque, jugador)) {
			throw new PaisNoLePerteneceException();
		}
		try {
			mapa.atacar(paisAtaque, paisDefensa, cantEjercitos);
		} catch (PaisesNoContinuosException | PaisesConMismoDuenoException | PaisSinEjercitosSuficientesException e) {
			e.printStackTrace();
		}
	}

	public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public void moverEjercito(String paisDesde, String paisHasta, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public TurnoReagrupar avanzarEtapa() {
		return new TurnoReagrupar(jugador, mapa);
	}

	public String enQueFaseDelTurnoEsta(){
		return "Ataque Entre Jugadores";
	}

	public void canjeoDeTresTarjetas() throws EtapaEquivocadaException{
		throw new EtapaEquivocadaException();
	}

	public void canjeoUnicoTarjeta(String pais) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}


}