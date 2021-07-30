package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonObjetivoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ContenedorSuperiorDerecho {
    public static VBox crearContenedor(){
        Label nombre = new Label("Nombre: NombreJug");
        Label color = new Label("Color: ColorJug");

        Button objetivoButton = new Button();
        objetivoButton.setText("Ver Objetivo");
        objetivoButton.setFont(new Font(12));
        objetivoButton.setOnAction(new BotonObjetivoEventHandler());

        VBox contenedor = new VBox(nombre, color, objetivoButton);
        return contenedor;
    }
}
