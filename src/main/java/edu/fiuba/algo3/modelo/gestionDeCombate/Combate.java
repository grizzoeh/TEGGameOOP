package edu.fiuba.algo3.modelo.gestionDeCombate;

import edu.fiuba.algo3.modelo.distribuciondepaises.Pais;

import java.util.ArrayList;

public class Combate {
    private Pais paisAtacante;
    private Pais paisDefensor;
    private int cantAtacante;
    private Dados dados;
    private int perdidosAtacante = 0;
    private int perdidosDefensor = 0;

    public Combate(Pais paisAtacanteIngresado, Pais paisDefensorIngresado, int cantAtacanteIngresada) {
        this.paisAtacante = paisAtacanteIngresado;
        this.paisDefensor = paisDefensorIngresado;
        this.cantAtacante = cantAtacanteIngresada;
        this.dados = new Dados();

    }

    public ArrayList<String> generarCombate() {

        ArrayList<Integer> dadosAtacante = dados.tirarDados(this.cantAtacante);

        int cantidadEjercitosDefensor = paisDefensor.obtenerCantidadEjercitos() <= 3 ? paisDefensor.obtenerCantidadEjercitos() : 3;
        ArrayList<Integer> dadosDefensor = dados.tirarDados(cantidadEjercitosDefensor);



        for (int i = 0; i < Math.min(cantidadEjercitosDefensor, this.cantAtacante); i++) {
            if (dadosAtacante.get(i) <= dadosDefensor.get(i)) perdidosAtacante++;
            else perdidosDefensor++;
        }

        return informarResultados();
    }

    public ArrayList<String> informarResultados() {
        this.paisAtacante.eliminarEjercitos(perdidosAtacante);
        this.paisDefensor.eliminarEjercitos(perdidosDefensor);

        if (!this.paisDefensor.estaOcupado()){
            this.paisAtacante.invadir(this.paisDefensor);
        }
        return obtenerResultados();
    }

    public ArrayList<String> obtenerResultados(){
        ArrayList<String> resultados = new ArrayList<>();

        if(perdidosAtacante <= perdidosDefensor){
            if(!paisDefensor.tienenEjercitosDiferentes(paisAtacante)){
                resultados.add("País Invadido");
            }
            else{
                resultados.add("Atacante Victorioso");
            }
        }
        else{
            resultados.add("Defensor Victorioso");
        }

        resultados.add("Fichas perdidas Atacante: " + String.valueOf(perdidosAtacante));
        resultados.add("Fichas perdidas Defensor: " + String.valueOf(perdidosDefensor));

        return resultados;
    }
}
