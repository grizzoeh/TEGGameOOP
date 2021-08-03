package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonAvanzarAAtaqueEventHandler;
import edu.fiuba.algo3.controladores.BotonCanjearTarjetasEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EscenaColocacionDeNuevasTropas {

    public static Scene crearEscenaColocacion(Stage stage, ControladorMaestro controladorMaestro){
        ImageView imageView = LectorDeImagenMapa.crearImagenDelMapa();

        VBox contSupDer = ContenedorSuperiorDerecho.crearContenedor(stage, controladorMaestro);
        contSupDer.setSpacing(10);

        var etapa = new Label("ETAPA DE COLOCACION");
        etapa.setFont(new Font("Serif", 18));

        Button avanzarButton = new Button();

        HBox seleccionador = SelectorDeColocacion.crearSelector(avanzarButton, controladorMaestro);

        Label error = new Label("");

        Button canjearTarjetas = new Button();
        canjearTarjetas.setText("Canjear Tarjetas");
        canjearTarjetas.setOnAction(new BotonCanjearTarjetasEventHandler(stage, controladorMaestro, error));


        seleccionador.setSpacing(10);
        seleccionador.getChildren().add(canjearTarjetas);
        seleccionador.getChildren().add(error);


        VBox contInfIzq = new VBox(etapa,seleccionador);
        contInfIzq.setPadding(new Insets(1));

        HBox contSuperior = new HBox(imageView,contSupDer);
        contSuperior.setSpacing(5);
        HBox contInferior = new HBox(contInfIzq);


        VBox contenedor = new VBox(contSuperior,contInferior);
        contenedor.setPadding(new Insets(10));

        Scene sceneNueva = new Scene(contenedor, 1080, 720);


        avanzarButton.setOnAction(new BotonAvanzarAAtaqueEventHandler(stage, controladorMaestro));

        return sceneNueva;

    }
}
