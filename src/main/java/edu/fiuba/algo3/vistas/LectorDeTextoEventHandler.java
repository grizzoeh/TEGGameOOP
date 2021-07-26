package edu.fiuba.algo3.vistas;


import javafx.event.ActionEvent;
        import javafx.event.Event;
        import javafx.event.EventHandler;
        import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
        import javafx.scene.input.KeyEvent;

public class LectorDeTextoEventHandler implements EventHandler<KeyEvent> {

    private Button boton;

    public LectorDeTextoEventHandler(Button botonEnviar) {
        this.boton = botonEnviar;
    }

    @Override
    public void handle(KeyEvent event) {

        //System.out.println("TextoEventHandler -> handle: " + event.getCode());
        var label = new Label("Ingeresar cantidad de jugadores:");
        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(boton, new ActionEvent());

        }

    }
}
