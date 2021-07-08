package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega1 {
    @Test
    public void test01ColocacionDeEjercitos() {
        Teg teg = new Teg(2);
        Jugador jugador1 = new Jugador('Franco');
        Jugador jugador2 = new Jugador('Gonza');
        teg.asignarJugador(jugador1);
        teg.asignarJugador(jugador2);

        teg.obtenerDueño('Argentina');

    }
}
