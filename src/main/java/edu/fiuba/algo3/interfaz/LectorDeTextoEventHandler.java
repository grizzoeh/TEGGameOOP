package edu.fiuba.algo3.interfaz;


import javafx.event.ActionEvent;
        import javafx.event.Event;
        import javafx.event.EventHandler;
        import javafx.scene.control.Button;
        import javafx.scene.input.KeyCode;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.paint.Color;

public class LectorDeTextoEventHandler implements EventHandler<KeyEvent> {

    private Button boton;

    public LectorDeTextoEventHandler(Button botonEnviar) {
        this.boton = botonEnviar;
    }

    @Override
    public void handle(KeyEvent event) {

        //System.out.println("TextoEventHandler -> handle: " + event.getCode());

        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(boton, new ActionEvent());

        }

    }
}
