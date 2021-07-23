package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;

import java.util.ArrayList;

public class Teg {
    private int cantidadJugadores;
    private Mapa mapa;
    private ArrayList<Jugador> jugadores;
    private Turno turnoActual;
    private int numeroJugadorActual;

    public Teg(ArrayList<String> nombresJugadores) {
        this.cantidadJugadores = nombresJugadores.size();
        this.mapa = new Mapa();
        this.jugadores = new ArrayList<Jugador>();
        this.numeroJugadorActual = 0;

        String[] colores = {"rojo", "azul", "verde", "amarillo", "rosa", "negro"};

        for (int i = 0; i < this.cantidadJugadores; i++) {
            this.jugadores.add(new Jugador(nombresJugadores.get(i), new Ejercito(colores[i])));
        }

        mapa.repartirPaises(jugadores);

        turnoActual = new TurnoAtaque(jugadores.get(numeroJugadorActual),mapa);
    }

    public boolean todosLosPaisesOcupados(){
        return this.mapa.todosLosPaisesOcupados();
    }

    public void atacar(String paisAtaque, String paisDefensa, int cantEjercitos) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        turnoActual.atacar(paisAtaque,paisDefensa,cantEjercitos);
    }

    public void moverEjercito(String paisDesde, String paisHasta,int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        turnoActual.moverEjercito(paisDesde,paisHasta,cantidad);
    }

    public void asignarEjercito(String pais,int cantidad) throws EtapaEquivocadaException, PaisNoLePerteneceException {
        turnoActual.asignarEjercito(pais,cantidad);
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