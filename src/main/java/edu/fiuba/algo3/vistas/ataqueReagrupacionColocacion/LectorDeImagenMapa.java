package edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.ProveedorDeConstantes;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LectorDeImagenMapa {
    public static ImageView crearImagenDelMapa(){

        Image image = new Image(ProveedorDeConstantes.obtenerMapa());
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(900);
        imageView.setPreserveRatio(true);


        return imageView;
    }
}
