package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.BotonInicioEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Bienvenido al Juego Teg");
        Button boton = new Button();
        boton.setText("Iniciar Juego");

        VBox contenedorPrincipal = new VBox(label,boton);
        contenedorPrincipal.setSpacing(20);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        boton.setOnAction(new BotonInicioEventHandler(stage));
        var scene = new Scene(new StackPane(contenedorPrincipal), 1080, 720);
        stage.setScene(scene);
        stage.setTitle("Teg");
        stage.getIcons().add(new Image("file:imagenes/tegIcono.jpg"));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}