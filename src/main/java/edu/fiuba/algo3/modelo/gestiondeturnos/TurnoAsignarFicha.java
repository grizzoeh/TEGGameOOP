package edu.fiuba.algo3.modelo.gestiondeturnos;

import edu.fiuba.algo3.modelo.componentesJugador.Jugador;
import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.excepciones.EtapaEquivocadaException;
import edu.fiuba.algo3.modelo.excepciones.PaisNoLePerteneceException;

import java.util.ArrayList;

public class TurnoAsignarFicha implements TurnoJugable, TurnoBasico {
	private Mapa mapa;
	private Jugador jugador;
	private int cantidadFichas;
	private int fichasTrasCanje;


	public TurnoAsignarFicha(Jugador jugadorIngresado, Mapa mapaIngresado) {
		this.jugador = jugadorIngresado;
		this.mapa = mapaIngresado;
		this.cantidadFichas = (mapa.paisesConEjercito(jugador.getEjercito())/2  >= 3 ? mapa.paisesConEjercito(jugador.getEjercito())/2 : 3)
				+ mapa.fichasPorContinentesControlados(jugador.getEjercito());
	}

	public ArrayList<String> atacar(String paisAtaque, String paisDefensa, int cantEjercitos){
		throw new EtapaEquivocadaException();
	}

	public void asignarEjercito(String pais, int cantidad) {
		if(!mapa.paisLePertenece(pais, jugador)) {
			throw new PaisNoLePerteneceException();
		}

		cantidad = cantidad >= cantidadFichas ? cantidadFichas : cantidad;
		mapa.agregarEjercitos(pais, cantidad);
		cantidadFichas -= cantidad;
	}

	public void moverEjercito(String paisOrigen, String paisDestino, int cantidad) {
		throw new EtapaEquivocadaException();
	}

	public Turno avanzarEtapa() {
		return new TurnoFinalizado();
	}


	public void canjeoDeTresTarjetas(){
		
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
		jugador.agregarCanje();
		cantidadFichas += cantidadASumar;
		fichasTrasCanje = cantidadASumar;
	}

	public void canjeoUnicoTarjeta(String pais){
		if(!mapa.paisLePertenece(pais, jugador)) {
			throw new PaisNoLePerteneceException();
		}
		mapa.agregarEjercitos(pais, 2);
		jugador.canjearTarjetaIndividual(pais);
	}

	public String enQueFaseDelTurnoEsta(){
		return "Asignación De Fichas";
	}

	public  int getCantidadFichasTrasCanje(){
		return fichasTrasCanje;
	}

	public boolean todasLasFichasColocadas(){
		return (cantidadFichas == 0);
	}

	public boolean estaFinalizado() {return false;}

	public int obtenerCantidadDeFichas() {
		return cantidadFichas;
	}
	public Jugador obtenerJugadorActual() {
		return jugador;
	}
}