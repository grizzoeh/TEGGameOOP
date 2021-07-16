public interface Turno{
	
	public Turno avanzarEtapa();

	public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException;

	public void asignarEjercito(String pais, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException;

	public void moverEjercito(String paisDesde, String paisHasta, int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException;

}