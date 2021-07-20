package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;

public class TurnoAsignarFicha implements Turno {
	private Mapa mapa;
	private Jugador jugador;
	private int cantidadFichas;

	public TurnoAsignarFicha(Jugador jugadorIngresado, Mapa mapaIngresado) {
		this.jugador = jugadorIngresado;
		this.mapa = mapaIngresado;
		this.cantidadFichas = (mapa.paisesConEjercito(jugador.getEjercito())/2  >= 3 ? mapa.paisesConEjercito(jugador.getEjercito())/2 : 3)
				+ mapa.fichasPorContinentesControlados(jugador.getEjercito());
	}

	public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		if(!mapa.paisLePertenece(pais, jugador)) {
			throw new PaisNoLePerteneceException();
		}

		cantidad = cantidad >= cantidadFichas ? cantidadFichas : cantidad;
		mapa.agregarEjercitos(pais, cantidad);
		cantidadFichas -= cantidad;
	}

	public void moverEjercito(String paisOrigen, String paisDestino, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public Turno avanzarEtapa() {
		return null;
	}


	public void canjeoDeTarjeta(String nombrePais) throws PaisNoLePerteneceException{
		if(!mapa.paisLePertenece(nombrePais, jugador)) {
			throw new PaisNoLePerteneceException();
		}
		
		Integer cantidadASumar;
		Integer cantidadDeCanjes = jugador.cuantosCanjesRealizados() + 1;

		switch (cantidadDeCanjes)
		{
			case 1 : cantidadASumar = 4 ;
				break;
			case 2 : cantidadASumar = 7;
				break;
			case 3 : cantidadASumar = 10;
				break;
			case 4 : cantidadASumar = 15;
				break;
			default : cantidadASumar = (cantidadDeCanjes - 1) * 5;
				break;
		}

		mapa.agregarEjercitos(nombrePais,cantidadASumar);
		jugador.agregarCanje();
	}
	public String enQueFaseDelTurnoEsta(){
		return "Asignación De Fichas";
	}
}