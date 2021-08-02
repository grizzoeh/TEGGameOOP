package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonAtacarEventHandler;
import edu.fiuba.algo3.controladores.BotonAvanzarAReagrupacionEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.controladores.ElegirPaisParaAtacarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EscenaEtapaAtaque {
    public static Scene crearEscenaEtapaAtaque(Stage stage, ControladorMaestro controladorMaestro){

        ImageView imageView = LectorDeImagenMapa.crearImagenDelMapa();


        Label etapa = new Label("ETAPA DE ATAQUE");
        etapa.setFont(new Font("Serif", 18));

        var paisesLabel = new Label("Desde:");
        ComboBox paisesDesde = new ComboBox();
        paisesDesde.getItems().addAll(controladorMaestro.paisesPuedenAtacar());
        Label atacados = new Label("Hacia:");

        ComboBox paisesHacia = new ComboBox();
        paisesHacia.getItems().addAll(
                "Paises A Ser Atacados"
        );
        Button atacarButton = new Button();
        atacarButton.setText("Lanzar Ataque");
        ComboBox cantidadDeFichas = new ComboBox();
        cantidadDeFichas.getItems().addAll(
                "Cantidad"
        );

        paisesDesde.setOnAction(new ElegirPaisParaAtacarEventHandler(controladorMaestro, paisesDesde,paisesHacia, cantidadDeFichas));

        Label fichas = new Label("Fichas:");
        Label error = new Label();

        Button avanzarButton = new Button();
        avanzarButton.setText("Avanzar Etapa");
        avanzarButton.setAlignment(Pos.CENTER_RIGHT);

        /*
        Nota:
        Aca tendriamos que decidir la forma en la que se notifica al usuario el resultado del ataque.
        Las opciones que pensamos son
        -Dejarlo tal como esta ahora (No informar)
        -Tener una label, al lado del boton de avanzar el turno
        -Generar un pop up despues de atacar
         */

        atacarButton.setOnAction(new BotonAtacarEventHandler(stage, controladorMaestro, paisesDesde,paisesHacia,cantidadDeFichas, error));
        VBox contSupDer = ContenedorSuperiorDerecho.crearContenedor(stage, controladorMaestro);
        contSupDer.setSpacing(10);

        HBox seleccionador = new HBox(paisesLabel,paisesDesde, atacados, paisesHacia,fichas, cantidadDeFichas,atacarButton, avanzarButton, error);
        seleccionador.setSpacing(10);
        VBox contInfIzq = new VBox(etapa,seleccionador);
        contInfIzq.setPadding(new Insets(1));

        HBox contSuperior = new HBox(imageView,contSupDer);
        contSuperior.setSpacing(5);
        HBox contInferior = new HBox(contInfIzq);

        VBox contenedor = new VBox(contSuperior,contInferior);
        contenedor.setPadding(new Insets(10));

        Scene sceneNueva = new Scene(contenedor, 1080, 720);

        avanzarButton.setOnAction(new BotonAvanzarAReagrupacionEventHandler(stage, controladorMaestro));
        return sceneNueva;

    }

}
