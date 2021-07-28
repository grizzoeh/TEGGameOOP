package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.distribuciondepaises.Mapa;
import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;
import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.gestiondeturnos.Turno;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoAtaque;
import edu.fiuba.algo3.modelo.gestiondeturnos.TurnoEtapaInicial;

import java.util.ArrayList;

public class Teg {
    private int cantidadJugadores;
    private Mapa mapa;
    private ArrayList<Jugador> jugadores;
    private Turno turnoActual;
    private int numeroJugadorActual;

    public Teg(ArrayList<String> nombresJugadores, String rutaArchivo) {
        this.cantidadJugadores = nombresJugadores.size();
        this.mapa = new Mapa(rutaArchivo);
        this.jugadores = new ArrayList<Jugador>();
        this.numeroJugadorActual = 0;

        String[] colores = {"rojo", "azul", "verde", "amarillo", "rosa", "negro"};

        for (int i = 0; i < this.cantidadJugadores; i++) {
            this.jugadores.add(new Jugador(nombresJugadores.get(i), new Ejercito(colores[i])));
        }

        mapa.repartirPaises(jugadores);

        turnoActual = new TurnoEtapaInicial(jugadores.get(numeroJugadorActual),mapa, 5);
    }

    public boolean todosLosPaisesOcupados(){
        return this.mapa.todosLosPaisesOcupados();
    }

    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        turnoActual.atacar(paisAtaque,paisDefensa,cantEjercitos);
    }

    public void moverEjercito(String paisDesde, String paisHasta,int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException, PaisesNoSonDelMismoDuenoException, PaisSinEjercitosSuficientesException, PaisesNoContinuosException {
        turnoActual.moverEjercito(paisDesde,paisHasta,cantidad);
    }

    public void asignarEjercito(String pais,int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        turnoActual.asignarEjercito(pais,cantidad);
    }

    public void avanzarPrimeraEtapaColocacion() throws ColocacionFinalizadaException {
        if (numeroJugadorActual > jugadores.size()) throw new ColocacionFinalizadaException();

        if (numeroJugadorActual == jugadores.size()){
            numeroJugadorActual = 0;
            turnoActual = new TurnoEtapaInicial(jugadores.get(0),mapa, 3);
            return;
        }
        numeroJugadorActual++;
        Integer jugActual = numeroJugadorActual % jugadores.size();
        turnoActual = new TurnoEtapaInicial(jugadores.get(jugActual),mapa, 5);
    }
    public void avanzarSegundaEtapaColocacion() throws ColocacionFinalizadaException {
        if (numeroJugadorActual > jugadores.size()) throw new ColocacionFinalizadaException();
        if (numeroJugadorActual == jugadores.size()){
            numeroJugadorActual = 0;
            turnoActual = new TurnoAtaque(jugadores.get(0),mapa);
            return;
        }
        numeroJugadorActual++;
        Integer jugActual = numeroJugadorActual % jugadores.size();
        turnoActual = new TurnoEtapaInicial(jugadores.get(jugActual),mapa, 3);
    }


    public void saltearColocacionInicial(){
        numeroJugadorActual = 0;
        turnoActual = new TurnoAtaque(jugadores.get(numeroJugadorActual), mapa);
    }
    public ArrayList<Pais> paisesDeJugador(Jugador jugador){
        ArrayList<Pais> lista = mapa.listaPaisesConEjercito(jugador.getEjercito());
        return lista;

    }
    public void avanzarEtapa(){
        turnoActual = turnoActual.avanzarEtapa();

        if(turnoActual.estaFinalizado()){
            numeroJugadorActual++;
            numeroJugadorActual %= jugadores.size();
            turnoActual = new TurnoAtaque(jugadores.get(numeroJugadorActual),mapa);
        }
    }

    public int cantEjercitosEn(String nombrePais){
        return mapa.numeroEjercitosEn(nombrePais);

    }
    public int cantidadJugadores(){
        return cantidadJugadores;
    }
    public String enQueFaseEstaElJuego(){
        return turnoActual.enQueFaseDelTurnoEsta();
    }
    public String aQueJugadorLeToca(){
        return jugadores.get(numeroJugadorActual).getNombre();
    }
}