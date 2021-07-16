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
		mapa.atacar(paisAtaque, paisDefensa, cantEjercitos);
	}

	public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public void moverEjercito(String paisDesde, String paisHasta, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
		throw new EtapaEquivocadaException();
	}

	public Turno avanzarEtapa() {
		return new TurnoReagrupar();
	}
}