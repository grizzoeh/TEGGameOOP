package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.BotonConfirmarJugadoresEventHandler;
import edu.fiuba.algo3.vistas.BotonInicioEventHandler;
import edu.fiuba.algo3.vistas.EnviarCantJugadoresEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
        var sceneBienvenida = new Scene(new StackPane(contenedorPrincipal), 1080, 720);
        var sceneCreacionJugadores = crearSceneJugadores(stage);
        boton.setOnAction(new BotonInicioEventHandler(stage,sceneCreacionJugadores));
        stage.setScene(sceneBienvenida);
        stage.setTitle("Teg");
        stage.getIcons().add(new Image("file:imagenes/tegIcono.jpg"));
        stage.show();

    }

    public Scene crearSceneJugadores(Stage stage){
        Scene sceneSiguiente = crearSceneComenzarJuego(stage);
        var label = new Label("Nueva Fase");
        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");
        final ComboBox cantJugadoresBox = new ComboBox();
        cantJugadoresBox.getItems().addAll(
                "2",
                "3",
                "4",
                "5",
                "6"
        );
        VBox vbox = new VBox();

        cantJugadoresBox.setOnAction(new EnviarCantJugadoresEventHandler(vbox,cantJugadoresBox));

        Label alertaJugadoreVacios = new Label();
        botonEnviar.setOnAction(new BotonConfirmarJugadoresEventHandler(vbox,alertaJugadoreVacios,stage,sceneSiguiente));

        var sceneNueva = new Scene(new HBox(label,vbox,cantJugadoresBox,botonEnviar,alertaJugadoreVacios), 1080, 720);
        return sceneNueva;
    }

    public Scene crearSceneComenzarJuego(Stage stage) {
        Image image = new Image("file:imagenes/mapaTeg.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(575);
        imageView.setPreserveRatio(true);
        var sceneNueva = new Scene(new HBox(imageView), 1080, 720);

        return sceneNueva;
    }


    public static void main(String[] args) {
        launch();
    }

}