package edu.fiuba.algo3.vistas.escenasEtapas;

import edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion.BotonAvanzarAColocacionEventHandler;
import edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion.BotonElegirPaisAReagruparEventHandler;
import edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion.BotonReagruparEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion.ContenedorSuperiorDerecho;
import edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion.LectorDeImagenMapa;
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

public class EscenaReagrupacionDeTropas {
    public static Scene crearEscenaReagrupacion(Stage stage, ControladorMaestro controladorMaestro) {

        ImageView imageView = LectorDeImagenMapa.crearImagenDelMapa();


        Label etapa = new Label("ETAPA DE REAGRUPACION");
        etapa.setFont(new Font("Serif", 18));

        var paisesLabel = new Label("Pais Desde:");
        ComboBox paisesDesde = new ComboBox();
        paisesDesde.getItems().addAll( controladorMaestro.paisesPuedenReagrupar());
        Label atacados = new Label("Pais Hacia:");


        ComboBox paisesHacia = new ComboBox();

        Button reagruparButton = new Button();
        reagruparButton.setText("Reagrupar");
        ComboBox cantidadDeFichas = new ComboBox();

        Label errores = new Label("");

        paisesDesde.setOnAction(new BotonElegirPaisAReagruparEventHandler(controladorMaestro, paisesDesde, paisesHacia, cantidadDeFichas));
        Label fichas = new Label("Fichas:");

        reagruparButton.setOnAction(new BotonReagruparEventHandler(controladorMaestro, paisesDesde, paisesHacia, cantidadDeFichas, errores));
        Button avanzarButton = new Button();
        avanzarButton.setText("Avanzar Etapa");
        avanzarButton.setAlignment(Pos.CENTER_RIGHT);

        VBox contSupDer = ContenedorSuperiorDerecho.crearContenedor(stage, controladorMaestro);
        contSupDer.setSpacing(10);

        HBox seleccionador = new HBox(paisesLabel,paisesDesde, atacados, paisesHacia,fichas, cantidadDeFichas,reagruparButton, avanzarButton, errores);
        seleccionador.setSpacing(10);
        VBox contInfIzq = new VBox(etapa,seleccionador);
        contInfIzq.setPadding(new Insets(1));

        HBox contSuperior = new HBox(imageView,contSupDer);
        contSuperior.setSpacing(5);
        HBox contInferior = new HBox(contInfIzq);

        VBox contenedor = new VBox(contSuperior,contInferior);
        contenedor.setPadding(new Insets(10));

        Scene sceneNueva = new Scene(contenedor, 1080, 720);

        avanzarButton.setOnAction(new BotonAvanzarAColocacionEventHandler(stage,controladorMaestro));

        return sceneNueva;

    }
}
