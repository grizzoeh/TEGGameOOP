public class TurnoReagrupar implements Turno {
	private Mapa mapa;
	private Jugador jugador;

	public TurnoReagrupar(Jugador jugadorIngresado, Mapa mapaIngresado) {
		this.jugador = jugadorIngresado;
		this.mapa = mapaIngresado;
	}

	public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public void moverEjercito(String paisOrigen, String paisDestino, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		if(!mapa.paisLePertenece(paisOrigen, jugador)) {
			throw new PaisNoLePerteneceException();
		}
		
		mapa.moverEjercitos(paisOrigen, paisDestino, cantidad);

	}

	public Turno avanzarEtapa() {
		return new TurnoAsignarFicha();
	}
}